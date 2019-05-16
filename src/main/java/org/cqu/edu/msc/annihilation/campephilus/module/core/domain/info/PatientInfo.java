package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
public class PatientInfo {

    /**
     * 标记id，自动增长
     */
    @Id
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
    @NotBlank(message = "height must cannot empty")
    @Column(name = "height")
    private String height;

    /**
     * 体重
     */
    @NotBlank(message = "weight must cannot empty")
    @Column(name = "weight")
    private String weight;

    /**
     * 年龄
     */
    @NotNull(message = "age must cannot empty")
    @Column(name = "age")
    private Integer age;

    /**
     * 数据创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 数据修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 手术顺序号
     */
    @NotNull(message = "operationNumber must cannot empty")
    @Column(name = "operation_number")
    private Integer operationNumber;
}
