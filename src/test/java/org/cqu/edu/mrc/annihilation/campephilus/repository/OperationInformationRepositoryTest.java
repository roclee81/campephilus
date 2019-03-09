package org.cqu.edu.mrc.annihilation.campephilus.repository;

import com.google.gson.Gson;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.OperationInformationDO;
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
import java.util.Map;

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
public class OperationInformationRepositoryTest {

    @Autowired
    private OperationInformationRepository operationInformationRepository;

    @Test
    public void save() {
//        OperationInformationDO result = new Gson().fromJson("{\"operationInfo\":{\"patientId\":\"patientId\",\"operationHospitalCode\":\"0147\",\"operationStartTime\":\"2004-05-03T17:30:08+08:00\"},\"deviceInformation\":[{\"deviceType\":1,\"serialNumber\":\"SN123123\",\"serviceLife\":2},{\"deviceType\":2,\"serialNumber\":\"SN1231233\",\"serviceLife\":3}]}", OperationInformationDO.class);

        OperationInformationDO operationInformationDO = new OperationInformationDO();
        operationInformationDO.setOperationNumber(2);
        operationInformationDO.setPatientId("2131231231");
        operationInformationDO.setGmtCreate(new Date());
        OperationInformationDO.OperationInfo operationInfo = new OperationInformationDO.OperationInfo();
        operationInfo.setOperationHospitalCode("test");
        operationInformationDO.setOperationInfo(operationInfo);
        operationInformationRepository.saveOperationInformationDO(operationInformationDO);
//        operationInformationRepository.saveOperationInformationDO(result);
    }

    @Test
    public void findPatientIdOperationNumberDOSByPatientId() {
        Pageable pageable = PageRequest.of(1, 100);
        Page<OperationInformationDO> patientIdOperationNumberDOPage = operationInformationRepository.findOperationInformationDOSByPatientId("1", pageable);
//        Assert.assertTrue(patientIdOperationNumberDOPage.getTotalElements() > 0);
    }

    @Test
    public void findPatientIdOperationNumberDOByOperationNumber() {
        Pageable pageable = PageRequest.of(1, 100);
        Page<OperationInformationDO> patientIdOperationNumberDOPage = operationInformationRepository.findOperationInformationDOSByPatientId("1", pageable);
//        Assert.assertTrue(patientIdOperationNumberDOPage.getTotalElements() > 0);
    }

    @Test
    public void countAll() {
        int result = operationInformationRepository.countOperationInformationDOS();
        Assert.assertTrue(result > 0);
    }


}