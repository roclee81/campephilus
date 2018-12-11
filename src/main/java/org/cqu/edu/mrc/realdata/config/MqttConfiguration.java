package org.cqu.edu.mrc.realdata.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * node
 *
 * @author Vinicolor
 * @version V1.0
 * @date 2018/11/12 16:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
@ConfigurationProperties(prefix = "com.mqtt")
@Data
public class MqttConfiguration {
    private String host;

    private String clientid;

    private String topic;

    private String username;

    private String password;

    private int timeout;

    private int keepalive;
}
