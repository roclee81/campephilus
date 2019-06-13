package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 22:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_operation")
public class OperationInfo extends BaseInfoSuperclass implements Serializable {

    private static final long serialVersionUID = -5085503116296589504L;
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
    @Column(name = "operation_start_time")
    private Timestamp operationStartTime;

    /**
     * 手术结束时间
     */
    @Column(name = "operation_end_time")
    private Timestamp operationEndTime;

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
}

