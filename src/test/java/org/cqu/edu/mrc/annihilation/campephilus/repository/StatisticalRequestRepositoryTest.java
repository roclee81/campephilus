package org.cqu.edu.mrc.annihilation.campephilus.repository;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalRequestDO;
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
public class StatisticalRequestRepositoryTest {

    @Autowired
    private StatisticalRequestRepository statisticalRequestRepository;

    @Test
    public void save() {
        StatisticalRequestDO statisticalRequestDO = new StatisticalRequestDO();
        statisticalRequestDO.setGmtCreate(new Date());
        statisticalRequestDO.setGmtModified(new Date());
        statisticalRequestDO.setStatisticalDate("2019/02/25");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1212);
        integerList.add(1232131);
        statisticalRequestDO.setPerHourRequestNumber(integerList);
        StatisticalRequestDO result = statisticalRequestRepository.save(statisticalRequestDO);
        Assert.assertNotNull(result);
    }


}