package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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
public class OperationInfo {

    /**
     * 手术顺序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @NotNull(message = "operationStartTime must cannot empty")
    @Column(name = "operation_start_time")
    private Date operationStartTime;

    /**
     * 手术结束时间
     */
    @NotNull(message = "operationEndTime must cannot empty")
    @Column(name = "operation_end_time")
    private Date operationEndTime;

    /**
     * 用于保存手术中采用的设备，临时存储，存储时将会转换为String
     */
    @Transient
    private List deviceInfo;

    /**
     * 手术设备，直接保存了JSON字符串
     */
    @NotBlank(message = "operationDevice must cannot empty")
    @Column(name = "operation_device")
    private String operationDevice;

    /**
     * 手术状态
     */
    @Column(name = "operation_state")
    private Integer operationState;

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
}

