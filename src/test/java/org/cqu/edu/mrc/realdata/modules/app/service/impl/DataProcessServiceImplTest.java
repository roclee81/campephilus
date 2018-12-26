package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import org.cqu.edu.mrc.realdata.modules.app.dto.MedicalDataDTO;
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
        System.out.println(medicalDataDTO);
    }

    @Test
    public void processCode() {
//        MedicalDataDTO medicalDataDTO1 = dataProcessService.parseJson("{\"code\":167,\"msg\":{\"mac\":\"mac\",\"opn\":1,\"data\":{\"deviceId\":\"deviceId\",\"deviceDataNumber\":\"0\",\"deviceData\":{\"CO2\":\"1\"}}}}");
//        dataProcessService.processCode(medicalDataDTO1);
//
//        MedicalDataDTO medicalDataDTO2 = dataProcessService.parseJson("{\"code\":167,\"msg\":{\"mac\":\"mac\",\"opn\":1}}");
//        dataProcessService.processCode(medicalDataDTO2);

//        MedicalDataDTO medicalDataDTO3 = dataProcessService.parseJson("{\"msg\":{\"mac\":\"mac\",\"opn\":1}}");
//        dataProcessService.processCode(medicalDataDTO3);

//        MedicalDataDTO medicalDataDTO4 = dataProcessService.parseJson("{\"code\":155,\"msg\":{\"mac\":\"mac\",\"opn\":2,\"data\":{\"hospitalCode\":\"165065\",\"deviceInformation\":{}}}}");
//        dataProcessService.processCode(medicalDataDTO4);

//        MedicalDataDTO medicalDataDTO5 = dataProcessService.parseJson("{\"code\":161,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"patientId\":\"value\",\"patientData\":{}}}}");
//        dataProcessService.processCode(medicalDataDTO5);

//        MedicalDataDTO medicalDataDTO5 = dataProcessService.parseJson("{\"code\":161,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"patientId\":\"value\",\"patientData\":\"data\"}}}");
//        dataProcessService.processCode(medicalDataDTO5);

        MedicalDataDTO medicalDataDTO5 = dataProcessService.parseJson("{\"code\":173,\"msg\":{\"mac\":\"mac\",\"opn\":0,\"data\":{\"markNumber\":1,\"markType\":1,\"markMessage\":{}}}}");
        dataProcessService.processCode(medicalDataDTO5);

    }
}