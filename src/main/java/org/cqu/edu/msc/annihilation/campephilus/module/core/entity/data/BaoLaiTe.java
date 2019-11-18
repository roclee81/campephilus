package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.cqu.edu.msc.annihilation.common.converter.LocalDateTimeConverter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 宝莱特的数据实体类
 * @author cz
 *
 * 存储不同的参数数值以及对应的波形字符串以备后续使用
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "data_BaoLaiTe")
public class BaoLaiTe implements Serializable {

    private static final long serialVersionUID = -8052271381912697989L;

    /**
     * 心率数据值及其波形 E0
     */
    private Integer heartRate;

    private String heartRateWaveValue;

    /**
     * 血氧值模块数据及其波形 E1
     */
    private Integer bloodOxygen;
    private String bloodOxygenWaveValue;


    /**
     * 脉搏数据值 E2
     */
    private Integer pulse;

    /**
     * 呼吸率及其波形 E3
     */
    private Integer breatheRate;
    private String breatheRateWaveValue;


    /**
     * 体温值 E4
     */
    private Double temperature;

    /**
     * 无创血压全部数值（3个） E5
     */
    private Double noninvasiveBloodPressureSys;
    private Double noninvasiveBloodPressureMap;
    private Double noninvasiveBloodPressureDia;


    /**
     * 有创血压全部数值（3个）及其波形 E6
     */
    private Double invasiveBloodPressureSys;
    private Double invasiveBloodPressureMap;
    private Double invasiveBloodPressureDia;
    private String invasiveBloodPressureWaveValue;


    /**
     * CO2值 含两个参数及其波形数据 E7
     */
    @Column(name = "CO2Et")
    private Double CO2Et;
    @Column(name = "CO2Fi")
    private Double CO2Fi;
    @Column(name = "CO2WaveValue")
    private String CO2WaveValue;


    /**
     * O2值 含两个参数及其波形数据 E8
     */
    @Column(name = "O2Et")
    private Double O2Et;
    @Column(name = "O2Fi")
    private Double O2Fi;
    @Column(name = "O2WaveValue")
    private String O2WaveValue;


    /**
     * N2O值 含两个参数及其波形数据 E9
     */
    @Column(name = "N2OEt")
    private Double N2OEt;
    @Column(name = "N2OFi")
    private Double N2OFi;
    @Column(name = "N2OWaveValue")
    private String N2OWaveValue;


    /**
     * AA值 含两个参数及其波形数据 EA
     */
    @Column(name = "AAEt")
    private Double AAEt;
    @Column(name = "AAFi")
    private Double AAFi;
    @Column(name = "AAWaveValue")
    private String AAWaveValue;

    /**
     * ICG 参数及其波形
     */
    @Column(name = "icgCI")
    private Double icgCI;
    @Column(name = "icgCO")
    private Double icgCO;

    @Column(name = "icgHR")
    private Double icgHR;

    @Column(name = "icgSI")
    private Double icgSI;

    @Column(name = "icgSV")
    private Double icgSV;

    @Column(name = "icgSVR")
    private Double icgSVR;

    @Column(name = "icgSVRI")
    private Double icgSVRI;

    @Column(name = "icgTFC")
    private Double icgTFC;

    @Column(name = "icgTFI")
    private Double icgTFI;

    @Column(name = "icgWaveValue")
    private String icgWaveValue;

    /**
     * 自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 数据创建时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 数据修改时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "gmt_modified")
    private LocalDateTime gmtModified;

    /**
     * 序列号
     */
    @Column(name = "device_serial_number")
    private String serialNumber;

    /**
     * 手术顺序号
     */
    @NotNull(message = "operationNumber must cannot empty")
    @Column(name = "operation_number")
    private Integer operationNumber;
}
