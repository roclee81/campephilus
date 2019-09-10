package org.cqu.edu.msc.annihilation.campephilus.module.core.enums;

import lombok.Getter;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/21 15:16
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Getter
public enum CollectorStateEnum {

    /**
     * 采集器正在运行
     */
    RUNNING(1),

    /**
     * 采集器离线
     */
    OFFLINE(-1),
    ;

    private Integer code;

    CollectorStateEnum(Integer code) {
        this.code = code;
    }
}
