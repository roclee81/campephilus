package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.cqu.edu.msc.annihilation.common.converter.LocalDateTimeConverter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 15:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_before_operation")
public class BeforeOperationInfo implements Serializable {

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

    /**
     * 数据创建时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 数据修改时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "gmt_modified")
    private LocalDateTime gmtModified;
}
