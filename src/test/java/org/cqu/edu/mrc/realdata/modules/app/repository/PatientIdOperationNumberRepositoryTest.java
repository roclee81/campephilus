package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientIdOperationNumberDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/27 14:22
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientIdOperationNumberRepositoryTest {

    @Autowired
    private PatientIdOperationNumberRepository patientIdOperationNumberRepository;

    @Test
    public void save() {
        PatientIdOperationNumberDO patientIdOperationNumberDO = new PatientIdOperationNumberDO();
        patientIdOperationNumberDO.setOperationNumber(2);
        patientIdOperationNumberDO.setPatientId("2");
        patientIdOperationNumberDO.setGmtCreate(new Date());
        patientIdOperationNumberRepository.savePatientIdOperationNumberDO(patientIdOperationNumberDO);
    }

    @Test
    public void findPatientIdOperationNumberDOSByPatientId() {
        Pageable pageable = PageRequest.of(1, 100);
        Page<PatientIdOperationNumberDO> patientIdOperationNumberDOPage = patientIdOperationNumberRepository.findPatientIdOperationNumberDOSByPatientId("1", pageable);
        Assert.assertTrue(patientIdOperationNumberDOPage.getTotalElements() > 0);
    }

    @Test
    public void findPatientIdOperationNumberDOByOperationNumber() {
        Pageable pageable = PageRequest.of(1, 100);
        Page<PatientIdOperationNumberDO> patientIdOperationNumberDOPage = patientIdOperationNumberRepository.findPatientIdOperationNumberDOSByPatientId("1", pageable);
        Assert.assertTrue(patientIdOperationNumberDOPage.getTotalElements() > 0);
    }

    @Test
    public void countAll() {
        int result = patientIdOperationNumberRepository.countAll();
        Assert.assertTrue(result > 0);
    }


}