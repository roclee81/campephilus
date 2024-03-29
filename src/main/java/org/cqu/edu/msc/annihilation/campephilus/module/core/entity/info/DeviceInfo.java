package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.cqu.edu.msc.annihilation.common.converter.LocalDateTimeConverter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/2 20:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 医疗仪器的基础属性
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_device")
public class DeviceInfo implements Serializable {

    private static final long serialVersionUID = 233410313766289238L;
    /**
     * 自动增长ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 设备生产厂商
     */
    @NotBlank(message = "deviceCode must cannot empty")
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 设备序列号，不一定唯一
     */
    @NotBlank(message = "deviceSerialNumber must cannot empty")
    @Column(name = "device_serial_number")
    private String deviceSerialNumber;

    /**
     * 设备购买时间
     */
    @NotBlank(message = "deviceProduceDate must cannot empty")
    @Column(name = "device_produce_date")
    private LocalDate deviceProduceDate;

    /**
     * 仪器的使用年限
     */
    @NotNull(message = "deviceServiceLife must cannot empty")
    @Column(name = "device_service_life")
    private Float deviceServiceLife;

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
}
