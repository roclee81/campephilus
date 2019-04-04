package org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

/**
 * campephilus
 * 医疗仪器输出的数据，根据每台仪器的不同Id建表
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 15:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document
@Data
public class DeviceDO extends CommonDO {

    /**
     * 一起的SN码
     */
    @Field(value = "device_id")
    private String deviceId;

    /**
     * 仪器输出数据的顺序号，每场手术都会从0开始
     */
    @Field(value = "device_data_number")
    private Integer deviceDataNumber;

    /**
     * 仪器输出数据 仪器输出数据
     */
    @Field(value = "device_data")
    private Map deviceData;
}
