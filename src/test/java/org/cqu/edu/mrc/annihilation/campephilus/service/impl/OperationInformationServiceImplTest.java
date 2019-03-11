package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.service.OperationInformationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/9 21:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OperationInformationServiceImplTest {

    @Autowired
    private OperationInformationService operationInformationService;

    @Test
    public void listOperationInformationDOSByPatientId() {
    }

    @Test
    public void listOperationInformationDOSByOperationState() {
    }

    @Test
    public void listOperationInformationDTOSByPatientId() {
    }

    @Test
    public void getOperationInformationDOByOperationNumber() {
    }

    @Test
    public void getOperationInformationDTOByOperationNumber() {
    }

    @Test
    public void listOperationInformationDOSByOperationStartTimeBetween() {
    }

    @Test
    public void listOperationInformationDTOSByOperationStartTimeBetween() {
    }

    @Test
    public void listOperationInformationDOSByOperationTimeBetween() {
    }

    @Test
    public void listOperationInformationDTOSByOperationTimeBetween() {
    }

    @Test
    public void listOperationInformationDOS() {
    }

    @Test
    public void listOperationInformationDTOS() {
    }

    @Test
    public void saveOperationInformationDO() {
        ParseDataDTO parseDataDTO = new ParseDataDTO();
        parseDataDTO.setJsonData("{\"patientId\":\"patientId\",\"operationHospitalCode\":\"0147\",\"operationStartTime\":\"2004-05-03T17:30:08+08:00\",\"deviceInformation\":[{\"deviceType\":1,\"serialNumber\":\"SN123123\",\"serviceLife\":2},{\"deviceType\":2,\"serialNumber\":\"SN1231233\",\"serviceLife\":3}]}");
        operationInformationService.saveOperationInformationDOFromParseDataDTO(parseDataDTO);
    }

    @Test
    public void saveOperationInformationDO1() {
    }

    @Test
    public void updateOperationInformationDO() {
        ParseDataDTO parseDataDTO = new ParseDataDTO();
        parseDataDTO.setOperationNumber(11);
        parseDataDTO.setJsonData("{\"operationEndTime\":\"2004-05-03T17:30:08+08:00\"}");
        operationInformationService.updateOperationInformationDO(parseDataDTO);
    }

    @Test
    public void countOperationInformationDOS() {
    }
}