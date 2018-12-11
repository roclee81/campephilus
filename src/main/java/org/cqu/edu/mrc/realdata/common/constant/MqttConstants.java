package org.cqu.edu.mrc.realdata.common.constant;

/**
 * AreaControlUnitNode
 *
 * @author lx
 * @version V1.0
 * @date 18-11-10-下午9:41
 */
public class MqttConstants {

    public static final String USERNAME = "admin";

    public static final String PASSWORD = "public";

    public static final String HOSTURL = "tcp://172.20.29.10:1883";

    public static final String CLIENT_ID = "REAL_DATA_SERVER";

    public static final Integer TIMEOUT = 10;

    public static final Integer KEEP_ALIVE = 60;

    public static final String PROJECT_NAME = "/medical";

    public static final String TOPIC_TYPE_SYSTEM = "/sys";

    public static final String TOPIC_TYPE_DATA = "/data";

    public static final String MESSAGE_TYPE_EVENT = "/event";

    public static final String MESSAGE_TYPE_PATIENT = "/patient";

    public static final String MESSAGE_TYPE_DEVICE = "/device";

    public static final String ACTION_POST = "/post";

    public static final String ACTION_UPDATE = "/update";

    public static final String DEFAULT_EVENT_TOPIC = "/medical/sys/event/update";
}

