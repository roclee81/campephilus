package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationDeviceDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/28 16:49
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OperationDeviceRepositoryTest {

    @Autowired
    private OperationDeviceRepository operationDeviceRepository;

    @Test
    public void save() {
        OperationDeviceDO operationDeviceDO = new OperationDeviceDO();
        operationDeviceDO.setGmtCreate(new Date());
        operationDeviceDO.setCollectorMacAddress("asdasdasda");
        operationDeviceDO.setOperationNumber(1);
        operationDeviceRepository.save(operationDeviceDO);
    }

}