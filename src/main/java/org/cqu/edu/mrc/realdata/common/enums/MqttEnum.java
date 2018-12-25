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

    UNKNOWN_ERROR(-1, "未知错误"),
    DEVICE_REGISTER(199, "注册"),
    REGISTER_SUCCESS(200, "开机注册成功"),

    DATA_FORMAT_ERROR(-2, "数据格式错误"),
    OPERATION_READY(151, "准备要开始新的手术，获取opn"),
    OPERATION_READY_SUCCESS(152, "服务器准备完毕，可以开始手术了"),
    OPERATION_DEVICE_READY(153, "准备开始发送手术设备信息"),
    OPERATION_DEVICE_READY_SUCCESS(154, "可以准备开始发送手术设备信息"),
    OPERATION_DEVICE(155, "是手术设备信息"),
    OPERATION_DEVICE_SUCCESS(156, "该条信息保存完毕"),
    OPERATION_DEVICE_END(157, "设备数据发送完毕"),
    OPERATION_DEVICE_END_SUCCESS(158, "回复设备数据发送可以完毕"),
    PATIENT_INFO_READY(159, "准备上传病人数据"),
    PATIENT_INFO_READY_SUCCESS(160, "可以开始上传病人数据"),
    PATIENT_INFO(161, "是病人数据"),
    PATIENT_INFO_SUCCESS(162, "该条病人数据保存完毕"),
    PATIENT_INFO_END(163, "病人信息发送完毕"),
    PATIENT_INFO_END_SUCCESS(164, "病人信息发送完毕收到"),
    DEVICE_DATA_READY(165, "准备发送仪器数据"),
    DEVICE_DATA_READY_SUCCESS(166, "可以开始上传仪器数据"),
    DEVICE_DATA(167, "是仪器数据"),
    DEVICE_DATA_SUCCESS(168, "该条仪器数据保存完毕"),
    DEVICE_DATA_END(169, "仪器数据发送完毕"),
    DEVICE_DATA_END_SUCCESS(170, "病人信息发送完毕收到"),
    OPERATION_MARK_READY(171, "手术过程中标记信息准备发送"),
    OPERATION_MARK_READY_SUCCESS(172, "手术过程中标记信息可以发送"),
    OPERATION_MARK(173, "是手术过程中的标记数据"),
    OPERATION_MARK_SUCCESS(174, "该条过程中的标记数据收到"),
    OPERATION_MARK_END(175, "手术过程中的标记数据发送结束"),
    OPERATION_MARK_END_SUCCESS(176, "手术过程中的标记数据发送结束收到"),
    ;

    private Integer code;
    private String meg;

    MqttEnum(int code, String meg) {
        this.code = code;
        this.meg = meg;
    }
}
