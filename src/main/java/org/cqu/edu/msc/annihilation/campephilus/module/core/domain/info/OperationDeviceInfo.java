package org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:00
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_operation_device")
public class OperationDeviceInfo extends BaseInfoSuperclass implements Serializable {

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
}
