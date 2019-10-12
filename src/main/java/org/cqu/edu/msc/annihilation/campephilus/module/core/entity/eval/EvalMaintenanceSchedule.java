package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/10/11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "eval_maintenance_schedule")
public class EvalMaintenanceSchedule extends BaseEvalSuperclass implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 原始值
     */
    private String name;

    /**
     * 医院名称
     */
    private String hospitalName;

    /**
     * 仪器厂家
     */
    private String deviceProducer;

    /**
     * 仪器名称
     */
    private String deviceName;

    /**
     * 仪器编号
     */
    private String deviceUniqueId;

    /**
     * 已使用年限
     */
    private String hasBeenUsedYears;

    /**
     * 质保期
     */
    private String guaranteePeriod;

    /**
     * 延保费用
     */
    private String extendWarrantyPrice;

    /**
     * 负责人
     */
    private String chargeMan;

    /**
     * 发生故障时间
     */
    private String faultHappenTime;

    /**
     * 通知维修时间
     */
    private String informMaintainTime;

    /**
     * 开始维修时间
     */
    private String startMaintainTime;

    /**
     * 恢复使用时间
     */
    private String recoverUseTime;

    /**
     * 维修方式
     */
    private String maintainWay;

    /**
     * 维修人员
     */
    private String maintainPerson;

    /**
     * 保修期内
     */
    private String isInWarrantyPeriod;

    /**
     * 故障原因
     */
    private String faultReason;

    /**
     * 更换配件
     */
    private String isChangeAccessory;

    /**
     * 故障解决
     */
    private String isFixFault;

    /**
     * 维修响应时间满意度
     */
    private String maintainResponseTimeSatisfaction;

    /**
     * 维修价格满意度
     */
    private String maintainPriceSatisfaction;

    /**
     * 维修服务态度满意度
     */
    private String maintainServiceAttitudeSatisfaction;

    /**
     * 维修过程整体满意度
     */
    private String maintainWholeProcessSatisfaction;

    /**
     * 费用_配件费
     */
    private String accessoryPrice;

    /**
     * 费用_维修费
     */
    private String maintainPrice;

    /**
     * 费用_其他
     */
    private String otherPrice;
}