package org.cqu.edu.mrc.realdata.modules.app.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 14:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class DeviceDTO {

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