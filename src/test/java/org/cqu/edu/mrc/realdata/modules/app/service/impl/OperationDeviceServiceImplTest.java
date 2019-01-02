package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/29 17:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OperationDeviceServiceImplTest {

    @Autowired
    OperationDeviceServiceImpl operationDeviceService;

    @Test
    public void saveOperationDeviceDO() {
    }

    @Test
    public void saveOperationDeviceDO1() {
    }

    @Test
    public void updateOperationDeviceDO() {

        ParseDataDTO parseDataDTO = new ParseDataDTO();
        parseDataDTO.setOperationNumber(1);

        operationDeviceService.updateOperationDeviceDO(parseDataDTO);
    }

    @Test
    public void getOperationDeviceDOSByOperationNumber() {
    }

    @Test
    public void getOperationDeviceDOSByCollectorMacAddress() {
    }

    @Test
    public void getOperationDeviceDOSByOperationHospitalCode() {
    }

    @Test
    public void getOperationDeviceDOSByOperationStartTimeBefore() {
    }

    @Test
    public void getOperationDeviceDOSByOperationStartTimeAfter() {
    }

    @Test
    public void getOperationDeviceDOSByOperationStartTimeBetween() {
    }

    @Test
    public void getOperationDeviceDOSByOperationTimeBetween() {
    }
}