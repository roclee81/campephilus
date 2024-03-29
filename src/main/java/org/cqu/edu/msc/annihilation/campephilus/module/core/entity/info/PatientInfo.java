package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.cqu.edu.msc.annihilation.common.converter.LocalDateTimeConverter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 21:47
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_patient")
public class PatientInfo implements Serializable {

    private static final long serialVersionUID = -352019166921430764L;
    /**
     * 标记id，自动增长
     */
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 病人身份证号
     */
    @NotBlank(message = "patientId must cannot empty")
    @Column(name = "patient_id")
    private String patientId;

    /**
     * 住院号
     */
    @NotBlank(message = "admissionNumber must cannot empty")
    @Column(name = "admission_number")
    private String admissionNumber;

    /**
     * 性别0--男，1--女
     */
    @NotNull(message = "sex must cannot empty")
    @Column(name = "sex")
    private Integer sex;

    /**
     * 体重
     */
    @NotNull(message = "height must cannot empty")
    @Column(name = "height")
    private Integer height;

    /**
     * 体重
     */
    @NotNull(message = "weight must cannot empty")
    @Column(name = "weight")
    private Float weight;

    /**
     * 年龄
     */
    @NotNull(message = "age must cannot empty")
    @Column(name = "age")
    private Integer age;

    /**
     * 手术顺序号
     */
    @NotNull(message = "operationNumber must cannot empty")
    @Column(name = "operation_number")
    private Integer operationNumber;

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
