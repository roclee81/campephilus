package org.cqu.edu.mrc.annihilation.campephilus.enums;

import lombok.Getter;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/16 12:35
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 服务器对请求进行回复的代码
 * 但实际上通讯协议只是对请求码回复+1
 */
@Getter
public enum ResponseEnum {

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(-1, "未知错误"),

    /**
     * 数据格式错误
     */
    DATA_FORMAT_ERROR(-2, "数据格式错误"),

    /**
     * 请求的CODE是错误的
     */
    CODE_ERROR(-3, "请求的CODE是错误的"),

    /**
     * 数据不存在
     */
    DATA_DOES_NOT_EXIST(-4, "数据不存在"),

    /**
     * 请求参数不存在
     */
    REQUEST_PARAMETER_DOES_NOT_EXIST(-5, "请求参数不存在"),

    /**
     * 数据已经存在
     */
    DATA_EXISTED(-6, "数据已经存在"),

    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    /**
     * 开机注册成功
     */
    REGISTER_SUCCESS(100, "开机注册成功"),

    /**
     * 版本号请求成功
     */
    VERSION_REQUEST_SUCCESS(102, "版本号请求成功"),

    /**
     * 服务器准备完毕，可以开始手术了
     */
    OPERATION_READY_SUCCESS(152, "服务器准备完毕，可以开始手术了"),

    /**
     * 可以准备开始发送手术设备信息
     */
    OPERATION_DEVICE_READY_SUCCESS(154, "可以准备开始发送手术设备信息"),

    /**
     * 该条信息保存完毕
     */
    OPERATION_DEVICE_SUCCESS(156, "该条信息保存完毕"),

    /**
     * 回复设备数据发送可以完毕
     */
    OPERATION_DEVICE_END_SUCCESS(158, "回复设备数据发送可以完毕"),

    /**
     * 可以开始上传病人数据
     */
    PATIENT_INFO_READY_SUCCESS(160, "可以开始上传病人数据"),

    /**
     * 该条病人数据保存完毕
     */
    PATIENT_INFO_SUCCESS(162, "该条病人数据保存完毕"),

    /**
     * 病人信息发送完毕收到
     */
    PATIENT_INFO_END_SUCCESS(164, "病人信息发送完毕收到"),

    /**
     * 可以开始上传仪器数据
     */
    DEVICE_DATA_READY_SUCCESS(166, "可以开始上传仪器数据"),

    /**
     * 该条仪器数据保存完毕
     */
    DEVICE_DATA_SUCCESS(168, "该条仪器数据保存完毕"),

    /**
     * 病人信息发送完毕收到
     */
    DEVICE_DATA_END_SUCCESS(170, "病人信息发送完毕收到"),

    /**
     * 手术过程中标记信息可以发送
     */
    OPERATION_MARK_READY_SUCCESS(172, "手术过程中标记信息可以发送"),

    /**
     * 该条过程中的标记数据收到
     */
    OPERATION_MARK_SUCCESS(174, "该条过程中的标记数据收到"),

    /**
     * 手术过程中的标记数据发送结束收到
     */
    OPERATION_MARK_END_SUCCESS(176, "手术过程中的标记数据发送结束收到"),

    /**
     * 是手术结束的信息
     */
    OPERATION_END_READY_SUCCESS(178, "是手术结束的信息"),

    /**
     * 回复收到手术结束的信息
     */
    OPERATION_END_SUCCESS(180, "回复收到手术结束的信息"),

    /**
     * 可以发送术后患者信息，服务器已经准备好了
     */
    POSTOPERATIVE_PATIENT_INFO_READY_SUCCESS(182, "可以发送术后患者信息，服务器已经准备好了"),

    /**
     * 收到术后患者信息
     */
    POSTOPERATIVE_PATIENT_INFO_SUCCESS(184, "收到术后患者信息"),

    /**
     * 反馈数据接收成功
     */
    FEEDBACK_INFO_SUCCESS(186, "反馈数据接收成功"),
    ;

    private Integer code;
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
