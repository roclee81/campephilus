package org.cqu.edu.msc.annihilation.campephilus.module.message.consumer;

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
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.OUTPUT_CHANNEL)
    public void processOutput(Object message) {
        log.info("StreamReceiver:{}", message);
    }
}
