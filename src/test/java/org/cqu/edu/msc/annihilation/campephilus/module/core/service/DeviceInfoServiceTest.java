package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/8 10:59
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DeviceInfoServiceTest {

    @Autowired
    private DeviceInfoCRUDService deviceInfoService;

    @Test
    public void saveDeviceInfo() {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setId(2);
        deviceInfo.setDeviceCode("-1");
        deviceInfo.setDeviceServiceLife(BigDecimal.valueOf(1));
        deviceInfo.setDeviceSerialNumber("-2");
        deviceInfo.setGmtCreate(new Date());
        deviceInfo.setGmtModified(new Date());
        deviceInfoService.saveDeviceInfo(deviceInfo);
    }

    @Test
    public void updateDeviceInfo() {

    }


}