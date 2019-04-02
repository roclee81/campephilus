package org.cqu.edu.mrc.annihilation.campephilus.repository;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/25 21:43
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticalRepositoryTest {

    @Autowired
    private StatisticalRepository statisticalRepository;

    @Test
    public void save() {
        StatisticalDO statisticalDO = new StatisticalDO();
        statisticalDO.setGmtCreate(new Date());
        statisticalDO.setGmtModified(new Date());
        statisticalDO.setDate("2019/02/25");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1212);
        integerList.add(1232131);
        statisticalDO.setPerHourCollectorUploadList(integerList);
        StatisticalDO result = statisticalRepository.save(statisticalDO);
        Assert.assertNotNull(result);
    }


}