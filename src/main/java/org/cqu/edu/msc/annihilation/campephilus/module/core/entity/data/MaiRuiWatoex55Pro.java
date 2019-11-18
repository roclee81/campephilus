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
 * 迈瑞WATOEX麻醉机数据实体类
 * @author msc206
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "data_MaiRuiWatoex55Pro")
public class MaiRuiWatoex55Pro implements Serializable {

    private static final long serialVersionUID = -614954426536118913L;

    @Column(name = "PMean")
    private Integer PMean;

    @Column(name = "PEEP")
    private Integer PEEP;

    @Column(name = "PPlat")
    private Integer PPlat;

    @Column(name = "PPeak")
    private Integer PPeak;

    @Column(name = "MV")
    private Double MV;

    @Column(name = "TVe")
    private Integer TVe;

    @Column(name = "IE")
    private Double IE;

    @Column(name = "Rate")
    private Integer Rate;

    @Column(name = "C")
    private Integer C;

    @Column(name = "R")
    private Integer R;

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
