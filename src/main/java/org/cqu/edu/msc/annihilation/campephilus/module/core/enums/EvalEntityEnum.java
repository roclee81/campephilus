package org.cqu.edu.msc.annihilation.campephilus.module.core.enums;

import lombok.Getter;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/25
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Getter
public enum EvalEntityEnum {

    /**
     *
     */
    EVAL_ANESTHESIA_DEPTH(1);


    private Integer code;

    EvalEntityEnum(Integer code) {
        this.code = code;
    }
}