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
 * @date 2018/12/19 20:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_operation_mark")
public class OperationMarkInfo {

    /**
     * 标记id，自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_mark_id")
    private Integer markId;

    /**
     * 标记类型
     */
    @NotBlank(message = "markType must cannot empty")
    @Column(name = "mark_type")
    private String markType;

    /**
     * 事件类型
     */
    @NotBlank(message = "eventType must cannot empty")
    @Column(name = "event_type")
    private String eventType;

    /**
     * 事件
     */
    @NotBlank(message = "event must cannot empty")
    @Column(name = "event")
    private String event;

    /**
     * 途径
     */
    @NotBlank(message = "way must cannot empty")
    @Column(name = "way")
    private String way;

    /**
     * 剂量
     */
    @NotBlank(message = "dose must cannot empty")
    @Column(name = "dose")
    private String dose;

    /**
     * 不良反应/特殊情况
     */
    @NotBlank(message = "specialSituation must cannot empty")
    @Column(name = "special_situation")
    private String specialSituation;

    /**
     * 标记信息标记的时间
     */
    @NotNull(message = "mark_time must cannot empty")
    @Column(name = "mark_time")
    private Date markTime;

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
