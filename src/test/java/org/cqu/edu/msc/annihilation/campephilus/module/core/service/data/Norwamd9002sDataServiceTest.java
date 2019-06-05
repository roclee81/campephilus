package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data.Norwamd9002sData;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.impl.Norwamd9002sDataServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/4 17:32
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Norwamd9002sDataServiceTest {

    @Autowired
    private Norwamd9002sDataServiceImpl norwamd9002sDataService;

    @Test
    public void save() {
        Norwamd9002sData norwamd9002sData = new Norwamd9002sData();
        norwamd9002sData.setEMG(88);
        norwamd9002sData.setBS(12);
        norwamd9002sData.setCSI(13);
        norwamd9002sData.setSQI(99);
        norwamd9002sData.setOperationNumber(1);
        norwamd9002sData.setSerialNumber("2dd21-abcde");
        norwamd9002sDataService.save(norwamd9002sData);
    }

}