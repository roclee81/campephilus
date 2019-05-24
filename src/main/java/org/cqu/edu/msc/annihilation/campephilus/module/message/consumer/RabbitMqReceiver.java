package org.cqu.edu.msc.annihilation.campephilus.module.message.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/24 15:15
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 接收mq消息
 */
@Component
@Slf4j
public class RabbitMqReceiver {

    @RabbitListener(queuesToDeclare = @Queue("campephilus"))
    public void process(String message) {
        // TODO 仅作为消费者，消费队列消息，不进行任何处理
        // log.info("process" + message);
    }
}
