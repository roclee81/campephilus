package org.cqu.edu.msc.annihilation.campephilus.module.message.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/27 17:29
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
@EnableBinding(StreamProvider.class)
public class StreamProviderBinding {

//    @StreamListener(StreamProvider.OUTPUT_CHANNEL)
//    public void processOutput(Object message) {
//        System.out.println("processOutput " + message);
//    }
}
