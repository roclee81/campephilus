package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

/**
 * realdata
 * 术前患者数据
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:41
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "preoperative_patient")
@Data
public class PreoperativePatientDO {

    /**
     * Mongo自动生成的ID
     */
    private String id;

    /**
     * 病人ID
     */
    @Field(value = "patient_id")
    private String patientId;

    /**
     * 数据采集器MAC地址
     */
    @Field(value = "collector_mac_address")
    private String collectorMacAddress;

    /**
     * 手术顺序号 手术的顺序号，唯一
     */
    @Field(value = "operation_number")
    private Integer operationNumber;

    /**
     * 更新时间
     */
    @Field(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改数据时间
     */
    @Field(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建人编号
     */
    @Field(value = "creator_id")
    private Integer creatorId;

    /**
     * 存放基本数据信息 "msg": {
     * "stage": "pre",
     * "hospital code": "hospital code",
     * "state": "state",
     * "type": "type"
     * },
     * 用于评分等环节，目前未使用
     */
    @Field(value = "msg")
    private Map msg;

    /**
     * 患者基本信息
     */
    @Field(value = "patient_data")
    private Map patientData;

    public PreoperativePatientDO(String patientId, String collectorMacAddress, Integer operationNumber, Date gmtCreate, Integer creatorId, Map msg, Map patientData) {
        this.patientId = patientId;
        this.collectorMacAddress = collectorMacAddress;
        this.operationNumber = operationNumber;
        this.gmtCreate = gmtCreate;
        this.creatorId = creatorId;
        this.msg = msg;
        this.patientData = patientData;
    }
}
