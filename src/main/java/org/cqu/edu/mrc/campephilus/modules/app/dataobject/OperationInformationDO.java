package org.cqu.edu.mrc.campephilus.modules.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 22:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "operation_information")
@Data
public class OperationInformationDO {

    /**
     * Mongo自动生成,唯一
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
     * 病人Id
     */
    @Field(value = "patient_id")
    private String patientId;

    /**
     * 进行手术的所在医院代码 采用国家医院代码,这个需要手术标记人员手动输入
     */
    @Field(value = "operation_hospital_code")
    private String operationHospitalCode;

    /**
     * 手术中使用的设备信息 标明设备的ID及设备型号
     */
    @Field(value = "device_information")
    private List<String> deviceInformation;

    /**
     * 手术开始时间
     */
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
    private Long operationTime;

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

    public OperationInformationDO() {
    }

    public OperationInformationDO(Integer operationNumber, String collectorMacAddress, String patientId, String operationHospitalCode, List<String> deviceInformation, Date operationStartTime, Date operationEndTime, Long operationTime, Date gmtCreate, Date gmtModified) {
        this.operationNumber = operationNumber;
        this.collectorMacAddress = collectorMacAddress;
        this.patientId = patientId;
        this.operationHospitalCode = operationHospitalCode;
        this.deviceInformation = deviceInformation;
        this.operationStartTime = operationStartTime;
        this.operationEndTime = operationEndTime;
        this.operationTime = operationTime;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }
}
