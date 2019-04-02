package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/9 16:04
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticalServiceImplTest {

    @Autowired
    private StatisticalService statisticalService;

    @Test
    public void getStatisticalDOByStatisticalDate() {
    }

    @Test
    public void getLastStatisticalDO() {
    }

    @Test
    public void listAllByIdNotNull() {
    }

    @Test
    public void saveStatisticalDO() {
    }

    @Test
    public void updateStatisticalDO() {

        StatisticalDO statisticalDO = StatisticalDO.getStatisticalDOInstance();
        // 保存每小时的请求
        List<Integer> collectorPerHourRequestList = statisticalDO.getPerHourCollectorUploadList();
        collectorPerHourRequestList.add(33333);
        statisticalDO.setPerHourCollectorUploadList(collectorPerHourRequestList);

        // 保存每小时的有效请求
        List<Integer> collectorPerHourValidRequestList = statisticalDO.getPerHourCollectorValidUploadList();
        collectorPerHourValidRequestList.add(12312312);
        statisticalDO.setPerHourCollectorValidUploadList(collectorPerHourValidRequestList);

        statisticalDO.setRequest(123);
        statisticalDO.setCollectorValidUpload(123123);

        // TODO 没有判断result是否保存要求，是否保存成功
        boolean result = statisticalService.updateStatisticalDO(statisticalDO);

    }

    @Test
    public void listStatisticalDOByGmtCreateBetween() {
    }

    @Test
    public void listStatisticalDOByGmtModifiedBetween() {
    }

    @Test
    public void updateStatisticalDO1() {
    }
}