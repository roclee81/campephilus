package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.servicesystem;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
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
 * 服务体系评价
 * @author cz
 */
@Data
@Entity(name = "serviceSystemEvaluation")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "eval_service_system_evaluation")
public class EvalServiceSystem implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private int id;

    private String deviceCategory;

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

    private String isProvideConsultBeforeSale;

    private String isKnowYourDemand;

    private String isProvideTrial;

    private String isExplainFunction;

    private String isIntroductionDeviceMaintainAndUpdateDetail;

    private String isProvideInstallAndTrain;

    private String guaranteePeriod;

    private String visitCustomerPeriod;

    private String visitCustomerWay;

    private String averageResponseTimeWhenDeviceFault;

    private String averageMaintainTimeWhenDeviceFault;

    private String jingXiaoBiDeviceWorkYear;

    private String jingXiaoBiPatientNumEveryYear;

    private String jingXiaoBiAveragePayEveryPatient;

    private String jingXiaoBiDeviceSalePrice;

    private String jingXiaoBiTotalPayForMaintainAfterBuy;

    private String economicApplicabilityPerformanceRate;

    private String economicApplicabilityFirstGuaranteePeriod;

    private String economicApplicabilityRenewalMethodAndPrice;

    private String economicApplicabilityWarrantyPrice;

    private String economicApplicabilitySoftwareUpdatePrice;

    private String trainServiceDescriptionPractical;

    private String trainServiceFeedbackInTime;

    private String trainServiceRemoteTechnicalSupport;

    private String trainServiceClinicalApplicationTraining;

    private String trainServiceDeviceInstallMaintainTraining;

    private String afterSaleServiceResponseTime;

    private String afterSaleServiceFaultExcludeTime;

    private String afterSaleServiceMaintainPrice;

    private String afterSaleServiceProducerAttitude;

    private String afterSaleServiceComplaintHandingSatisfaction;


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
