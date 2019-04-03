package org.cqu.edu.msc.annihilation.campephilus.statistical.process;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/3 19:17
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
@Component
public class Receiver {

    //    @RabbitListener(queuesToDeclare = @Queue("test"))
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("campephilus"),
            key = "request",
            value= @Queue("statistical")
    ))
    public void process(String message) {
        System.out.println(message);
    }
}
