package org.cqu.edu.msc.annihilation.campephilus.module.core.enums;


/**
 * 每个设备具有的唯一代号 通过此代号与其序列号定位到一台仪器
 * @author cz
 *
 *  UDP类仪器以3开头
 *  TCP类仪器以4开头
 *  串口类仪器以5开头
 */
public interface DeviceCode {

    //------------------------------------------------------
    // UDP类仪器
    //------------------------------------------------------
    /**
     * 合肥诺和NW9002S
     */
    int NUO_HE = 30;

    /**
     * 浙江普可YY-106
     */
    int PU_KE = 31;

    /**
     * 广东宝莱特 A8
     */
    int BAO_LAI_TE = 32;

    /**
     * 宜安
     */
    int YI_AN_8700A = 33;


    //------------------------------------------------------
    // TCP类仪器
    //------------------------------------------------------
    /**
     * 迈瑞 BeneView T8
     */
    int MAI_RUI_T8 = 42;

    /**
     * 迈瑞 WATOEX 65
     */
    int MAI_RUI_WATOEX_65 = 43;

    /**
     * 迈瑞WATOEX55 PRO
     */
    int MAI_RUI_WATOEX_55_PRO = 44;

    /**
     * 理邦 ELite V8
     */
    int LI_BANG_ELITE_V8 = 45;


    //------------------------------------------------------
    // 串口类仪器
    //------------------------------------------------------
    /**
     * 苏州爱琴
     */
    int AI_QIN_EGOS600A = 50;

    /**
     * 重庆名希
     */
    int MING_XI = 51;

    /**
     * 美敦力 麻醉深度
     */
    int MEIDUNLI_VISTA = 52;

    /**
     * 美敦力 血红蛋白
     */
    int MEIDUNLI_5100C = 53;
}
