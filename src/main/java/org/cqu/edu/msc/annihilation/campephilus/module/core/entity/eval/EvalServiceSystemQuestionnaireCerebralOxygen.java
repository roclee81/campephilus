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
@Table(name = "eval_service_system_questionnaire_cerebral_oxygen")
public class EvalServiceSystemQuestionnaireCerebralOxygen extends BaseEvalSuperclass implements Serializable {

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
     * 1.公司名称
     */
    private String companyName;

    /**
     * 2.设备型号
     */
    private String deviceType;

    /**
     * 3.其他型号
     */
    private String otherDeviceType;

    /**
     * 1.医生姓名
     */
    private String doctorName;

    /**
     * 2.单位
     */
    private String doctorCompany;

    /**
     * 3.科室
     */
    private String doctorDepartment;

    /**
     * 4.职务
     */
    private String doctorDuty;

    /**
     * 5.职称
     */
    private String doctorProfessionalTitle;

    /**
     * 6.工作年限
     */
    private String doctorWorkYear;

    /**
     * 7.您对该仪器的熟悉程度
     */
    private String doctorFamiliarWithDevice;

    /**
     * 1. 该仪器销售厂家（以下简称厂家）提供销售前技术信息咨询服务：
     */
    private String isProvideConsultBeforeSale;

    /**
     * 2.厂家详细了解您对该仪器功能与性能方面的需求：
     */
    private String isKnowYourDemand;

    /**
     * 3.厂家提供购买前仪器试用
     */
    private String isProvideTrial;

    /**
     * 4.厂家在销售过程中详细讲解仪器的功能与性能及售后服务内容
     */
    private String isExplainFunction;

    /**
     * 5. 厂家在售后详细交代仪器维护、定期回访、升级换代指导服务
     */
    private String isIntroductionDeviceMaintainAndUpdateDetail;

    /**
     * 6. 厂家在该仪器售后提供上门安装和培训
     */
    private String isProvideInstallAndTrain;

    /**
     * 7. 厂家承诺的该仪器质保年限是
     */
    private String guaranteePeriod;

    /**
     * 8.厂家定期回访时间是
     */
    private String visitCustomerPeriod;

    /**
     * 9. 厂家定期回访形式
     */
    private String visitCustomerWay;

    /**
     * 10.仪器故障服务平均响应时间是
     */
    private String averageResponseTimeWhenDeviceFault;

    /**
     * 11. 故障后平均维修时间是
     */
    private String averageMaintainTimeWhenDeviceFault;

    /**
     * 12.1仪器购入年限
     */
    private String jingXiaoBiDeviceWorkYear;

    /**
     * 12.2平均每年使用仪器患者数量
     */
    private String jingXiaoBiPatientNumEveryYear;

    /**
     * 12.3平均收费单价
     */
    private String jingXiaoBiAveragePayEveryPatient;

    /**
     * 12.4仪器购入总价格
     */
    private String jingXiaoBiDeviceSalePrice;

    /**
     * 12.5仪器购入至今维护保养总费用
     */
    private String jingXiaoBiTotalPayForMaintainAfterBuy;

    /**
     * 仪器整体性价比
     */
    private String economicApplicabilityPerformanceRate;

    /**
     * 厂家提供的首次保修年限
     */
    private String economicApplicabilityFirstGuaranteePeriod;

    /**
     * 厂家提供的续保方式和价格
     */
    private String economicApplicabilityRenewalMethodAndPrice;

    /**
     * 厂家提供的保修价格
     */
    private String economicApplicabilityWarrantyPrice;

    /**
     * 厂家提供的软件升级价格
     */
    private String economicApplicabilitySoftwareUpdatePrice;

    /**
     * 仪器产品说明书实用性
     */
    private String trainServiceDescriptionPractical;

    /**
     * 厂家咨询反馈及时性
     */
    private String trainServiceFeedbackInTime;

    /**
     * 厂家远程技术支持
     */
    private String trainServiceRemoteTechnicalSupport;

    /**
     * 厂家提供的临床应用培训
     */
    private String trainServiceClinicalApplicationTraining;

    /**
     * 厂家提供的仪器安装保养培训
     */
    private String trainServiceDeviceInstallMaintainTraining;

    /**
     * 厂家售后响应时间
     */
    private String afterSaleServiceResponseTime;

    /**
     * 厂家维修故障排除时间
     */
    private String afterSaleServiceFaultExcludeTime;

    /**
     * 需要的维修价格
     */
    private String afterSaleServiceMaintainPrice;

    /**
     * 厂家售后服务态度
     */
    private String afterSaleServiceProducerAttitude;

    /**
     * 厂家投诉处理满意度
     */
    private String afterSaleServiceComplaintHandingSatisfaction;
}