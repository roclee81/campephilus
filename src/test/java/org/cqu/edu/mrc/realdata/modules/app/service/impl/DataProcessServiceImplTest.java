package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import org.cqu.edu.mrc.realdata.modules.app.dto.MedicalDataDTO;
import org.junit.Assert;
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
        MedicalDataDTO medicalDataDTO = dataProcessService.parseJson("{\"code\":167,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"deviceId\":\"deviceId\",\"deviceDataNumber\":\"0\",\"deviceData\":{\"CO2\":\"1\"}}}}");
        Assert.assertNotNull(medicalDataDTO);
    }

    @Test
    public void processCode() {
        MedicalDataDTO medicalDataDTO1 = dataProcessService.parseJson("{\"code\":167,\"msg\":{\"mac\":\"mac\",\"opn\":1,\"data\":{\"deviceId\":\"deviceId\",\"deviceDataNumber\":\"0\",\"deviceData\":{\"CO2\":\"1\"}}}}");
        int result1 = dataProcessService.processCode(medicalDataDTO1);
        Assert.assertTrue(result1 > 0);

        MedicalDataDTO medicalDataDTO2 = dataProcessService.parseJson("{\"code\":167,\"msg\":{\"mac\":\"mac\",\"opn\":1}}");
        int result2 = dataProcessService.processCode(medicalDataDTO2);
        Assert.assertTrue(result2 < 0);

        MedicalDataDTO medicalDataDTO3 = dataProcessService.parseJson("{\"msg\":{\"mac\":\"mac\",\"opn\":1}}");
        int result3 = dataProcessService.processCode(medicalDataDTO3);
        Assert.assertTrue(result3 < 0);

        MedicalDataDTO medicalDataDTO4 = dataProcessService.parseJson("{\"code\":155,\"msg\":{\"mac\":\"mac\",\"opn\":2,\"data\":{\"hospitalCode\":\"165065\",\"deviceInformation\":{}}}}");
        int result4 = dataProcessService.processCode(medicalDataDTO4);
        Assert.assertTrue(result4 > 0);

        MedicalDataDTO medicalDataDTO5 = dataProcessService.parseJson("{\"code\":161,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"patientId\":\"value\",\"patientData\":{}}}}");
        int result5 = dataProcessService.processCode(medicalDataDTO5);
        Assert.assertTrue(result5 > 0);

        MedicalDataDTO medicalDataDTO6 = dataProcessService.parseJson("{\"code\":161,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"patientId\":\"value\",\"patientData\":\"data\"}}}");
        int result6 = dataProcessService.processCode(medicalDataDTO6);
        Assert.assertTrue(result6 < 0);

        MedicalDataDTO medicalDataDTO7 = dataProcessService.parseJson("{\"code\":173,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"markNumber\":1,\"markType\":1,\"markMessage\":{}}}}");
        int result7 = dataProcessService.processCode(medicalDataDTO7);
        Assert.assertTrue(result7 > 0);

        MedicalDataDTO medicalDataDTO8 = dataProcessService.parseJson("{\"code\":151,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"patientId\":\"patientId\"}}}");
        int result8 = dataProcessService.processCode(medicalDataDTO8);
        Assert.assertTrue(result8 > 0);


    }
}