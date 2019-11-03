package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * 麻醉深度类监护仪实体
 * @author cz
 */
@Data
@Entity(name = "hemoglobinMonitorEvaluation")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "eval_application_hemoglobin_monitor")
public class EvalApplicationHemoglobinMonitor {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private int id;

    private String companyName;

    private String deviceType;

    private String otherDeviceType;

    private String doctorName;

    private String doctorCompany;

    private String doctorDepartment;

    private String doctorDuty;

    private String doctorProfessionalTitle;

    private String doctorWorkYear;

    private String doctorFamiliarWithDevice;

    private String controlPanelDesignReasonable;

    private String controlPanelOperationConvenient;

    private String displayScreenDesignReasonable;

    private String displayScreenOperationConvenient;

    private String leadWireDesignReasonable;

    private String leadWireOperationConvenient;

    private String moveAndFixDeviceDesignReasonable;

    private String moveAndFixDeviceOperationConvenient;

    private String backupPowerUseTimeDesignReasonable;

    private String backupPowerUseTimeOperationConvenient;

    private String monitorParameterSetAndValueDesignReasonable;

    private String monitorParameterSetAndValueOperationConvenient;

    private String monitorParameterDisplayWayDesignReasonable;

    private String monitorParameterDisplayWayOperationConvenient;

    private String turnOnSelfTestDesignReasonable;

    private String turnOnSelfTestOperationConvenient;

    private String dataStoreFunctionDesignReasonable;

    private String dataStoreFunctionOperationConvenient;

    private String dataExportFunctionDesignReasonable;

    private String dataExportFunctionOperationConvenient;

    private String parameterAccuracyWithMonitorParameter;

    private String jamproofCapabilityWithMonitor;

    private String alertDeviceInTime;

    private String faultRateWithMainframe;

    private String faultRateWithMonitorModule;

    private String faultRateWithLeadWireAndSensor;

    private String identityBleedWithAccuracy;

    private String bloodTransfusionWithAccuracy;

    private String advantageCompareOtherBrand;

    private String disadvantageCompareOtherBrand;


    /**
     * 创建时间
     */
    @CreationTimestamp
    @Column(name = "gmt_create", updatable = false)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Column(name = "gmt_modified")
    private LocalDateTime updateTime;

}
