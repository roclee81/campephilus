package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info;

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
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_before_operation")
public class BeforeOperationInfo extends BaseInfoSuperclass implements Serializable {

    private static final long serialVersionUID = 2308270897924254358L;
    /**
     * 标记id，自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 麻醉方式
     */
    @Column(name = "anesthesia_mode")
    private String anesthesiaMode;

    /**
     * 是否急诊
     */
    @Column(name = "is_urgent")
    private Boolean isUrgent;

    /**
     * 是否增强
     */
    @Column(name = "is_strong")
    private Boolean isStrong;

    /**
     * ASA等级
     */
    @Column(name = "ASA_level")
    private Integer ASALevel;

    /**
     * 既往病史
     */
    @Column(name = "medical_history")
    private String medicalHistory;

    /**
     * 特殊情况
     */
    @Column(name = "special_case")
    private String specialCase;

    /**
     * 住院号
     */
    @NotBlank(message = "admissionNumber must cannot empty")
    @Column(name = "admission_number")
    private String admissionNumber;
}
