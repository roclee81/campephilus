package org.cqu.edu.msc.annihilation.campephilus.module.message.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/27 10:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface StreamClient {

    String INPUT_CHANNEL = "input_campephilus_channel";
    String OUTPUT_CHANNEL = "output_campephilus_channel";

    @Input(StreamClient.INPUT_CHANNEL)
    SubscribableChannel input();


    @Output(StreamClient.OUTPUT_CHANNEL)
    MessageChannel output();

}
