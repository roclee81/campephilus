package org.cqu.edu.mrc.annihilation.campephilus.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
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
     * 手术的顺序号，唯一
     */
    @Field(value = "operation_number")
    private Integer operationNumber;

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

    public DeviceDO() {
    }

    public DeviceDO(Integer operationNumber, Integer deviceDataNumber, Map deviceData, Date gmtCreate) {
        super.setGmtCreate(gmtCreate);
        this.operationNumber = operationNumber;
        this.deviceDataNumber = deviceDataNumber;
        this.deviceData = deviceData;
    }

}
