package org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
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
@DynamicUpdate
@Entity
@Data
@Table(name = "info_patient")
public class PatientInfo {

    /**
     * 标记id，自动增长
     */
    @Id
    @GeneratedValue
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 病人身份证号，主键
     */
    @Column(name = "pk_patient_id")
    private String patientId;

    /**
     * 住院号
     */
    @Column(name = "admission_number")
    private String admissionNumber;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 性别0--男，1--女
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 出生日期
     */
    @Column(name = "birth_date")
    private Date birthDate;

    /**
     * 体重
     */
    @Column(name = "weight")
    private String weight;

    /**
     * 年龄
     */
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
    @Column(name = "operation_id")
    private Integer operationId;
}
