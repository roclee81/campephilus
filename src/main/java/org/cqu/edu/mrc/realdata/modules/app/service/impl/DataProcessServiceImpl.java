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

    private static Gson gson;

    static {
        gson = new Gson();
    }

    @Autowired
    public DataProcessServiceImpl(DeviceServiceImpl deviceService, OperationMarkServiceImpl operationMarkService, OperationDeviceServiceImpl operationDeviceService) {
        this.deviceService = deviceService;
        this.operationMarkService = operationMarkService;
        this.operationDeviceService = operationDeviceService;
    }

    @Override
    public MedicalDataDTO parseJson(String jsonBuffer) {
        try {
            return gson.fromJson(jsonBuffer, MedicalDataDTO.class);
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

        if (result) {
            return MqttEnum.DATA_FORMAT_ERROR.getCode();
        }

        return code + 1;
    }

    /**
     * 对接收到的实体类MedicalDataDTO进行第一步解析
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

            int operationNumber = (int) (double) msg.getOrDefault(DataConstants.OPERATION_NUMBER, 0.0);
            Map dataMap = (Map) msg.getOrDefault(DataConstants.DATA_MAP, new HashMap<>(16));
            return new ParseDataDTO(medicalDataDTO.getCode(), macAddress, operationNumber, dataMap);
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            return null;
        }
    }
}