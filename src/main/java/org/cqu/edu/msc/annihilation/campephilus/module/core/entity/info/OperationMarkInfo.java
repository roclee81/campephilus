package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info;

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
 * @date 2018/12/19 20:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_operation_mark")
public class OperationMarkInfo implements Serializable {

    private static final long serialVersionUID = -4892589808381433198L;
    /**
     * 标记id，自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 标记大类型
     */
    @NotBlank(message = "mark_main_type must cannot empty")
    @Column(name = "mark_main_type")
    private String markMainType;

    /**
     * 标记类型
     */
    @NotBlank(message = "`mark_sub_Type` must cannot empty")
    @Column(name = "`mark_sub_Type`")
    private String markSubType;

    /**
     * 事件类型
     */
    @NotBlank(message = "mark_event must cannot empty")
    @Column(name = "mark_event")
    private String markEvent;

    /**
     * 途径
     */
    @NotBlank(message = "give_medicine_method must cannot empty")
    @Column(name = "give_medicine_method")
    private String giveMedicineMethod;

    /**
     * 剂量
     */
    @NotBlank(message = "give_medicine_volume must cannot empty")
    @Column(name = "give_medicine_volume")
    private String giveMedicineVolume;

    /**
     * 不良反应/特殊情况
     */
    @NotBlank(message = "side_effect must cannot empty")
    @Column(name = "side_effect")
    private String sideEffect;

    /**
     * 标记信息标记的时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @NotNull(message = "mark_time must cannot empty")
    @Column(name = "mark_time")
    private LocalDateTime markTime;

    /**
     * 手术顺序号
     */
    @Column(name = "operation_Number")
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
