package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.temp;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.DataGetNewestFactory;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataGetNewestService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/20
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class TempService {

    @Autowired
    private OperationDeviceInfoService operationDeviceInfoService;

    public Object get(int operationNumber, String serialNumber) {
        OperationDeviceInfo operationDeviceInfo = operationDeviceInfoService.getByOperationNumber(operationNumber);
        int deviceCode = 0;
        if (serialNumber.equals(operationDeviceInfo.getDeviceSerialNumber0())) {
            deviceCode = operationDeviceInfo.getDeviceCode0();
        } else if (serialNumber.equals(operationDeviceInfo.getDeviceSerialNumber1())) {
            deviceCode = operationDeviceInfo.getDeviceCode1();
        } else if (serialNumber.equals(operationDeviceInfo.getDeviceSerialNumber2())) {
            deviceCode = operationDeviceInfo.getDeviceCode2();
        } else if (serialNumber.equals(operationDeviceInfo.getDeviceSerialNumber3())) {
            deviceCode = operationDeviceInfo.getDeviceCode3();
        } else if (serialNumber.equals(operationDeviceInfo.getDeviceSerialNumber4())) {
            deviceCode = operationDeviceInfo.getDeviceCode4();
        } else if (serialNumber.equals(operationDeviceInfo.getDeviceSerialNumber5())) {
            deviceCode = operationDeviceInfo.getDeviceCode5();
        }
        DataGetNewestService service = DataGetNewestFactory.getDataGetNewestService(deviceCode);
        return Objects.isNull(service) ? null : service.getNewest(operationNumber, serialNumber);
    }
}