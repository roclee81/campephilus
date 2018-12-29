package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import org.cqu.edu.mrc.realdata.modules.app.dto.ResultDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.form.MedicalDataForm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/25 13:17
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DataProcessServiceImplTest {

    @Autowired
    DataProcessServiceImpl dataProcessService;

    @Test
    public void parseJson() {
        MedicalDataForm medicalDataForm = dataProcessService.parseJson("{\"code\":167,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"deviceId\":\"deviceId\",\"deviceDataNumber\":\"0\",\"deviceData\":{\"CO2\":\"1\"}}}}");
        Assert.assertNotNull(medicalDataForm);
    }

    @Test
    public void processCode() {
//        MedicalDataForm medicalDataForm1 = dataProcessService.parseJson("{\"code\":167,\"msg\":{\"mac\":\"mac\",\"opn\":1,\"data\":{\"deviceId\":\"deviceId\",\"deviceDataNumber\":\"0\",\"deviceData\":{\"CO2\":\"1\"}}}}");
//        int result1 = dataProcessService.processCode(medicalDataForm1);
//        Assert.assertTrue(result1 > 0);
//
//        MedicalDataForm medicalDataForm2 = dataProcessService.parseJson("{\"code\":167,\"msg\":{\"mac\":\"mac\",\"opn\":1}}");
//        int result2 = dataProcessService.processCode(medicalDataForm2);
//        Assert.assertTrue(result2 < 0);
//
//        MedicalDataForm medicalDataForm3 = dataProcessService.parseJson("{\"msg\":{\"mac\":\"mac\",\"opn\":1}}");
//        int result3 = dataProcessService.processCode(medicalDataForm3);
//        Assert.assertTrue(result3 < 0);
//
//        MedicalDataForm medicalDataForm4 = dataProcessService.parseJson("{\"code\":155,\"msg\":{\"mac\":\"mac\",\"opn\":2,\"data\":{\"hospitalCode\":\"165065\",\"deviceInformation\":{}}}}");
//        int result4 = dataProcessService.processCode(medicalDataForm4);
//        Assert.assertTrue(result4 > 0);
//
//        MedicalDataForm medicalDataForm5 = dataProcessService.parseJson("{\"code\":161,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"patientId\":\"value\",\"patientData\":{}}}}");
//        int result5 = dataProcessService.processCode(medicalDataForm5);
//        Assert.assertTrue(result5 > 0);
//
//        MedicalDataForm medicalDataForm6 = dataProcessService.parseJson("{\"code\":161,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"patientId\":\"value\",\"patientData\":\"data\"}}}");
//        int result6 = dataProcessService.processCode(medicalDataForm6);
//        Assert.assertTrue(result6 < 0);
//
//        MedicalDataForm medicalDataForm7 = dataProcessService.parseJson("{\"code\":173,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"markNumber\":1,\"markType\":1,\"markMessage\":{}}}}");
//        int result7 = dataProcessService.processCode(medicalDataForm7);
//        Assert.assertTrue(result7 > 0);
//
//        MedicalDataForm medicalDataForm8 = dataProcessService.parseJson("{\"code\":151,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"patientId\":\"patientId\"}}}");
//        int result8 = dataProcessService.processCode(medicalDataForm8);
//        Assert.assertTrue(result8 > 0);

        MedicalDataForm medicalDataForm8 = dataProcessService.parseJson("{\"code\":155,\"msg\":{\"mac\":\"mac\",\"operationNumber\":\"1\",\"data\":{\"operationStartTime\":\"1546073420000\",\"hospitalCode\":\"0147\",\"deviceInformation\":{}}}}");
        ResultDataDTO resultDataDTO = dataProcessService.processMedicalData(medicalDataForm8);
        Assert.assertTrue(resultDataDTO.getCode() > 0);


    }
}