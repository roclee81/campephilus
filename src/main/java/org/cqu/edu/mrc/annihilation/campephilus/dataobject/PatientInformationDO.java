package org.cqu.edu.mrc.annihilation.campephilus.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 21:47
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "patient_information")
@Data
public class PatientInformationDO extends CommonDO {

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
     * 创建人编号
     */
    @Field(value = "creator_id")
    private Integer creatorId;

    /**
     * 存放基本数据信息 "data": {
     * "stage": "pre",
     * "hospital code": "hospital code",
     * "state": "state",
     * "type": "type"
     * },
     * 用于评分等环节，目前未使用
     */
    @Field(value = "preoperative_Data")
    private Map preoperativeData;

    /**
     * 存放基本数据信息 "data": {
     * "stage": "pre",
     * "hospital code": "hospital code",
     * "state": "state",
     * "type": "type"
     * },
     * 用于评分等环节，目前未使用
     */
    @Field(value = "postoperative_Data")
    private Map postoperativeData;

    /**
     * 患者基本信息
     */
    @Field(value = "patient_data")
    private Map patientData;

    /**
     * 数据状态
     * 如果处于false就不允许更改了
     */
    @Field(value = "data_state")
    private Boolean dataState;
}
