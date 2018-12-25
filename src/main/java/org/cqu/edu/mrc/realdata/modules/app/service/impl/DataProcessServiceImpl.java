package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
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

        if (null == medicalDataDTO) {
            return MqttEnum.DATA_FORMAT_ERROR.getCode();
        }

        ParseDataDTO parseDataDTO = processMsg(medicalDataDTO);

        if (null == parseDataDTO){
            return MqttEnum.DATA_FORMAT_ERROR.getCode();
        }

        Integer code = parseDataDTO.getCode();

        if (MqttEnum.DATA_FORMAT_ERROR.getCode().equals(code)) {
            return code + 1;
        }

        if (MqttEnum.DEVICE_DATA.getCode().equals(code)) {
            deviceService.saveDeviceDO(parseDataDTO);
            return code + 1;
        }

        return 0;
    }

    private ParseDataDTO processMsg(MedicalDataDTO medicalDataDTO) {
        try {
            Map map = medicalDataDTO.getMsg();
            String macAddress = map.containsKey("mac") ? (String) map.get("mac") : null;
            Integer operationNumber = map.containsKey("opn") ? (Integer) map.get("opn") : null;
            Map data = map.containsKey("data") ? (Map) map.get("data") : null;
            return new ParseDataDTO(medicalDataDTO.getCode(), macAddress, operationNumber, data);
        } catch (ClassCastException | NullPointerException exception) {
            return null;
        }
    }
}