package org.cqu.edu.mrc.realdata.common.enums;

import lombok.Getter;

/**
 * @author Vinicolor
 * @date 2018/10/8
 * <p>
 * Description:
 * 用户服务器返回的结果
 */
@Getter
public enum ResultEnum {

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(-1, "An unknown error"),

    /**
     * 数据格式错误
     */
    DATA_FORMAT_ERROR(201,"Data format error"),

    /**
     * 字段值不正确
     */
    FIELD_VALUE_ERROR(202,"Field value error"),

    /**
     * 数据据不完整
     */
    DATA_INCOMPLETENESS(203,"Data incompleteness"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
