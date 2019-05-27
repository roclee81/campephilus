package org.cqu.edu.msc.annihilation.campephilus.module.message.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/27 10:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface StreamProvider {

    String OUTPUT_CHANNEL = "output_campephilus_channel";

    @Output(StreamProvider.OUTPUT_CHANNEL)
    MessageChannel output();
}
