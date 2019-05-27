package org.cqu.edu.msc.annihilation.campephilus.module.message;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.message.consumer.StreamClient;
import org.cqu.edu.msc.annihilation.campephilus.module.message.utils.ProtoConvertUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
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

    @Autowired
    private StreamClient streamClient;

    @Test
    public void test() {

//        BeforeOperationInfo beforeOperationInfo = new BeforeOperationInfo();
//        beforeOperationInfo.setAdmissionNumber("11");
//        beforeOperationInfo.setAnesthesiaMode("ss");
//        beforeOperationInfo.setASALevel(1);
//        beforeOperationInfo.setBeforeOperationId(13211);
//        beforeOperationInfo.setIsStrong(true);
//        beforeOperationInfo.setIsUrgent(true);
//        beforeOperationInfo.setMedicalHistory("ss");
//        beforeOperationInfo.setSpecialCase("sda");

        AfterOperationInfo afterOperationInfo = new AfterOperationInfo();
        afterOperationInfo.setAdmissionNumber("11");
        afterOperationInfo.setAfterOperationId(111);
        afterOperationInfo.setFeedbackContent("adasda");
        for (int i = 0; i < 10000; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("send" + i);
            byte[] message = ProtoConvertUtils.convert(afterOperationInfo);
            streamClient.output().send(MessageBuilder.withPayload(message).build());
        }
    }

}