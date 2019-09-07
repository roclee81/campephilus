package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

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
@Data
public class OperationDeviceInfoDTO implements Serializable {

    private static final long serialVersionUID = -7456701585085979233L;
    /**
     * 手术顺序号
     */
    private Integer operationNumber;

    private Integer deviceCode0;

    private String deviceSerialNumber0;

    private Integer deviceCode1;

    private String deviceSerialNumber1;

    private Integer deviceCode2;

    private String deviceSerialNumber2;

    private Integer deviceCode3;

    private String deviceSerialNumber3;

    private Integer deviceCode4;

    private String deviceSerialNumber4;

    private Integer deviceCode5;

    private String deviceSerialNumber5;

    private Long longModified;

    private Long longCreate;
}
