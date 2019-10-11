package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/9/30
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "eval_cerebral_oxygen")
public class EvalCerebralOxygen extends BaseEvalSuperclass implements Serializable {
    private static final long serialVersionUID = -1504652048484000205L;

    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**1.公司名称**/
    private  String  companyName;

    /**2.设备型号**/
    private  String  deviceType;

    /**3.其他型号**/
    private  String  otherDeviceType;

    /**1.医生姓名**/
    private  String  doctorName;

    /**2.单位**/
    private  String  doctorCompany;

    /**3.科室**/
    private  String  doctorDepartment;

    /**4.职务**/
    private  String  doctorDuty;

    /**5.职称**/
    private  String  doctorProfessionalTitle;

    /**6.工作年限**/
    private  String  doctorWorkYear;

    /**7.您对该仪器的熟悉程度**/
    private  String  doctorFamiliarWithDevice;

    /**控制面板（包括电源开关、传感器插头等）**/
    private  String  controlPanel_designReasonable;

    /****/
    private  String  controlPanel_operationConvenient;

    /**显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）**/
    private  String  displayScreen_designReasonable;

    /****/
    private  String  displayScreen_operationConvenient;

    /**监测导联线与电极（连接是否方便、稳定）**/
    private  String  leadWire_designReasonable;

    /****/
    private  String  leadWire_operationConvenient;

    /**移动与固定装置**/
    private  String  moveAndFixDevice_designReasonable;

    /****/
    private  String  moveAndFixDevice_operationConvenient;

    /**备用电源使用时间**/
    private  String  backupPowerUseTime_designReasonable;

    /****/
    private  String  backupPowerUseTime_operationConvenient;

    /**监护参数指标设置与价值**/
    private  String  monitorParameterSetAndValue_designReasonable;

    /****/
    private  String  monitorParameterSetAndValue_operationConvenient;

    /**监护参数指标的展现形式（数字、图、表等）**/
    private  String  monitorParameterDisplayWay_designReasonable;

    /****/
    private  String  monitorParameterDisplayWay_operationConvenient;

    /**开机启动及自检功能设置与时间**/
    private  String  turnOnSelfTest_designReasonable;

    /****/
    private  String  turnOnSelfTest_operationConvenient;

    /**监测参数全面性（可监测的其他脑电参数种类是否齐全）**/
    private  String  monitorParameterComprehensive_designReasonable;

    /****/
    private  String  monitorParameterComprehensive_operationConvenient;

    /**数据存储功能**/
    private  String  dataStoreFunction_designReasonable;

    /****/
    private  String  dataStoreFunction_operationConvenient;

    /**数据导出功能**/
    private  String  dataExportFunction_designReasonable;

    /****/
    private  String  dataExportFunction_operationConvenient;

    /**监护参数：脑灌注与脉氧饱和度数值的相关性**/
    private  String  parameterAccuracyWithMonitorParameter;

    /**监测抗干扰能力**/
    private  String  jamproofCapabilityWithMonitor;

    /**即时与可靠性**/
    private  String  alertDeviceInTime;

    /**主机**/
    private  String  faultRateWithMainframe;

    /**监测模块**/
    private  String  faultRateWithMonitorModule;

    /**导联线与传感器**/
    private  String  faultRateWithLeadWireAndSensor;

    /**脑氧监护对防止术中脑缺氧的效果（麻醉科填写）**/
    private  String  monitorBrainOxygenWithSatisfaction;

    /**组织氧监护对防止术中肾损伤的效果（麻醉科填写）**/
    private  String  monitorKidneyDamageWithSatisfaction;

    /**脑氧监护对脑缺血缺氧损伤识别的帮助（神经内、外科填写）**/
    private  String  monitorBrainIschemicWithSatisfaction;

    /**您觉得该仪器相比其他品牌最大的优势是什么**/
    private  String  advantageCompareOtherBrand;

    /**您觉得该仪器相比其他品牌最大的不足是什么**/
    private  String  disadvantageCompareOtherBrand;
}