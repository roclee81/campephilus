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
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 22:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_operation")
public class OperationInfo implements Serializable {

    private static final long serialVersionUID = -5085503116296589504L;
    /**
     * 手术顺序号
     */
    @Id
    @Column(name = "pk_operation_number")
    private Integer operationNumber;

    /**
     * 手术名称
     */
    @NotBlank(message = "operationName must cannot empty")
    @Column(name = "operation_name")
    private String operationName;

    /**
     * 手术开始时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "operation_start_time")
    private LocalDateTime operationStartTime;

    /**
     * 手术结束时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "operation_end_time")
    private LocalDateTime operationEndTime;

    /**
     * 手术状态
     */
    @Column(name = "operation_state")
    private Integer operationState;

    /**
     * 全国医院序列号，唯一
     */
    @NotBlank(message = "hospitalCode must cannot empty")
    @Column(name = "hospital_code")
    private String hospitalCode;

    /**
     * 医院的手术顺序号
     * 每个医院的都不一样
     */
    @NotBlank(message = "hospital_operation_number must cannot empty")
    @Column(name = "hospital_operation_number")
    private String hospitalOperationNumber;

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

