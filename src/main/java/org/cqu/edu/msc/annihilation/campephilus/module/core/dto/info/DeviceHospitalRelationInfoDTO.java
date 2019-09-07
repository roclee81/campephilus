package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 15:18
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class DeviceHospitalRelationInfoDTO implements Serializable {

    private static final long serialVersionUID = 4495024344464908326L;
    /**
     * 标记id，自动增长
     */
    private Integer id;

    /**
     * 设备生产厂商编号
     */
    private String deviceCode;

    /**
     * 设备序列号，不一定唯一
     */
    private String deviceSerialNumber;

    /**
     * 全国医院序列号，唯一
     */
    private String hospitalId;

    /**
     * 设备购买时间 eg: 2017-08-01
     */
    private LocalTime deviceProduceDate;

    /**
     * 购买地址
     */
    private String devicePurchaseAddress;

    /**
     * 仪器的备注信息
     */
    private String deviceComment;

    private Long longModified;

    private Long longCreate;
}
