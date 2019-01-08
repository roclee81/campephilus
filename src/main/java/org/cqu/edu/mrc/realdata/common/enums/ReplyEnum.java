package org.cqu.edu.mrc.realdata.common.enums;

import lombok.Getter;

/**
 * realdata
 * 服务器对请求进行回复的代码
 * 但实际上通讯协议只是对请求码回复+1
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/29 15:05
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Getter
public enum ReplyEnum {

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(-1),

    /**
     * 数据格式错误
     */
    DATA_FORMAT_ERROR(-2),

    /**
     * 请求的CODE是错误的
     */
    CODE_ERROR(-3),

    /**
     * 数据不存在
     */
    DATA_DOES_NOT_EXIST(-4),

    /**
     * 请求参数不存在
     */
    REQUEST_PARAMETER_DOES_NOT_EXIST(-5),

    /**
     * 成功
     */
    SUCCESS(200),

    /**
     * 开机注册成功
     */
    REGISTER_SUCCESS(100),

    /**
     * 服务器准备完毕，可以开始手术了
     */
    OPERATION_READY_SUCCESS(152),

    /**
     * 可以准备开始发送手术设备信息
     */
    OPERATION_DEVICE_READY_SUCCESS(154),

    /**
     * 该条信息保存完毕
     */
    OPERATION_DEVICE_SUCCESS(156),

    /**
     * 回复设备数据发送可以完毕
     */
    OPERATION_DEVICE_END_SUCCESS(158),

    /**
     * 可以开始上传病人数据
     */
    PATIENT_INFO_READY_SUCCESS(160),

    /**
     * 该条病人数据保存完毕
     */
    PATIENT_INFO_SUCCESS(162),

    /**
     * 病人信息发送完毕收到
     */
    PATIENT_INFO_END_SUCCESS(164),

    /**
     * 可以开始上传仪器数据
     */
    DEVICE_DATA_READY_SUCCESS(166),

    /**
     * 该条仪器数据保存完毕
     */
    DEVICE_DATA_SUCCESS(168),

    /**
     * 病人信息发送完毕收到
     */
    DEVICE_DATA_END_SUCCESS(170),

    /**
     * 手术过程中标记信息可以发送
     */
    OPERATION_MARK_READY_SUCCESS(172),

    /**
     * 该条过程中的标记数据收到
     */
    OPERATION_MARK_SUCCESS(174),

    /**
     * 手术过程中的标记数据发送结束收到
     */
    OPERATION_MARK_END_SUCCESS(176),

    /**
     * 是手术结束的信息
     */
    OPERATION_END_READY_SUCCESS(178),

    /**
     * 回复收到手术结束的信息
     */
    OPERATION_END_SUCCESS(180),
    ;

    private Integer code;

    ReplyEnum(Integer code) {
        this.code = code;
    }
}
