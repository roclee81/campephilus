package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document
@Data
public class PostoperativePatientDO {

    /**
     * 病人ID
     */
    @Id
    private Integer patientId;

    /**
     * 记录时间
     */
    private Date updateTime;

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


