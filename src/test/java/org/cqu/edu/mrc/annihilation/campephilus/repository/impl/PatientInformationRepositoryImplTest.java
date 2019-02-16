package org.cqu.edu.mrc.annihilation.campephilus.repository.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.PatientInformationDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/9 0:30
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientInformationRepositoryImplTest {

    @Autowired
    PatientInformationRepositoryImpl patientInformationRepository;

    @Test
    public void findPatientInformationDOSByPatientIdAndOperationNumber() {
        PatientInformationDO result = patientInformationRepository.findPatientInformationDOByPatientIdAndOperationNumber("012121", 1);
        Assert.assertNotNull(result);
    }

    @Test
    public void findPatientInformationDOSByPatientId() {
        PageRequest pageRequest = PageRequest.of(0, 100);
        Page<PatientInformationDO> result = patientInformationRepository.findPatientInformationDOSByPatientId("012121", pageRequest);
        Assert.assertTrue(result.getTotalElements() > 0);
    }

    @Test
    public void savePatientInformationDO() {
        PatientInformationDO patientInformationDO = new PatientInformationDO();
        patientInformationDO.setGmtCreate(new Date());
        patientInformationDO.setGmtModified(new Date());
        patientInformationDO.setPostoperativeData(new HashMap());
        patientInformationDO.setOperationNumber(3);
        patientInformationDO.setPatientId("01212100");
        patientInformationDO.setPreoperativeData(new HashMap());
        patientInformationDO.setPatientData(new HashMap());
        patientInformationRepository.savePatientInformationDO(patientInformationDO);
    }
}