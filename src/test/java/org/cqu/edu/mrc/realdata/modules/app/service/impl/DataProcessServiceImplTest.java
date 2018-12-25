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
        MedicalDataDTO medicalDataDTO = dataProcessService.parseJson("{\"code\":154,\"msg\":{\"mac\":\"mac\",\"opn\":\"opn\"}}");
        System.out.println(medicalDataDTO);
    }

    @Test
    public void processCode() {
    }
}