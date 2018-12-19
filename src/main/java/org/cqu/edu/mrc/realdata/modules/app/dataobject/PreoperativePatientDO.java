package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.Map;

/**
 * realdata
 *术前患者数据
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:41
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document
@Data
public class PreoperativePatientDO {

    /**
     * 病人ID
     */
    @Id
    private Integer patientId;

    /**
     * 数据采集器MAC地址
     */
    private String collectorMacAddress;

    /**
     * 手术顺序号 手术的顺序号，唯一
     */
    private Integer operationNumber;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人编号
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
    private Map meg;
    /**
     * 患者基本信息
     */
    private Map patientData;
}
