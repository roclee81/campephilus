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
@Table(name = "eval_anesthesia_machine")
public class EvalAnesthesiaMachineEntity  extends BaseEvalSuperclass implements Serializable {

    private static final long serialVersionUID = -5424765749082208612L;

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

    /**控制面板（包括电源开关、手/自动切换、参数调节）**/
    private  String  controlPanel_designReasonable;

    /****/
    private  String  controlPanel_operationConvenient;

    /**显示屏（显示颜色、字体或图形、布局、尺寸大小等）**/
    private  String  displayScreen_designReasonable;

    /****/
    private  String  displayScreen_operationConvenient;

    /**手控装置、位置与操控**/
    private  String  handControlDevice_designReasonable;

    /****/
    private  String  handControlDevice_operationConvenient;

    /**风箱及摆放位置**/
    private  String  bellowsAndItsPosition_designReasonable;

    /****/
    private  String  bellowsAndItsPosition_operationConvenient;

    /**钠石灰罐与装卸设置**/
    private  String  sodaLimeTankWithLoadAndUnload_designReasonable;

    /****/
    private  String  sodaLimeTankWithLoadAndUnload_operationConvenient;

    /**呼吸回路接口**/
    private  String  breathLoopAndInterface_designReasonable;

    /****/
    private  String  breathLoopAndInterface_operationConvenient;

    /**气体流量调节装置（氧气、空气）**/
    private  String  gasFlowControlDevice_designReasonable;

    /****/
    private  String  gasFlowControlDevice_operationConvenient;

    /**备用电源使用时间**/
    private  String  backupPowerUseTime_designReasonable;

    /****/
    private  String  backupPowerUseTime_operationConvenient;

    /**挥发罐与开关、加药设置**/
    private  String  volatilizeTankAndSwitch_designReasonable;

    /****/
    private  String  volatilizeTankAndSwitch_operationConvenient;

    /**废气排放装置**/
    private  String  flueGasLetOutDevice_designReasonable;

    /****/
    private  String  flueGasLetOutDevice_operationConvenient;

    /**麻醉机移动与固定装置**/
    private  String  moveAndFixDevice_designReasonable;

    /****/
    private  String  moveAndFixDevice_operationConvenient;

    /**麻醉机操作台大小、位置、使用方便等**/
    private  String  operatingFloorSizeAndPosition_designReasonable;

    /****/
    private  String  operatingFloorSizeAndPosition_operationConvenient;

    /**储物柜**/
    private  String  locker_designReasonable;

    /****/
    private  String  locker_operationConvenient;

    /**数据接口类型、数量、功能**/
    private  String  dataInterfaceTypeAndFunction_designReasonable;

    /****/
    private  String  dataInterfaceTypeAndFunction_operationConvenient;

    /**呼吸模式种类**/
    private  String  breathPatternType_designReasonable;

    /****/
    private  String  breathPatternType_operationConvenient;

    /**呼气末CO2浓度监测模块**/
    private  String  ETCO2Module_designReasonable;

    /****/
    private  String  ETCO2Module_operationConvenient;

    /**吸入麻醉剂浓度监测模块**/
    private  String  anestheticMolMonitorModule_designReasonable;

    /****/
    private  String  anestheticMolMonitorModule_operationConvenient;

    /**开机自检功能设置与自检速度**/
    private  String  turnOnSelfTest_designReasonable;

    /****/
    private  String  turnOnSelfTest_operationConvenient;

    /**数据导出功能**/
    private  String  dataExportFunction_designReasonable;

    /****/
    private  String  dataExportFunction_operationConvenient;

    /**麻醉机自检准确性**/
    private  String  parameterAccuracyWithSelfTest;

    /**呼吸参数：潮气量**/
    private  String  parameterAccuracyWithTidalVolume;

    /**呼吸参数：呼吸频率**/
    private  String  parameterAccuracyWithBreathFrequency;

    /**呼吸参数：气道压**/
    private  String  parameterAccuracyWithAirwayPressure;

    /**呼吸参数：吸呼比**/
    private  String  parameterAccuracyWithInspiratoryAndExpiratory;

    /**呼吸参数：氧浓度**/
    private  String  parameterAccuracyWithOxygenMol;

    /**挥发罐浓度控制**/
    private  String  parameterAccuracyWithVolatilizeTanksMolControl;

    /**监测参数：吸入麻醉药浓度或MAC**/
    private  String  parameterAccuracyWithMAC;

    /**监测参数：呼末CO2**/
    private  String  parameterAccuracyWithETC02;

    /**钠石灰罐**/
    private  String  loopClosureWithSodaLimeTank;

    /**呼吸回路**/
    private  String  loopClosureWithBretheLoop;

    /**废气排放回路**/
    private  String  loopClosureWithFlueGasLetOutLoop;

    /**即时与可靠性**/
    private  String  alertDeviceInTime;

    /**主机**/
    private  String  faultRateWithMainframe;

    /**监测模块（呼末CO2、麻醉气体监测、氧浓度监测等）**/
    private  String  faultRateWithMonitorModule;

    /**辅助配件**/
    private  String  faultRateWithAssistDevice;

    /**综合考虑患者使用过程出现的高碳酸血症发生率；因机器故障缺氧意外等事件**/
    private  String  mechanicalVentilationWithSatisfaction;

    /**吸入麻醉引起麻醉过深或过浅的发生情况**/
    private  String  anestheticEffectWithSatisfaction;

    /**您觉得该仪器相比其他品牌最大的优势是什么**/
    private  String  advantageCompareOtherBrand;

    /**您觉得该仪器相比其他品牌最大的不足是什么**/
    private  String  disadvantageCompareOtherBrand;
}
