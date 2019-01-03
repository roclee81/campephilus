package org.cqu.edu.mrc.realdata.modules.app.repository.impl;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.DeviceDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 15:25
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DeviceRepositoryImplTest {

    @Autowired
    private DeviceRepositoryImpl deviceRepository;

    @Test
    public void save() {
        DeviceDO deviceDO = new DeviceDO();
        deviceDO.setDeviceDataNumber(2);
        deviceDO.setOperationNumber(2);
        deviceRepository.save(deviceDO, "test");
    }

    @Test
    public void findDeviceDOSByOperationNumber() {
        PageRequest request = PageRequest.of(0, 100);
        Page<DeviceDO> result = deviceRepository.findDeviceDOSByDeviceIdAndOperationNumber("i123", 1, request);
        Assert.assertTrue(result.getTotalElements() > 0);
    }

    @Test
    public void countDeviceDOSByDeviceId() {
        int result = deviceRepository.countDeviceDOSByDeviceId("test");
        Assert.assertTrue(result > 0);
    }
}