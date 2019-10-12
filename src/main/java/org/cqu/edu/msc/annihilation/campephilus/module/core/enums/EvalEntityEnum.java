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

    EVAL_ANESTHESIA_DEPTH(1),

    EVAL_CEREBRAL_OXYGEN(2),

    EVAL_ANESTHESIA_MACHINE(3),

    EVAL_CEREBRAL_OXIMETRY(4),

    EVAL_MAINTENANCE_SCHEDULE(5),

    EVAL_MONITOR(6),

    EVAL_NON_INVASIVE_HEMOGLOBIN(7),

    EVAL_SERVICE_SYSTEM_QUESTIONNAIRE_ANESTHESIA_DEPTH(8),

    EVAL_SERVICE_SYSTEM_QUESTIONNAIRE_ANESTHESIA_MACHINE(9),

    EVAL_SERVICE_SYSTEM_QUESTIONNAIRE_BREATHING_MACHINE(10),

    EVAL_SERVICE_SYSTEM_QUESTIONNAIRE_CEREBRAL_OXYGEN(11),

    EVAL_SERVICE_SYSTEM_QUESTIONNAIRE_MONITOR(12),

    EVAL_SERVICE_SYSTEM_QUESTIONNAIRE_NON_INVASIVE_HEMOGLOBIN(13),
    ;

    /**
     * 访问时的code
     */
    private Integer code;

    EvalEntityEnum(Integer code) {
        this.code = code;
    }
}