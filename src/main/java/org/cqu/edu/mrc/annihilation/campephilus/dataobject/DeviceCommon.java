package org.cqu.edu.mrc.annihilation.campephilus.dataobject;

import lombok.Data;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/2 20:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 医疗仪器的基础属性
 */
@Data
public class DeviceCommon {

    /**
     * 仪器的类型
     * 血氧、脑氧等
     */
    private Integer deviceType;

    /**
     * 仪器的SN码
     */
    private String serialNumber;

    /**
     * 仪器的使用年限
     */
    private Integer serviceLife;
}
