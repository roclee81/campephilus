package org.cqu.edu.mrc.realdata.modules.job.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.MqttConstants;
import org.cqu.edu.mrc.realdata.modules.job.mqtt.MqttPushClient;
import org.cqu.edu.mrc.realdata.modules.job.service.MqttService;
import org.springframework.stereotype.Service;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/10 19:00
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
@Service
public class MqttServiceImpl implements MqttService {

    @Override
    public void subscribe(String macAddress) {
        String defaultEventTopic = MqttConstants.PROJECT_NAME + MqttConstants.TOPIC_TYPE_SYSTEM + macAddress + MqttConstants.MESSAGE_TYPE_EVENT + MqttConstants.ACTION_UPDATE;
        String patientDataTopic = MqttConstants.PROJECT_NAME + MqttConstants.TOPIC_TYPE_DATA + macAddress + MqttConstants.MESSAGE_TYPE_PATIENT + MqttConstants.ACTION_POST;
        String deviceDataTopic = MqttConstants.PROJECT_NAME + MqttConstants.TOPIC_TYPE_DATA + macAddress + MqttConstants.MESSAGE_TYPE_DEVICE + MqttConstants.ACTION_POST;

        MqttPushClient.getInstance().subscribe(defaultEventTopic);
        MqttPushClient.getInstance().subscribe(patientDataTopic);
        MqttPushClient.getInstance().subscribe(deviceDataTopic);
    }

    @Override
    public void startConnectMqttService() {
        MqttPushClient.getInstance().subscribe(MqttConstants.DEFAULT_EVENT_TOPIC);
    }
}
