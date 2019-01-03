package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:28
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "operation_device")
@Data
public class OperationDeviceDO {

    /**
     * Mongo自动生成
     */
    private String id;

    /**
     * 手术顺序号
     */
    @Field(value = "operation_number")
    private Integer operationNumber;

    /**
     * 数据采集器MAC地址
     */
    @Field(value = "collector_mac_address")
    private String collectorMacAddress;

    /**
     * 数据创建时间
     */
    @Field(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 数据修改时间
     */
    @Field(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 手术中使用的设备信息 标明设备的ID及设备型号
     */
    @Field(value = "device_information")
    private Map deviceInformation;

    public OperationDeviceDO() {
    }

    public OperationDeviceDO(Integer operationNumber, String collectorMacAddress, Date gmtCreate, Date gmtModified, Map deviceInformation) {
        this.operationNumber = operationNumber;
        this.collectorMacAddress = collectorMacAddress;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.deviceInformation = deviceInformation;
    }
}
