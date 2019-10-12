package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/***
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/9/24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "eval_anesthesia_depth")
public class EvalAnesthesiaDepth extends BaseEvalSuperclass implements Serializable {

    private static final long serialVersionUID = 3773311062423770773L;

    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 设备型号
     */
    private String deviceType;

    /**
     * 其他型号
     */
    private String otherDeviceType;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 单位
     */
    private String doctorCompany;

    /**
     * 科室
     */
    private String doctorDepartment;

    /**
     * 职务
     */
    private String doctorDuty;

    /**
     * 职称
     */
    private String doctorProfessionalTitle;

    /**
     * 工作年限
     */
    private String doctorWorkYear;

    /**
     * 您对该仪器的熟悉程度
     */
    private String doctorFamiliarWithDevice;

    /**
     * [硬件]控制面板（包括电源开关、传感器插头等）
     */
    private String controlPanelDesignReasonable;

    /**
     * [硬件]控制面板（包括电源开关、传感器插头等）
     */
    private String controlPanelOperationConvenient;

    /**
     * 硬件]显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）
     */
    private String displayScreenDesignReasonable;

    /**
     * 硬件]显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）
     */
    private String displayScreenOperationConvenient;

    /**
     * [硬件]监测导联线与电极（连接是否方便、稳定）
     */
    private String leadWireDesignReasonable;

    /**
     * [硬件]监测导联线与电极（连接是否方便、稳定）
     */
    private String leadWireOperationConvenient;

    /**
     * [硬件]移动与固定装置
     */
    private String moveAndFixDeviceDesignReasonable;

    /**
     * [硬件]移动与固定装置
     */
    private String moveAndFixDeviceOperationConvenient;

    /**
     * [硬件]备用电源使用时间
     */
    private String backupPowerUseTimeDesignReasonable;

    /**
     * [硬件]备用电源使用时间
     */
    private String backupPowerUseTimeOperationConvenient;

    /**
     * [软件]监护参数指标设置与价值
     */
    private String monitorParameterSetAndValueDesignReasonable;

    /**
     * [软件]监护参数指标设置与价值
     */
    private String monitorParameterSetAndValueOperationConvenient;

    /**
     * [软件]监护参数指标的展现形式（数字、图、表等）
     */
    private String monitorParameterDisplayWayDesignReasonable;

    /**
     * [软件]监护参数指标的展现形式（数字、图、表等）
     */
    private String monitorParameterDisplayWayOperationConvenient;

    /**
     * [软件]开机启动及自检功能设置与时间
     */
    private String turnOnSelfTestDesignReasonable;

    /**
     * [软件]开机启动及自检功能设置与时间
     */
    private String turnOnSelfTestOperationConvenient;

    /**
     * [软件]监测参数全面性（可监测的其他脑电参数种类是否齐全）
     */
    private String monitorParameterComprehensiveDesignReasonable;

    /**
     * [软件]监测参数全面性（可监测的其他脑电参数种类是否齐全）
     */
    private String monitorParameterComprehensiveOperationConvenient;

    /**
     * [软件]数据存储功能
     */
    private String dataStoreFunctionDesignReasonable;

    /**
     * [软件]数据存储功能
     */
    private String dataStoreFunctionOperationConvenient;

    /**
     * [软件]数据导出功能
     */
    private String dataExportFunctionDesignReasonable;

    /**
     * [软件]数据导出功能
     */
    private String dataExportFunctionOperationConvenient;

    /**
     * [临床可靠性_参数准确性]监护参数：与麻醉深度的相关性（麻醉科填写）
     */
    private String parameterAccuracyWithAnesthesiaDepth;

    /**
     * [临床可靠性_参数准确性]监护参数：与麻醉深度的相关性（麻醉科填写）
     */
    private String parameterAccuracyWithComaDepth;

    /**
     * [临床可靠性_参数准确性]与脑功能损伤程度的相关性（神经内外科填写）
     */
    private String parameterAccuracyWithBrainDamage;

    /**
     * [临床可靠性_参数准确性]监护参数响应时间（用药、操作、苏醒期等引起变化时监护参数的变化是否及时）
     */
    private String parameterAccuracyWithResponseTime;

    /**
     * [临床可靠性_抗干扰能力]监测抗干扰能力
     */
    private String jamproofCapabilityWithMonitor;

    /**
     * [临床可靠性_报警装置]即时与可靠性
     */
    private String alertDeviceInTime;

    /**
     * [临床可靠性_故障发生率]主机
     */
    private String faultRateWithMainframe;

    /**
     * [临床可靠性_故障发生率]监测模块
     */
    private String faultRateWithMonitorModule;

    /**
     * [临床可靠性_故障发生率]导联线与传感器
     */
    private String faultRateWithLeadWireAndSensor;

    /**
     * [临床使用效果_麻醉诱导期满意度]指导麻醉诱导时深度判断及用药选择（麻醉科填写）
     */
    private String anesthesiaInductionSatisfaction;

    /**
     * [临床使用效果_麻醉维持期满意度]指导麻醉维持期间深度判断及用药选择（麻醉科填写）
     */
    private String anesthesiaMaintainSatisfaction;

    /**
     * [临床使用效果_麻醉苏醒期满意度]指导麻醉苏醒情况（麻醉科填写）
     */
    private String anesthesiaRecoverySatisfaction;

    /**
     * [临床使用效果_意识情况判断满意度]辅助指导临床意识观察情况（神经内外科）
     */
    private String consciousJudgeSatisfaction;

    /**
     * [临床使用效果_脑功能损伤情况判断满意度]辅助指导临床脑功能损伤情况（神经内外科）
     */
    private String brainDamageJudgeSatisfaction;

    /**
     * [优劣势]您觉得该仪器相比其他品牌最大的优势是什么
     */
    private String advantageCompareOtherBrand;

    /**
     * [优劣势]您觉得该仪器相比其他品牌最大的不足是什么
     */
    private String disadvantageCompareOtherBrand;
}
