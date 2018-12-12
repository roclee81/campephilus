package org.cqu.edu.mrc.realdata.modules.job.service;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/10 20:41
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface MqttService {

    /**
     * 通过MAC地址订阅Topic
     * @param macAddress MAC地址,例如：E0D55E227B92
     */
    void subscribe(String macAddress);

    /**
     * 开始连接Mqtt服务器，开始的时候将订阅了一个公共的Topic
     */
    void startConnectMqttService();
}
