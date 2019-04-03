package org.cqu.edu.msc.annihilation.campephilus.core.enums;

import lombok.Getter;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/17 15:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Getter
public enum OperationStateEnum {

    /**
     * 无效数据
     */
    INVALID_DATA(-1),

    /**
     * 手术还未开始，还在准备中
     */
    IN_PREPARATION(1),

    /**
     * 手术进行中
     */
    IN_PROGRESS(2),

    /**
     * 手术已经结束
     */
    FINISH(3),
    ;

    private Integer code;

    OperationStateEnum(Integer code) {
        this.code = code;
    }}
