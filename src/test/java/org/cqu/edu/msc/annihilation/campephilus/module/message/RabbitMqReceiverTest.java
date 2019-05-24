package org.cqu.edu.msc.annihilation.campephilus.module.message;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/24 15:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RabbitMqReceiverTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void test() {
        for (int i = 0; i < 10000; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("send" + i);
            amqpTemplate.convertAndSend("campephilus", i);
        }
    }

}