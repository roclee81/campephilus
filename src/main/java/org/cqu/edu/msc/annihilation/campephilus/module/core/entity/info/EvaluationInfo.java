package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.cqu.edu.msc.annihilation.common.converter.LocalDateTimeConverter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 评价表单
 *
 * @author cz
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_evaluation")
public class EvaluationInfo implements Serializable {

    private static final long serialVersionUID = -4113168698465125393L;
    /**
     * 标记id，自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 手术顺序号
     */
    @Column(name = "operation_number")
    private Integer operationNumber;

    /**
     * 仪器代号
     */
    @Column(name = "device_code")
    private Integer deviceCode;

    /**
     * 仪器序列号
     */
    @Column(name = "serial_number")
    private String serialNumber;

    /**
     * 使用科室
     */
    @Column(name = "device_department")
    private String deviceDepartment;

    /**
     * 使用评价等级
     */
    @Column(name = "experience_level")
    private String experienceLevel;

    /**
     * 可靠性等级
     */
    @Column(name = "reliability_level")
    private String reliabilityLevel;

    /**
     * 是否有错误信息
     */
    @Column(name = "has_error")
    private Boolean hasError;

    /**
     * 错误原因
     */
    @Column(name = "known_error")
    private String knownError;

    /**
     * 其他错误
     */
    @Column(name = "other_error")
    private String otherError;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 记录人签名
     */
    @Column(name = "record_name")
    private String recordName;

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
