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
public enum RequestEnum {

    /**
     * 注册
     */
    DEVICE_REGISTER(99),

    /**
     * 准备要开始新的手术，获取opn
     */
    OPERATION_READY(151),

    /**
     * 准备开始发送手术设备信息
     */
    OPERATION_DEVICE_READY(153),

    /**
     * 是手术设备信息
     */
    OPERATION_DEVICE(155),

    /**
     * 设备数据发送完毕
     */
    OPERATION_DEVICE_END(157),

    /**
     * 准备上传病人数据
     */
    PATIENT_INFO_READY(159),

    /**
     * 是病人数据
     */
    PATIENT_INFO(161),

    /**
     * 病人信息发送完毕
     */
    PATIENT_INFO_END(163),

    /**
     * 准备发送仪器数据
     */
    DEVICE_DATA_READY(165),

    /**
     * 是仪器数据
     */
    DEVICE_DATA(167),

    /**
     * 仪器数据发送完毕
     */
    DEVICE_DATA_END(169),

    /**
     * 手术过程中标记信息准备发送
     */
    OPERATION_MARK_READY(171),

    /**
     * 是手术过程中的标记数据
     */
    OPERATION_MARK(173),

    /**
     * 手术过程中的标记数据发送结束
     */
    OPERATION_MARK_END(175),

    /**
     * 请求手术结束
     */
    OPERATION_END_READY(177),

    /**
     * 是手术结束的信息
     */
    OPERATION_END(179),

    /**
     * 请求发送术后患者信息
     */
    POSTOPERATIVE_PATIENT_INFO_READY(181),

    /**
     * 是术后患者信息
     */
    POSTOPERATIVE_PATIENT_INFO(183),
    ;

    private Integer code;

    RequestEnum(Integer code) {
        this.code = code;
    }
}
