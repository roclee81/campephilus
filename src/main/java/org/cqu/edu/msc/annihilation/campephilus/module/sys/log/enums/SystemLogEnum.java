package org.cqu.edu.msc.annihilation.campephilus.module.sys.log.enums;

import lombok.Getter;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/10/11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Getter
public enum SystemLogEnum {

    /**
     * 苏州爱琴
     */
    DUBUG(0),

    /**
     * 日常信息
     */
    INFO(1),

    /**
     * 错误
     */
    ERROR(-1),

    ;

    private Integer code;

    SystemLogEnum(Integer code) {
        this.code = code;
    }
}
