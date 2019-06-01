package org.cqu.edu.msc.annihilation.campephilus.common.enums;

import lombok.Getter;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/25 0:18
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 错误值枚举
 */
@Getter
public enum ErrorEnum {

    /**
     * 保存出错
     */
    SAVE_ERROR(-1, "保存出错"),
    ;


    private Integer code;
    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }}
