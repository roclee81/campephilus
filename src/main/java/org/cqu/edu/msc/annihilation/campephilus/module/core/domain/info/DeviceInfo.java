package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/2 20:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 医疗仪器的基础属性
 */
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_device")
public class DeviceInfo extends BaseInfoSuperclass implements Serializable {

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
}
