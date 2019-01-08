package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 14:36
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DeviceServiceImplTest {

    @Autowired
    DeviceServiceImpl deviceService;

    @Test
    public void getDeviceDOSByDeviceIdAndOperationNumber() {
    }

    @Test
    public void getDeviceDOSByDeviceId() {
    }

    @Test
    public void getDeviceDOSByOperationNumber() {
        PageRequest pageRequest = PageRequest.of(0, 100);
        Map<String, Object> result = deviceService.getDeviceDOSByOperationNumber(1, pageRequest);
        Assert.assertTrue(result.size() > 0);
    }

    @Test
    public void saveDeviceDO() {
    }
}