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
 * 理邦 ELite V8监护仪数据实体
 * @author cz
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "data_LiBangEliteV8")
public class LiBangEliteV8 implements Serializable {

    private static final long serialVersionUID = 1217602298523007590L;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @Column(name = "HR")
    private Integer HR;

    @Column(name = "PVCs")
    private Integer PVCs;

    @Column(name = "RR")
    private Integer RR;

    @Column(name = "SpO2")
    private Integer SpO2;

    @Column(name = "PR")
    private Integer PR;

    @Column(name = "T1")
    private Double T1;

    @Column(name = "T2")
    private Double T2;

    @Column(name = "CVP_MAP")
    private Integer CVP_MAP;

    @Column(name = "Art_SYS")
    private Integer Art_SYS;

    @Column(name = "Art_DIA")
    private Integer Art_DIA;

    @Column(name = "Art_MAP")
    private Integer Art_MAP;

    @Column(name = "P2_SYS")
    private Integer P2_SYS;

    @Column(name = "P2_DIA")
    private Integer P2_DIA;

    @Column(name = "P2_MAP")
    private Integer P2_MAP;

    @Column(name = "LAP_MAP")
    private Integer LAP_MAP;

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
