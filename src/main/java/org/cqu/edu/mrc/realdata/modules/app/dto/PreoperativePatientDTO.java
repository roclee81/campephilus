package org.cqu.edu.mrc.realdata.modules.app.dto;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 16:50
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class PreoperativePatientDTO {

    /**
     * 病人ID
     */
    private String patientId;

    /**
     * 手术顺序号 手术的顺序号，唯一
     */
    private Integer operationNumber;

    /**
     * 更新时间
     */
    private Date gmtCreate;

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
    private Map data;

    /**
     * 患者基本信息
     */
    private Map patientData;
}
