package org.cqu.edu.mrc.annihilation.campephilus.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 22:27
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class PatientInformationDTO {
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
