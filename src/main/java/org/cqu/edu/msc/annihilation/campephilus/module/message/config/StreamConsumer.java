package org.cqu.edu.msc.annihilation.campephilus.module.message.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/27 17:15
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface StreamConsumer {

    String INPUT_CHANNEL = "input_campephilus";

    @Input(StreamConsumer.INPUT_CHANNEL)
    SubscribableChannel input();
}
