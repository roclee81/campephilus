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
     *
     * @param macAddress
     */
    void subscribe(String macAddress);

    /**
     *
     */
    void startConnectMqttService();
}
