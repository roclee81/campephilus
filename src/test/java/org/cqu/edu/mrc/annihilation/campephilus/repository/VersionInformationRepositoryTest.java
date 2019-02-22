package org.cqu.edu.mrc.annihilation.campephilus.repository;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.VersionInformationDO;
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
        versionInformationDO.setHardwareVersion("0");
        versionInformationDO.setGmtCreate(new Date());
        versionInformationDO.setGmtModified(new Date());
        VersionInformationDO result = versionInformationRepository.save(versionInformationDO);
        assertNotNull(result);
    }

    @Test
    public void save1() {
        VersionInformationDO versionInformationDO = new VersionInformationDO();
        versionInformationDO.setApplicationVersion("1");
        versionInformationDO.setHardwareVersion("1");
        versionInformationDO.setGmtCreate(new Date());
        versionInformationDO.setGmtModified(new Date());
        VersionInformationDO result = versionInformationRepository.save(versionInformationDO);
        assertNotNull(result);
    }

    @Test
    public void save2() {
        VersionInformationDO versionInformationDO = new VersionInformationDO();
        versionInformationDO.setApplicationVersion("2");
        versionInformationDO.setHardwareVersion("2");
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