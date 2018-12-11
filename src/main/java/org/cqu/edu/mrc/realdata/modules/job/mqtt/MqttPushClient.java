package org.cqu.edu.mrc.realdata.modules.job.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.MqttConstants;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Objects;

/**
 * node
 *
 * @author Vinicolor
 * @version V1.0
 * @date 2018/11/12 16:40
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
public class MqttPushClient {
    private MqttClient client;

    private static volatile MqttPushClient mqttPushClient = null;

    public static MqttPushClient getInstance() {
        if (null == mqttPushClient) {
            synchronized (MqttPushClient.class) {
                if (null == mqttPushClient) {
                    mqttPushClient = new MqttPushClient();
                }
            }
        }
        return mqttPushClient;
    }

    private MqttPushClient() {
        connect();
    }

    private void connect() {
        try {
            client = new MqttClient(MqttConstants.HOSTURL, MqttConstants.CLIENT_ID, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setUserName(MqttConstants.USERNAME);
            options.setPassword(MqttConstants.PASSWORD.toCharArray());
            options.setConnectionTimeout(MqttConstants.TIMEOUT);
            options.setKeepAliveInterval(MqttConstants.KEEP_ALIVE);
            try {
                client.setCallback(new PushCallback());
                client.connect(options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发布，默认qos为0，非持久化
     *
     * @param topic
     * @param pushMessage
     */
    public void publish(String topic, String message) {
        publish(0, false, topic, message);
    }

    /**
     * 发布
     *
     * @param qos
     * @param retained
     * @param topic
     * @param nodeDataDTO
     */
    public void publish(int qos, boolean retained, String topic, String message) {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(qos);
        mqttMessage.setRetained(retained);
        mqttMessage.setPayload(message.getBytes());
        MqttTopic mTopic = client.getTopic(topic);
        if (null == mTopic) {
            log.error("topic not exist");
        }
        MqttDeliveryToken token;
        try {
            token = Objects.requireNonNull(mTopic).publish(mqttMessage);
            token.waitForCompletion();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订阅某个主题，qos默认为0
     *
     * @param topic
     */
    public void subscribe(String topic) {
        subscribe(topic, 0);
    }

    /**
     * 订阅某个主题
     *
     * @param topic
     * @param qos
     */
    public void subscribe(String topic, int qos) {
        try {
            client.subscribe(topic, qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
