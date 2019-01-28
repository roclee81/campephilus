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
public class DeviceDO {

    /**
     * 编号 MongoDB自动生成
     */
    private String id;

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
     * 数据插入时间
     */
    @Field(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 仪器输出数据 仪器输出数据
     */
    @Field(value = "device_data")
    private Map deviceData;

    public DeviceDO() {
    }

    public DeviceDO(Integer operationNumber, Integer deviceDataNumber, Date gmtCreate, Map deviceData) {
        this.operationNumber = operationNumber;
        this.deviceDataNumber = deviceDataNumber;
        this.gmtCreate = gmtCreate;
        this.deviceData = deviceData;
    }

}
