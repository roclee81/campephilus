package org.cqu.edu.mrc.realdata.modules.job.controller;

import org.cqu.edu.mrc.realdata.modules.job.service.impl.MqttServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/10 21:53
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping("/job/mqtt")
public class MqttController {

    private final MqttServiceImpl mqttService;

    @Autowired
    public MqttController(MqttServiceImpl mqttService) {
        this.mqttService = mqttService;
    }

    @GetMapping("/start")
    public void connectMqttServer() {
        mqttService.startConnectMqttService();
    }

    public void getMqttServerStatus() {

    }

}
