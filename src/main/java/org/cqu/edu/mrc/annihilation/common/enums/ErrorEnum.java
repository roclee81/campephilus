package org.cqu.edu.mrc.annihilation.common.enums;

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
    SAVE_ERROR(-1),
    ;


    private Integer code;

    ErrorEnum(Integer code) {

        this.code = code;
    }}
