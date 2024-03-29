package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.cqu.edu.msc.annihilation.common.converter.LocalDateTimeConverter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
public class DeviceHospitalRelationInfo implements Serializable {

    private static final long serialVersionUID = 4495024344464908326L;
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
    private LocalTime deviceProduceDate;

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
