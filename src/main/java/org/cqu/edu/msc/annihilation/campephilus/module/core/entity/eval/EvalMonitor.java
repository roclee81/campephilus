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
@Table(name = "eval_monitor")
public class EvalMonitor extends BaseEvalSuperclass implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

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
     * 控制面板（包括电源开关、各种监测参数与模式调节等）
     */
    private String controlPanelDesignReasonable;

    /**
     *
     */
    private String controlPanelOperationConvenient;

    /**
     * 显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）
     */
    private String displayScreenDesignReasonable;

    /**
     *
     */
    private String displayScreenOperationConvenient;

    /**
     * 脉搏氧饱和度监测模块
     */
    private String pulseOxygenSaturationModuleDesignReasonable;

    /**
     *
     */
    private String pulseOxygenSaturationModuleOperationConvenient;

    /**
     * 心电图监测模块
     */
    private String ecgModuleDesignReasonable;

    /**
     *
     */
    private String ecgModuleOperationConvenient;

    /**
     * 无创血压袖带
     */
    private String nibpCuffDesignReasonable;

    /**
     *
     */
    private String nibpCuffOperationConvenient;

    /**
     * 有创血压监测模块
     */
    private String ibpModuleDesignReasonable;

    /**
     *
     */
    private String ibpModuleOperationConvenient;

    /**
     * 呼气末co2监测模块
     */
    @Column(name = "ETCO2_module_design_reasonable")
    private String ETCO2ModuleDesignReasonable;

    /**
     *
     */
    @Column(name = "ETCO2_module_operation_convenient")
    private String ETCO2ModuleOperationConvenient;

    /**
     * 备用电源使用时间
     */
    private String backupPowerUseTimeDesignReasonable;

    /**
     *
     */
    private String backupPowerUseTimeOperationConvenient;

    /**
     * 转运功能（基于危重患者转运考虑的硬件设施配置）
     */
    private String transportFunctionDesignReasonable;

    /**
     *
     */
    private String transportFunctionOperationConvenient;

    /**
     * 监护参数页面布局
     */
    private String monitorParameterLayoutDesignReasonable;

    /**
     *
     */
    private String monitorParameterLayoutOperationConvenient;

    /**
     * 监护参数调节（采集频率、数据形式等）
     */
    private String monitorParameterAdjustDesignReasonable;

    /**
     *
     */
    private String monitorParameterAdjustOperationConvenient;

    /**
     * 监测参数全面性（可监测的参数种类是否齐全）
     */
    private String monitorParameterComprehensiveDesignReasonable;

    /**
     *
     */
    private String monitorParameterComprehensiveOperationConvenient;

    /**
     * 开机启动及自检功能设置
     */
    private String turnOnSelfTestDesignReasonable;

    /**
     *
     */
    private String turnOnSelfTestOperationConvenient;

    /**
     * 数据导出功能
     */
    private String dataExportFunctionDesignReasonable;

    /**
     *
     */
    private String dataExportFunctionOperationConvenient;

    /**
     * 监护参数：心率
     */
    private String parameterAccuracyWithHeartRate;

    /**
     * 监护参数：无创血压
     */
    private String parameterAccuracyWithNibp;

    /**
     * 监护参数：有创血压
     */
    private String parameterAccuracyWithIbp;

    /**
     * 监护参数：脉搏氧饱和度
     */
    private String parameterAccuracyWithPulseOxygenSaturation;

    /**
     * 监护参数：体温
     */
    private String parameterAccuracyWithBodyTemperature;

    /**
     * 监护参数：呼气末co2
     */
    @Column(name = "parameter_accuracy_with_ETCO2")
    private String parameterAccuracyWithETCO2;

    /**
     * 监护参数：呼气末吸入麻醉剂浓度
     */
    private String parameterAccuracyWithEtAnestheticsMol;

    /**
     * 其他监护参数：麻醉深度、脑氧等
     */
    private String parameterAccuracyWithOtherParameter;

    /**
     * 心电监护抗干扰能力
     */
    private String jamproofCapabilityWithEcg;

    /**
     * 血压监测抗干扰能力
     */
    private String jamproofCapabilityWithBp;

    /**
     * 脉搏氧饱和度抗干扰能力
     */
    private String jamproofCapabilityWithPulseOxygenSaturation;

    /**
     * 即时与可靠性
     */
    private String alertDeviceInTime;

    /**
     * 主机
     */
    private String faultRateWithMainframe;

    /**
     * 监测模块（如呼末co2）
     */
    private String faultRateWithMonitorModule;

    /**
     * 各种导联线的主机接口
     */
    private String faultRateWithLeadWireAndSensor;

    /**
     * 高血压、低血压识别准确率
     */
    private String monitorBpWithSatisfaction;

    /**
     * 心率变化、心律失常识别准确率
     */
    private String monitorEcgWithSatisfaction;

    /**
     * 患者缺氧识别准确率
     */
    private String monitorPulseOxygenSaturationWithSatisfaction;

    /**
     * 患者co2蓄积识别准确率
     */
    @Column(name = "monitor_ECTO2_with_satisfaction")
    private String monitorETCO2WithSatisfaction;

    /**
     * 您觉得该仪器相比其他品牌最大的优势是什么
     */
    private String advantageCompareOtherBrand;

    /**
     * 您觉得该仪器相比其他品牌最大的不足是什么
     */
    private String disadvantageCompareOtherBrand;
}