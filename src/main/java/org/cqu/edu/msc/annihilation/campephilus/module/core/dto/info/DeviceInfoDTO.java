package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

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
@Data
public class DeviceInfoDTO implements Serializable {

    private static final long serialVersionUID = 233410313766289238L;

    /**
     * 设备生产厂商
     */
    private String deviceCode;

    /**
     * 设备序列号，不一定唯一
     */
    private String deviceSerialNumber;

    /**
     * 设备购买时间
     */
    private LocalDate deviceProduceDate;

    /**
     * 仪器的使用年限
     */
    private Float deviceServiceLife;

    private Long longModified;

    private Long longCreate;
}
