package org.cqu.edu.mrc.realdata.modules.app.repository;


import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/11 17:32
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository repository;

    @Test
    public void save() {
        PatientDO patientDO = new PatientDO();
        patientDO.setPatientId("1");
        patientDO.setCreateTime(new Date());
        patientDO.setUpdateTime(new Date());
        patientDO.setOpn("1");
        repository.save(patientDO);
    }

    @Test
    public void findPatientDOByPatientId() {
        PatientDO patientDO = repository.findPatientDOByPatientId("1");
        Assert.assertNotNull(patientDO);
    }
}