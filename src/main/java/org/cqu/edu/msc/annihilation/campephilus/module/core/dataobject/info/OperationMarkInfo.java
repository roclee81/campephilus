package org.cqu.edu.msc.annihilation.campephilus.module.core.dataobject.info;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
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
@DynamicUpdate
@Entity
@Data
@Table(name = "info_operation_mark")
public class OperationMarkInfo {

    /**
     * 标记id，自动增长
     */
    @Id
    @GeneratedValue
    @Column(name = "pk_mark_id")
    private Integer markId;

    /**
     * 标记类型
     */
    @Column(name = "mark_type")
    private String markType;

    /**
     * 事件类型
     */
    @Column(name = "event_type")
    private String eventType;

    /**
     * 事件
     */
    @Column(name = "event")
    private String event;

    /**
     * 途径
     */
    @Column(name = "way")
    private String way;

    /**
     * 剂量
     */
    @Column(name = "dose")
    private String dose;

    /**
     * 不良反应/特殊情况
     */
    @Column(name = "special_situation")
    private String specialSituation;

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
