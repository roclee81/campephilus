package org.cqu.edu.mrc.realdata.common.enums;

import lombok.Getter;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/6 15:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Getter
public enum MqttEnum {

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(-1),

    /**
     * 注册请求
     */
    REGISTER(0),

    /**
     * 开机注册成功
     */
    REGISTER_SUCCESS(200),

    /**
     * 准备要开始新的手术，获取opn
     */
    OPERATION_READY(151),

    /**
     * 服务器准备完毕，可以开始手术了
     */
    OPERATION_READY_SUCCESS(152),

    /**
     * 准备上传病人数据
     */
    PATIENT_INFO_READY(153),

    /**
     * 可以开始上传病人数据
     */
    PATIENT_INFO_READY_SUCCESS(154),

    /**
     * 是病人数据
     */
    PATIENT_INFO(155),

    /**
     * 病人信息发送完毕
     */
    PATIENT_INFO_END(156),

    /**
     * 病人信息发送完毕
     */
    PATIENT_INFO_END_SUCCESS(157),

    /**
     * 准备发送仪器数据
     */
    DEVICE_DATA_READY(158),

    /**
     * 可以开始上传仪器数据
     */
    DEVICE_DATA_READY_SUCCESS(159),

    /**
     * 是仪器数据
     */
    DEVICE_DATA(160),

    /**
     * 病人信息发送完毕
     */
    DEVICE_DATA_END(161),

    /**
     * 回复医疗仪器数据发送完毕收到
     */
    DEVICE_DATA_END_SUCCESS(162),
    ;

    private Integer code;

    MqttEnum(int code) {
        this.code = code;
    }
}
