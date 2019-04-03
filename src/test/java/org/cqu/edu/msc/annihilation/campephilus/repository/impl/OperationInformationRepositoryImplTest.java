package org.cqu.edu.msc.annihilation.campephilus.repository.impl;

import org.cqu.edu.msc.annihilation.campephilus.core.repository.impl.OperationInformationRepositoryImpl;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtil;
import org.cqu.edu.msc.annihilation.campephilus.core.dataobject.OperationInformationDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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
//        Assert.assertTrue(result.getTotalElements() > 0);
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
        PageRequest pageRequest = PageRequest.of(0, 100);
        Page<OperationInformationDO> result = operationInformationRepository.findOperationInformationDOSByOperationStartTimeBetween(TimeStampUtil.getWeekBeforeDate(), new Date(), pageRequest);
        Assert.assertTrue(result.getTotalElements() > 0);
    }

    @Test
    public void findOperationInformationDOSByOperationTimeBetween() {
        PageRequest pageRequest = PageRequest.of(0, 100);
        Page<OperationInformationDO> result = operationInformationRepository.findOperationInformationDOSByOperationTimeBetween(-100000L, 90000000L, pageRequest);
        Assert.assertEquals(0, result.getTotalElements());
    }

    @Test
    public void saveOperationInformationDO() {
    }

    @Test
    public void findOperationInformationDOS() {
        PageRequest page = PageRequest.of(0, 100);
        Page<OperationInformationDO> result = operationInformationRepository.findOperationInformationDOS(page);
        Assert.assertTrue(result.getTotalElements() > 0);
    }

    @Test
    public void countOperationInformationDOS() {
        int result = operationInformationRepository.countOperationInformationDOS();
        Assert.assertTrue(result > 0);
    }
}