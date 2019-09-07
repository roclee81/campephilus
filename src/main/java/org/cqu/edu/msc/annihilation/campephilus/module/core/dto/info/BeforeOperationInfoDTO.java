package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 15:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class BeforeOperationInfoDTO implements Serializable {

    private static final long serialVersionUID = 2308270897924254358L;

    /**
     * 麻醉方式
     */
    private String anesthesiaMode;

    /**
     * 是否急诊
     */
    private Boolean isUrgent;

    /**
     * ASA等级
     */
    private Integer ASALevel;

    /**
     * 既往病史
     */
    private String medicalHistory;

    /**
     * 特殊情况
     */
    private String specialCase;

    /**
     * 住院号
     */
    private String admissionNumber;

    private Long longModified;

    private Long longCreate;
}
