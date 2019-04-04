package org.cqu.edu.msc.annihilation.campephilus.repository;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.FeedbackInformationDO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.FeedbackInformationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 12:59
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FeedbackInformationRepositoryTest {

    @Autowired
    private FeedbackInformationRepository repository;

    @Test
    public void save() {
        FeedbackInformationDO feedbackInformationDO = new FeedbackInformationDO();
        feedbackInformationDO.setGmtCreate(new Date());
        feedbackInformationDO.setGmtModified(new Date());
//        feedbackInformationDO.setMsg("nononono");
        FeedbackInformationDO result = repository.save(feedbackInformationDO);
        assertNotNull(result);
    }

    @Test
    public void save1() {
        FeedbackInformationDO feedbackInformationDO = new FeedbackInformationDO();
        feedbackInformationDO.setGmtCreate(new Date());
        feedbackInformationDO.setGmtModified(new Date());
//        feedbackInformationDO.setMsg("nononono12321");
        FeedbackInformationDO result = repository.save(feedbackInformationDO);
        assertNotNull(result);
    }

    @Test
    public void save2() {
        FeedbackInformationDO feedbackInformationDO = new FeedbackInformationDO();
        feedbackInformationDO.setGmtCreate(new Date());
        feedbackInformationDO.setGmtModified(new Date());
//        feedbackInformationDO.setMsg("nononono12asdsads321");
        FeedbackInformationDO result = repository.save(feedbackInformationDO);
        assertNotNull(result);
    }

    @Test
    public void findAllByIdNotNull() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<FeedbackInformationDO> result = repository.findAllByIdNotNull(pageRequest);
//        assertEquals(3, result.getTotalElements());
    }

}