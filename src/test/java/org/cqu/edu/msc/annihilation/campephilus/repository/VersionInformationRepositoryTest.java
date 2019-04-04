package org.cqu.edu.msc.annihilation.campephilus.repository;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.VersionInformationDO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.VersionInformationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 13:36
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class VersionInformationRepositoryTest {

    @Autowired
    private VersionInformationRepository versionInformationRepository;

    @Test
    public void save() {
        VersionInformationDO versionInformationDO = new VersionInformationDO();
        versionInformationDO.setApplicationVersion("0");
        versionInformationDO.setCollectorVersion("0");
        versionInformationDO.setGmtCreate(new Date());
        versionInformationDO.setGmtModified(new Date());
        VersionInformationDO result = versionInformationRepository.save(versionInformationDO);
        assertNotNull(result);
    }

    @Test
    public void save1() {
        VersionInformationDO versionInformationDO = new VersionInformationDO();
        versionInformationDO.setApplicationVersion("1");
        versionInformationDO.setCollectorVersion("1");
        versionInformationDO.setGmtCreate(new Date());
        versionInformationDO.setGmtModified(new Date());
        VersionInformationDO result = versionInformationRepository.save(versionInformationDO);
        assertNotNull(result);
    }

    @Test
    public void save2() {
        VersionInformationDO versionInformationDO = new VersionInformationDO();
        versionInformationDO.setApplicationVersion("2");
        versionInformationDO.setCollectorVersion("2");
        versionInformationDO.setGmtCreate(new Date());
        versionInformationDO.setGmtModified(new Date());
        VersionInformationDO result = versionInformationRepository.save(versionInformationDO);
        assertNotNull(result);
    }

    @Test
    public void findFirstByOrderByIdDesc() {
        VersionInformationDO result = versionInformationRepository.findFirstByOrderByIdDesc();
        assertNotNull(result);
    }

}