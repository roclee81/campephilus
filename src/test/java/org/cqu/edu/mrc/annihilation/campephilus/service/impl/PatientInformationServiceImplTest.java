package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.PatientInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.PatientInformationDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/9 16:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientInformationServiceImplTest {

    @Autowired
    PatientInformationServiceImpl patientInformationService;

    @Test
    public void getPatientInformationDOSByPatientIdAndOperationNumber() {
        PatientInformationDO result = patientInformationService.getPatientInformationDOByPatientIdAndOperationNumber("012121", 1);
//        Assert.assertNotNull(result);
    }

    @Test
    public void getPatientInformationDOSByPatientId() {
        PageRequest pageRequest = PageRequest.of(0, 100);
        Page<PatientInformationDO> result = patientInformationService.listPatientInformationDOSByPatientId("012121", pageRequest);
        //Assert.assertTrue(result.getTotalElements() > 0);
    }

    @Test
    public void getPatientInformationDTOSByPatientId() {
        PageRequest pageRequest = PageRequest.of(0, 100);
        List<PatientInformationDTO> result = patientInformationService.listPatientInformationDTOSByPatientId("012121", pageRequest);
//        Assert.assertTrue(result.size() > 0);
    }

    @Test
    public void savePatientInformationDO() {
        PatientInformationDO patientInformationDO = new PatientInformationDO();
        patientInformationDO.setGmtCreate(new Date());
        patientInformationDO.setGmtModified(new Date());
        patientInformationDO.setPostoperativeData(new HashMap());
        patientInformationDO.setOperationNumber(4);
        patientInformationDO.setPatientId("0121112100");
        patientInformationDO.setPreoperativeData(new HashMap());
        patientInformationDO.setPatientData(new HashMap());
        patientInformationService.savePatientInformationDO(patientInformationDO);
    }

    @Test
    public void savePatientInformationDO1() {
        ParseDataDTO parseDataDTO = new ParseDataDTO();
        parseDataDTO.setOperationNumber(5);
        parseDataDTO.setCode(161);
        parseDataDTO.setCollectorMacAddress("00-0f-e2-2e-94-a9");
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("patientId", "100077777");
        dataMap.put("patientData", new HashMap<>());
        dataMap.put("preoperativeData", new HashMap<>());
//        parseDataDTO.setData(dataMap);
        boolean result = patientInformationService.savePatientInformationDO(parseDataDTO);
//        Assert.assertTrue(result);
    }
}