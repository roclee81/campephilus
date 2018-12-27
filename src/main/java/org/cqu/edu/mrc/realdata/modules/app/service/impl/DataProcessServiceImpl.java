package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.common.enums.MqttEnum;
import org.cqu.edu.mrc.realdata.modules.app.dto.MedicalDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.service.DataProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/24 21:41
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class DataProcessServiceImpl implements DataProcessService {

    private final DeviceServiceImpl deviceService;
    private final OperationMarkServiceImpl operationMarkService;
    private final OperationDeviceServiceImpl operationDeviceService;
    private final PreoperativePatientServiceImpl preoperativePatientService;
    private final PatientIdOperationNumberServiceImpl patientIdOperationNumberService;

    @Autowired
    public DataProcessServiceImpl(DeviceServiceImpl deviceService, OperationMarkServiceImpl operationMarkService, OperationDeviceServiceImpl operationDeviceService, PreoperativePatientServiceImpl preoperativePatientService, PatientIdOperationNumberServiceImpl patientIdOperationNumberService) {
        this.deviceService = deviceService;
        this.operationMarkService = operationMarkService;
        this.operationDeviceService = operationDeviceService;
        this.preoperativePatientService = preoperativePatientService;
        this.patientIdOperationNumberService = patientIdOperationNumberService;
    }

    @Override
    public MedicalDataDTO parseJson(String jsonBuffer) {
        try {
            return new Gson().fromJson(jsonBuffer, MedicalDataDTO.class);
        } catch (JsonSyntaxException jsonSyntaxException) {
            return null;
        }
    }

    @Override
    public Integer processCode(MedicalDataDTO medicalDataDTO) {

        if (null == medicalDataDTO || null == medicalDataDTO.getCode()) {
            return MqttEnum.DATA_FORMAT_ERROR.getCode();
        }

        ParseDataDTO parseDataDTO = processMsg(medicalDataDTO);

        if (null == parseDataDTO) {
            return MqttEnum.DATA_FORMAT_ERROR.getCode();
        }

        int code = parseDataDTO.getCode();

        // 接收数据存储的结果
        boolean result = false;

        // 手术过程设备信息
        if (MqttEnum.OPERATION_DEVICE.getCode().equals(code)) {
            result = operationDeviceService.saveOperationDeviceDO(parseDataDTO);
        }

        // 处理传输的医疗仪器数据的情况
        if (MqttEnum.DEVICE_DATA.getCode().equals(code)) {
            result = deviceService.saveDeviceDO(parseDataDTO);
        }

        // 处理上传的患者数据的情况
        if (MqttEnum.PATIENT_INFO.getCode().equals(code)) {
            result = preoperativePatientService.savePreoperativePatientDO(parseDataDTO);
        }

        // 处理上传的手术过程中标记的情况
        if (MqttEnum.OPERATION_MARK.getCode().equals(code)) {
            result = operationMarkService.saveOperationMarkDO(parseDataDTO);
        }

        // 处理了上传病人Id和手术号的情况
        if (MqttEnum.OPERATION_READY.getCode().equals(code)) {
            result = patientIdOperationNumberService.savePatientIdOperationNumberDO(parseDataDTO);
        }

        if (result) {
            return MqttEnum.DATA_FORMAT_ERROR.getCode();
        }

        return code + 1;
    }

    @Override
    public synchronized Integer getNewOperationNumber() {
        return patientIdOperationNumberService.countAll() + 1;
    }

    /**
     * 对接收到的实体类MedicalDataDTO进行第一步解析
     * 缺少mac、operationNumber字段直接返回null
     *
     * @param medicalDataDTO 接收到的实体类
     * @return 初次解析后的实体类
     */
    private ParseDataDTO processMsg(MedicalDataDTO medicalDataDTO) {
        try {
            Map<String, Object> msg = medicalDataDTO.getMsg();

            // 检查mac字段，如何没有直接返回null
            String macAddress;
            if (msg.containsKey(DataConstants.MAC)) {
                macAddress = (String) msg.get(DataConstants.MAC);
            } else {
                return null;
            }

            // 检查operationNumber字段，如何没有直接返回null
            int operationNumber;
            if (msg.containsKey(DataConstants.OPERATION_NUMBER)) {
                operationNumber = (int) (double) msg.get(DataConstants.OPERATION_NUMBER);
            } else {
                return null;
            }

            // 该Map可以为空
            Map dataMap = (Map) msg.getOrDefault(DataConstants.DATA_MAP, new HashMap<>(16));

            return new ParseDataDTO(medicalDataDTO.getCode(), macAddress, operationNumber, dataMap);
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            return null;
        }
    }
}