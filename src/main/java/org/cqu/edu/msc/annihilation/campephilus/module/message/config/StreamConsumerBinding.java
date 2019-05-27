package org.cqu.edu.msc.annihilation.campephilus.module.message.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/27 10:54
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
@EnableBinding(StreamConsumer.class)
@Slf4j
public class StreamConsumerBinding {

    @StreamListener(StreamConsumer.INPUT_CHANNEL)
    public void processInput(Object message) {
        System.out.println("processInput " + message);
    }

    @StreamListener(StreamProvider.OUTPUT_CHANNEL)
    public void processOutput(Object message) {
        System.out.println("processOutput " + message);
    }


}
