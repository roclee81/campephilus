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
 * @date 2018/12/19 22:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicUpdate
@Entity
@Data
@Table(name = "info_operation")
public class OperationInfo {

    /**
     * 手术顺序号
     */
    @Id
    @GeneratedValue
    @Column(name = "operation_id")
    private Integer operationId;

    /**
     * 手术名称
     */
    @Column(name = "operation_name")
    private String operationName;

    /**
     * 手术开始时间
     */
    @Column(name = "operation_start_time")
    private Date operationStartTime;

    /**
     * 手术结束时间
     */
    @Column(name = "operation_end_time")
    private Date operationEndTime;

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

