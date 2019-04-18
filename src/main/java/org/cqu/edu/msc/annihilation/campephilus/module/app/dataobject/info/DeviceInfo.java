package org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/2 20:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 医疗仪器的基础属性
 */
@DynamicUpdate
@Entity
@Data
@Table(schema = "info_device")
public class DeviceInfo {

    /**
     * 自动增长ID
     */
    @Id
    @GeneratedValue
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 设备生产厂商
     */
    @Column(name = "device_producer")
    private String deviceProducer;

    /**
     * 设备序列号，不一定唯一
     */
    @Column(name = "device_serial_number")
    private String deviceSerialNumber;

    /**
     * 设备购买时间
     */
    @Column(name = "device_produce_date")
    private Date deviceProduceDate;

    /**
     * 仪器的使用年限
     */
    @Column(name = "device_service_life")
    private Integer deviceServiceLife;

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
