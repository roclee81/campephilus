package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.service.CollectorInformationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/21 15:00
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CollectorInformationServiceImplTest {

    @Autowired
    private CollectorInformationService collectorInformationService;

    @Test
    public void getCollectorInformationDOByCollectorMacAddress() {
        CollectorInformationDO result = collectorInformationService.getCollectorInformationDOByCollectorMacAddress("1111");
        assertNull(result);
    }

    @Test
    public void listCollectorInformationDOSByCollectorState() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<CollectorInformationDO> result = collectorInformationService.listCollectorInformationDOSByCollectorState(1, pageable);
        assertEquals(0, result.getTotalElements());
    }

    @Test
    public void saveCollectorInformationDO() {
        CollectorInformationDO collectorInformationDO = new CollectorInformationDO();
        collectorInformationDO.setCollectorMacAddress("test");
        collectorInformationDO.setCollectorOperationTimes(1);
        collectorInformationDO.setCollectorState(1);
        collectorInformationDO.setCollectorUploadDataTimes(1L);
        collectorInformationDO.setGmtCollectorLastUploadData(new Date());
        collectorInformationDO.setGmtCreate(new Date());
        collectorInformationDO.setGmtModified(new Date());
        CollectorInformationDO result = collectorInformationService.saveCollectorInformationDO(collectorInformationDO);
        assertNotNull(result);
    }

    @Test
    public void updateCollectorInformationDO() {
        CollectorInformationDO result = collectorInformationService.updateCollectorInformationDO("test", 1, 1L, 1);
        assertNotNull(result);
    }
}