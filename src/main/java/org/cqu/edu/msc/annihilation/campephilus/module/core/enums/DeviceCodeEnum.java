package org.cqu.edu.msc.annihilation.campephilus.module.core.enums;

import lombok.Getter;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Getter
public enum DeviceCodeEnum {

    /**
     * 苏州爱琴
     */
    AI_QIN(29),

    /**
     * 重庆名希
     */
    MING_XI(21),

    /**
     * 美敦力 麻醉深度
     */
    MEIDUNLI_VISTA(22),

    /**
     * 美敦力 血红蛋白
     */
    MEIDUNLI_5100C(23),


    /**
     * 合肥诺和NW9002S
     */
    NUO_HE(30),

    /**
     * 浙江普可YY-106
     */
    PU_KE(31),

    /**
     * 广东宝莱特Q6
     */
    BAO_LAI_TE(32),

    /**
     * 宜安
     */
    YI_AN(33),

    /**
     * 理邦
     */
    LI_BANG(34),
    
    /**
     * 深圳威浩康Angel-6000A
     */
    WEI_HAO_KANG(40),

    /**
     * 深圳科曼
     */
    KE_MAN(41),

    /**
     * 迈瑞IPM-10
     */
    MAI_RUI_T8(42),

    ;

    private Integer code;

    DeviceCodeEnum(Integer code) {
        this.code = code;
    }

    public static DeviceCodeEnum matchRequestEnum(Integer code) {
        for (DeviceCodeEnum deviceCodeEnum : DeviceCodeEnum.values()) {
            if (deviceCodeEnum.getCode().equals(code)) {
                return deviceCodeEnum;
            }
        }
        return null;
    }
}
