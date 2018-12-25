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
    PATIENT_INFO_READY(157, "准备上传病人数据"),
    PATIENT_INFO_READY_SUCCESS(158, "可以开始上传病人数据"),
    PATIENT_INFO(159, "是病人数据"),
    PATIENT_INFO_SUCCESS(160, "该条病人数据保存完毕"),
    PATIENT_INFO_END(161, "病人信息发送完毕"),
    PATIENT_INFO_END_SUCCESS(162, "病人信息发送完毕收到"),
    DEVICE_DATA_READY(163, "准备发送仪器数据"),
    DEVICE_DATA_READY_SUCCESS(164, "可以开始上传仪器数据"),
    DEVICE_DATA(165, "是仪器数据"),
    DEVICE_DATA_SUCCESS(166, "该条仪器数据保存完毕"),
    DEVICE_DATA_END(167, "仪器数据发送完毕"),
    DEVICE_DATA_END_SUCCESS(168, "病人信息发送完毕收到"),
    OPERATION_MARK_READY(169, "手术过程中标记信息准备发送"),
    OPERATION_MARK_READY_SUCCESS(170, "手术过程中标记信息可以发送"),
    OPERATION_MARK(171, "是手术过程中的标记数据"),
    OPERATION_MARK_SUCCESS(172, "该条过程中的标记数据收到"),
    OPERATION_MARK_END(173, "手术过程中的标记数据发送结束"),
    OPERATION_MARK_END_SUCCESS(174, "手术过程中的标记数据发送结束收到"),
    ;

    private Integer code;
    private String meg;

    MqttEnum(int code, String meg) {
        this.code = code;
        this.meg = meg;
    }
}
