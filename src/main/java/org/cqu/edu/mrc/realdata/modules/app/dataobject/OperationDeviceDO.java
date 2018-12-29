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
     * 进行手术的所在医院代码 采用国家医院代码,这个需要手术标记人员手动输入
     */
    @Field(value = "operation_hospital_code")
    private String operationHospitalCode;

    /**
     * 手术开始时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Field(value = "operation_start_time")
    private Date operationStartTime;

    /**
     * 手术结束时间
     */
    @Field(value = "operation_end_time")
    private Date operationEndTime;

    /**
     * 手术进行的时间
     */
    @Field(value = "operation_time")
    private Date operationTime;

    /**
     * 数据上传时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    public OperationDeviceDO(Integer operationNumber, String collectorMacAddress, String operationHospitalCode, Date operationStartTime, Date operationEndTime, Date operationTime, Date gmtCreate, Date gmtModified, Map deviceInformation) {
        this.operationNumber = operationNumber;
        this.collectorMacAddress = collectorMacAddress;
        this.operationHospitalCode = operationHospitalCode;
        this.operationStartTime = operationStartTime;
        this.operationEndTime = operationEndTime;
        this.operationTime = operationTime;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.deviceInformation = deviceInformation;
    }
}
