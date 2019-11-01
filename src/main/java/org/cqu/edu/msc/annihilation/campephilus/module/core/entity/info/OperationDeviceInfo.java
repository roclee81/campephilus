package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.cqu.edu.msc.annihilation.common.converter.LocalDateTimeConverter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:00
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_operation_device")
public class OperationDeviceInfo implements Serializable {

    private static final long serialVersionUID = -7456701585085979233L;
    /**
     * 手术顺序号
     */
    @Id
    @Column(name = "pk_operation_number")
    private Integer operationNumber;

    @Column(name = "device_code0")
    private Integer deviceCode0;

    @Column(name = "device_serial_number0")
    private String deviceSerialNumber0;

    @Column(name = "device_code1")
    private Integer deviceCode1;

    @Column(name = "device_serial_number1")
    private String deviceSerialNumber1;

    @Column(name = "device_code2")
    private Integer deviceCode2;

    @Column(name = "device_serial_number2")
    private String deviceSerialNumber2;

    @Column(name = "device_code3")
    private Integer deviceCode3;

    @Column(name = "device_serial_number3")
    private String deviceSerialNumber3;

    @Column(name = "device_code4")
    private Integer deviceCode4;

    @Column(name = "device_serial_number4")
    private String deviceSerialNumber4;

    @Column(name = "device_code5")
    private Integer deviceCode5;

    @Column(name = "device_serial_number5")
    private String deviceSerialNumber5;

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
