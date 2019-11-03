package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity;

import lombok.Getter;

/**
 * 响应实体类
 * @author cz
 */
public enum ResponseCode {

    /**
     * 成功
     */
    SUCCESS(200, "SUCCESS"),

    /**
     * 错误
     */
    ERROR(1, "ERROR"),

    /**
     * 需要登录
     */
    NEED_LOGIN(10, "NEED_LOGIN"),

    /**
     * 参数错误
     */
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    /**
     * code值
     */
    @Getter
    private final int code;

    /**
     * 描述
     */
    @Getter
    private final String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
