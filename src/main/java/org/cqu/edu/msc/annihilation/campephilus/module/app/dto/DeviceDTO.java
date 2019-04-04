package org.cqu.edu.msc.annihilation.campephilus.module.app.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 14:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class DeviceDTO {

    private Integer operationNumber;

    /**
     * 仪器输出数据的顺序号，每场手术都会从0开始
     */
    private Integer deviceDataNumber;

    /**
     * 更新时间 数据更新时间
     */
    private Date gmtCreate;

    /**
     * 仪器输出数据 仪器输出数据
     */
    private Map deviceData;
}
