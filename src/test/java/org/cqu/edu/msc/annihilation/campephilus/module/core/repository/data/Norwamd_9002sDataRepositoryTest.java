package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data.Norwamd9002sData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 21:36
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Norwamd_9002sDataRepositoryTest {

    @Autowired
    private Norwamd9002sDataRepository repository;

    @Test
    public void save() {
        Norwamd9002sData norwamd_9002SData = new Norwamd9002sData();
        norwamd_9002SData.setBS(1);
        norwamd_9002SData.setCSI(1);
        norwamd_9002SData.setEMG(1);
        norwamd_9002SData.setSQI(1);
        norwamd_9002SData.setOperationNumber(1);
        Norwamd9002sData result = repository.save(norwamd_9002SData);
        Assert.assertNotNull(result);
    }

}