package org.cqu.edu.mrc.realdata.modules.app.repository.impl;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationInformationDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/3 17:10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OperationInformationRepositoryImplTest {

    @Autowired
    private OperationInformationRepositoryImpl operationInformationRepository;

    @Test
    public void findOperationInformationDOSByPatientId() {
        PageRequest pageRequest = PageRequest.of(0, 100);
        Page<OperationInformationDO> result = operationInformationRepository.findOperationInformationDOSByPatientId("1022", pageRequest);
        Assert.assertTrue(result.getTotalElements() > 0);
    }

    @Test
    public void findOperationInformationDOByOperationNumber() {
        OperationInformationDO result = operationInformationRepository.findOperationInformationDOByOperationNumber(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOperationInformationDOSByOperationHospitalCode() {
        PageRequest pageRequest = PageRequest.of(0, 100);
        Page<OperationInformationDO> result = operationInformationRepository.findOperationInformationDOSByOperationHospitalCode("0147", pageRequest);
        Assert.assertTrue(result.getTotalElements() > 0);
    }

    @Test
    public void findOperationInformationDOSByOperationStartTimeBetween() {
    }

    @Test
    public void findOperationInformationDOSByOperationTimeBetween() {
    }

    @Test
    public void saveOperationInformationDO() {
    }

    @Test
    public void findAll() {
        PageRequest page = PageRequest.of(0, 100);
        Page<OperationInformationDO> result = operationInformationRepository.findOperationInformationDOS(page);
        Assert.assertTrue(result.getTotalElements() > 0);
    }

    @Test
    public void countAll() {
        int result = operationInformationRepository.countOperationInformationDOS();
        Assert.assertTrue(result > 0);
    }
}