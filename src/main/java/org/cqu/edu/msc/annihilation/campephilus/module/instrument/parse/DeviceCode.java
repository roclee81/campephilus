package org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse;

/**
 * 每个设备具有的唯一代号 通过此代号与其序列号定位到一台仪器
 * @author cz
 */
public interface DeviceCode {

    /**
     * 串口设备
     */
    String SERIAL_PORT_DEVICE = "2";
    /**
     * UDP设备
     */
    String UDP_DEVICE = "3";
    /**
     * TCP设备
     */
    String TCP_DEVICE = "4";


    // 串口类仪器以2开头
    /**
     * 苏州爱琴
     */
    String AI_QIN = "20";
    /**
     * 重庆名希
     */
    String MING_XI = "21";
    /**
     * 美敦力 麻醉深度
     */
    String MEIDUNLI_VISTA = "22";
    /**
     * 美敦力 血红蛋白
     */
    String MEIDUNLI_5100C = "23";

    // UDP类仪器以3开头
    /**
     * 合肥诺和NW9002S
     */
    String NUO_HE = "30";
    /**
     * 浙江普可YY-106
     */
    String PU_KE = "31";
    /**
     * 广东宝莱特Q6
     */
    String BAO_LAI_TE = "32";

    // TCP类仪器以4开头
    /**
     * 深圳威浩康Angel-6000A
     */
    String WEI_HAO_KANG = "40";
    /**
     * 深圳科曼
     */
    String KE_MAN = "41";
    /**
     * 迈瑞IPM-10
     */
    String MAI_RUI = "42";
}


