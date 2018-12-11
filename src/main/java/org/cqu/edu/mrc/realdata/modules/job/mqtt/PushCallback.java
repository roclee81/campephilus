package org.cqu.edu.mrc.realdata.modules.job.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.scheduling.annotation.Async;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/10 21:15
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
public class PushCallback implements MqttCallback {

    @Override
    public void connectionLost(Throwable throwable) {
        // 连接丢失后，一般在这里面进行重连
        log.warn("连接断开");
        System.out.println("连接断开，可以做重连");
    }

    @Override
    @Async("asyncServiceExecutor")
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        // subscribe 消息 解析
        log.info(new String(mqttMessage.getPayload()));
    }

    @Override
    @Async("asyncServiceExecutor")
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info("数据发送完成" + iMqttDeliveryToken.isComplete());
    }
}
