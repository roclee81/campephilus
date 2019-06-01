package org.cqu.edu.msc.annihilation.campephilus.module.message;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.message.config.StreamProvider;
import org.cqu.edu.msc.annihilation.campephilus.module.message.utils.ProtoConvertUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    private StreamProvider streamProvider;

    BeforeOperationInfo beforeOperationInfo = new BeforeOperationInfo();

    class myThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.MICROSECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                byte[] message = ProtoConvertUtils.convert(beforeOperationInfo);
                streamProvider.output().send(MessageBuilder.withPayload(message).build());
            }

        }
    }

    @Test
    public void test() {


        beforeOperationInfo.setAdmissionNumber("11");
        beforeOperationInfo.setAnesthesiaMode("ss");
        beforeOperationInfo.setASALevel(1);
        beforeOperationInfo.setId(13211);
        beforeOperationInfo.setIsStrong(true);
        beforeOperationInfo.setIsUrgent(true);
        beforeOperationInfo.setMedicalHistory("ss");
        beforeOperationInfo.setSpecialCase("sda");


        myThread myThread = new myThread();
        myThread.run();

//        for (int i = 0; i < 10000; i++) {
//            try {
//                TimeUnit.MICROSECONDS.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("send" + i);
//            byte[] message = ProtoConvertUtils.convert(beforeOperationInfo);
//            streamProvider.output().send(MessageBuilder.withPayload(message).build());
//        }
    }

}