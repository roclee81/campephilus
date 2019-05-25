package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 15:18
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_device_hospital_relation")
public class DeviceHospitalRelationInfo {

    /**
     * 标记id，自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 设备生产厂商编号
     */
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 设备序列号，不一定唯一
     */
    @Column(name = "device_serial_number")
    private String deviceSerialNumber;

    /**
     * 全国医院序列号，唯一
     */
    @Column(name = "hospital_id")
    private String hospitalId;

    /**
     * 设备购买时间 eg: 2017-08-01
     */
    @Column(name = "device_produce_date")
    private Time deviceProduceDate;

    /**
     * 购买地址
     */
    @Column(name = "device_purchase_address")
    private String devicePurchaseAddress;

    /**
     * 仪器的备注信息
     */
    @Column(name = "device_comment")
    private String deviceComment;

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
