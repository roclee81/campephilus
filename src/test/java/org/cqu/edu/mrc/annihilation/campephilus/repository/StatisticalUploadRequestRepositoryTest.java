package org.cqu.edu.mrc.annihilation.campephilus.repository;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalUploadRequestDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.StatisticalUploadRequestRepository;
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
public class StatisticalUploadRequestRepositoryTest {

    @Autowired
    private StatisticalUploadRequestRepository statisticalUploadRequestRepository;

    @Test
    public void save() {
        StatisticalUploadRequestDO statisticalUploadRequestDO = new StatisticalUploadRequestDO();
        statisticalUploadRequestDO.setGmtCreate(new Date());
        statisticalUploadRequestDO.setGmtModified(new Date());
        statisticalUploadRequestDO.setStatisticalDate("2019/02/25");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1212);
        integerList.add(1232131);
        statisticalUploadRequestDO.setPerHourRequestNumber(integerList);
        StatisticalUploadRequestDO result = statisticalUploadRequestRepository.save(statisticalUploadRequestDO);
        Assert.assertNotNull(result);
    }


}