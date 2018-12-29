package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.common.enums.ReplyCodeEnum;
import org.cqu.edu.mrc.realdata.common.enums.RequestCodeEnum;
import org.cqu.edu.mrc.realdata.modules.app.form.MedicalDataForm;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ResultDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.service.DataProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Slf4j
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
    public MedicalDataForm parseJson(String jsonBuffer) {
        try {
            return new Gson().fromJson(jsonBuffer, MedicalDataForm.class);
        } catch (JsonSyntaxException jsonSyntaxException) {
            return null;
        }
    }

    @Override
    public ResultDataDTO processMedicalData(MedicalDataForm medicalDataForm) {

        if (null == medicalDataForm || null == medicalDataForm.getCode()) {
            return new ResultDataDTO(ReplyCodeEnum.DATA_FORMAT_ERROR.getCode(), null);
        }

        ParseDataDTO parseDataDTO = processMsg(medicalDataForm);

        return processCode(parseDataDTO);

    }

    /**
     * <ul>
     * <li>通过解析Code判断请求方式并回复</li>
     * <li>处理一个大型的分支，目前没有想到有什么其余的方式写该方法</li>
     * <li>目前仅处理在注册后的数据，即形成了mqtt话题后的数据</li>
     * </ul>
     *
     * @param parseDataDTO 初次解析的DTO
     * @return 按通讯规约返回Code
     */
    private ResultDataDTO processCode(ParseDataDTO parseDataDTO) {

        if (null == parseDataDTO) {
            return new ResultDataDTO(ReplyCodeEnum.DATA_FORMAT_ERROR.getCode(), null);
        }

        int code = parseDataDTO.getCode();

        // 接收数据存储的结果
        boolean result = false;

        // 准备开始手术，获取手术顺序号的情况
        if (RequestCodeEnum.OPERATION_READY.getCode().equals(code)) {
            parseDataDTO.setOperationNumber(getNewOperationNumber());
            result = true;
        }

        // 手术过程基本信息
        if (RequestCodeEnum.OPERATION_DEVICE.getCode().equals(code)) {
            result = operationDeviceService.saveOperationDeviceDO(parseDataDTO);
        }

        // 更新手术过程基本信息
        if (RequestCodeEnum.OPERATION_END.getCode().equals(code)) {
            result = operationDeviceService.updateOperationDeviceDO(parseDataDTO);
        }

        // 处理传输的医疗仪器数据的情况
        if (RequestCodeEnum.DEVICE_DATA.getCode().equals(code)) {
            result = deviceService.saveDeviceDO(parseDataDTO);
        }

        // 处理上传的患者数据的情况
        if (RequestCodeEnum.PATIENT_INFO.getCode().equals(code)) {
            result = preoperativePatientService.savePreoperativePatientDO(parseDataDTO);
        }

        // 处理上传的手术过程中标记的情况
        if (RequestCodeEnum.OPERATION_MARK.getCode().equals(code)) {
            result = operationMarkService.saveOperationMarkDO(parseDataDTO);
        }

        // 处理了上传病人Id和手术号的情况
        if (RequestCodeEnum.OPERATION_READY.getCode().equals(code)) {
            result = patientIdOperationNumberService.savePatientIdOperationNumberDO(parseDataDTO);
        }

        for (RequestCodeEnum requestCodeEnum : RequestCodeEnum.values()) {
            if (requestCodeEnum.getCode().equals(code)) {
                result = true;
            }
        }

        Map<String, String> map = new HashMap<>(16);
        map.put(DataConstants.MAC, parseDataDTO.getMacAddress());
        map.put(DataConstants.OPERATION_NUMBER, String.valueOf(parseDataDTO.getOperationNumber()));

        if (!result) {
            return new ResultDataDTO(ReplyCodeEnum.DATA_FORMAT_ERROR.getCode(), map);
        }
        return new ResultDataDTO(code + 1, map);
    }

    /**
     * 得到新的手术顺序号
     * 根据patientIdOperationNumber表计算得到表
     * 目前根据synchronized来实现多线程
     *
     * @return 下一个新的手术顺序号
     */
    private synchronized Integer getNewOperationNumber() {
        return patientIdOperationNumberService.countAll() + 1;
    }

    /**
     * 对接收到的实体类MedicalDataDTO进行第一步解析
     * 缺少mac、operationNumber字段直接返回null
     * 但是对于需要请求operationNumber的情况只检查是否有mac
     *
     * @param medicalDataForm 接收到的实体类
     * @return 初次解析后的实体类
     */
    private ParseDataDTO processMsg(MedicalDataForm medicalDataForm) {
        try {
            Map msg = medicalDataForm.getMsg();

            // 检查mac字段，如何没有直接返回null
            String macAddress;
            if (msg.containsKey(DataConstants.MAC)) {
                macAddress = (String) msg.get(DataConstants.MAC);
            } else {
                return null;
            }

            if (RequestCodeEnum.OPERATION_READY.getCode().equals(medicalDataForm.getCode())) {
                return new ParseDataDTO(medicalDataForm.getCode(), macAddress, null, null);
            }

            // 检查operationNumber字段，如何没有直接返回null
            int operationNumber;
            if (msg.containsKey(DataConstants.OPERATION_NUMBER)) {
                operationNumber = Integer.parseInt((String) msg.get(DataConstants.OPERATION_NUMBER));
            } else {
                return null;
            }

            // 检查data字段，如何没有直接返回null
            Map dataMap;
            if (msg.containsKey(DataConstants.DATA_MAP)) {
                dataMap = (Map) msg.get(DataConstants.DATA_MAP);
            } else {
                dataMap = null;
            }

            return new ParseDataDTO(medicalDataForm.getCode(), macAddress, operationNumber, dataMap);
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            log.error("MedicalDataForm:{},Exception:{}", medicalDataForm.toString(), exception.toString());
            return null;
        }
    }
}