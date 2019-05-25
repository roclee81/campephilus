package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

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
public class DeviceInfo {

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
    // TODO 等待转换成Date形式进行优化
    @NotBlank(message = "deviceProduceDate must cannot empty")
    @Column(name = "device_produce_date")
    private Time deviceProduceDate;

    /**
     * 仪器的使用年限
     */
    @NotNull(message = "deviceServiceLife must cannot empty")
    @Column(name = "device_service_life")
    private Float deviceServiceLife;

    /**
     * 数据创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 数据修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;
}
