package org.cqu.edu.msc.annihilation.campephilus.module.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author luoxin
 */
public interface InstrumentMessage {

    String INPUT = "input_campephilus";

    @Input("input_campephilus")
    SubscribableChannel input();

//    @Output("output_campephilus")
//    MessageChannel output();
}
