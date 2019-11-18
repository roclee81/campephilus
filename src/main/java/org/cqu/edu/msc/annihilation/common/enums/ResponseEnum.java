package org.cqu.edu.msc.annihilation.common.enums;

import lombok.Getter;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/16 12:35
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 服务器对请求进行回复的代码
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
    DATA_NOT_EXIST(-4, "数据不存在"),

    /**
     * 请求参数不存在
     */
    REQUEST_PARAMETER_DOES_NOT_EXIST(-5, "请求参数不存在"),

    /**
     * 数据已经存在
     */
    DATA_EXISTED(-6, "数据已经存在"),

    /**
     * 该数据已经处于结束状态
     */
    DATA_STATE_FINISHED(-7, "该数据已经处于结束状态"),

    /**
     * 没有前置数据
     */
    OPERATION_NOT_READY(-8, "没有前置数据"),

    /**
     * 更新失败，ID字段错误或为空
     */
    UPDATE_ID_ERROR(-9, "更新失败，ID字段错误或为空"),

    /**
     * 未知数据类型
     */
    UNKNOWN_DATA_TYPE(-10, "未知数据类型"),

    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    ;

    private Integer code;
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
