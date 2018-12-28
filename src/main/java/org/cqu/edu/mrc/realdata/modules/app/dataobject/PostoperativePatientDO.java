package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;
import java.util.Map;

/**
 * realdata
 * 术后患者数据
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:37
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "postoperative_patient")
@Data
public class PostoperativePatientDO {

    /**
     * Mongo自动生成
     */
    private String id;

    /**
     * 病人ID
     */
    @Field(value = "patient_id")
    private Integer patientId;

    /**
     * 记录时间
     */
    @Field(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 数据修改时间
     */
    @Field(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 记录人编号
     */
    private Integer creatorId;

    /**
     * 存放基本数据信息 "msg": {
     *         "stage": "pre",
     *         "hospital code": "hospital code",
     *         "state": "state",
     *         "type": "type"
     *     },
     */
    private Integer meg;

    /**
     * 患者基本信息
     */
    private Map patientData;
}


