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
@Table(name = "eval_non_invasive_hemoglobin")
public class EvalNonInvasiveHemoglobin extends BaseEvalSuperclass implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer pkId;

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
     * 1.[硬件]控制面板（包括电源开关、传感器插头等）
     */
    private String controlPanelDesignReasonable;

    /**
     *
     */
    private String controlPanelOperationConvenient;

    /**
     * 2.[硬件]显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）
     */
    private String displayScreenDesignReasonable;

    /**
     *
     */
    private String displayScreenOperationConvenient;

    /**
     * 3.[硬件]监测导联线与电极（连接是否方便、稳定）
     */
    private String leadWireDesignReasonable;

    /**
     *
     */
    private String leadWireOperationConvenient;

    /**
     * 4.[硬件]移动与固定装置
     */
    private String moveAndFixDeviceDesignReasonable;

    /**
     *
     */
    private String moveAndFixDeviceOperationConvenient;

    /**
     * 5.[硬件]备用电源使用时间
     */
    private String backupPowerUseTimeDesignReasonable;

    /**
     *
     */
    private String backupPowerUseTimeOperationConvenient;

    /**
     * 6.[软件]监护参数指标设置与价值
     */
    private String monitorParameterSetAndValueDesignReasonable;

    /**
     *
     */
    private String monitorParameterSetAndValueOperationConvenient;

    /**
     * 7.[软件]监护参数指标的展现形式（数字、图、表等）
     */
    private String monitorParameterDisplayWayDesignReasonable;

    /**
     *
     */
    private String monitorParameterDisplayWayOperationConvenient;

    /**
     * 8.[软件]开机启动及自检功能设置与时间
     */
    private String turnOnSelfTestDesignReasonable;

    /**
     *
     */
    private String turnOnSelfTestOperationConvenient;

    /**
     * 9.[软件]数据存储功能
     */
    private String dataStoreFunctionDesignReasonable;

    /**
     *
     */
    private String dataStoreFunctionOperationConvenient;

    /**
     * 10.[软件]数据导出功能
     */
    private String dataExportFunctionDesignReasonable;

    /**
     *
     */
    private String dataExportFunctionOperationConvenient;

    /**
     * 1.[临床可靠性_参数准确性]监护参数：血红蛋白数值与实际血红蛋白、术中输血与失血量的相关性
     */
    private String parameterAccuracyWithMonitorParameter;

    /**
     * 2.[临床可靠性_抗干扰能力]监测抗干扰能力
     */
    private String jamproofCapabilityWithMonitor;

    /**
     * 3.[临床可靠性_报警装置]即时与可靠性
     */
    private String alertDeviceInTime;

    /**
     * 4.[临床可靠性_故障发生率]主机
     */
    private String faultRateWithMainframe;

    /**
     * 5.[临床可靠性_故障发生率]监测模块
     */
    private String faultRateWithMonitorModule;

    /**
     * 6.[临床可靠性_故障发生率]导联线与传感器
     */
    private String faultRateWithLeadWireAndSensor;

    /**
     * 7.[临床可靠性_识别出血/失血的准确性和及时性]能否及时、准确的发现出血/失血状态
     */
    private String identityBleedWithAccuracy;

    /**
     * 8.[临床可靠性_输血指导准确性]输血、输液临床改善情况指导准确性
     */
    private String bloodTransfusionWithAccuracy;

    /**
     * 9.[优劣势]您觉得该仪器相比其他品牌最大的优势是什么
     */
    private String advantageCompareOtherBrand;

    /**
     * 10.[优劣势]您觉得该仪器相比其他品牌最大的不足是什么
     */
    private String disadvantageCompareOtherBrand;
}