package org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info;

import lombok.Data;

/**
 * 评价表单
 *
 * @author cz
 */
@Data
public class EvaluationInfo {

    /**
     *
     */
    private Integer operationNumber;

    /**
     * 仪器代号
     */
    private String deviceCode;

    /**
     * 仪器序列号
     */
    private String serialNumber;

    /**
     * 使用科室
     */
    private String deviceDepartment;

    /**
     * 使用评价等级
     */
    private String experienceLevel;

    /**
     * 可靠性等级
     */
    private String reliabilityLevel;

    /**
     * 是否有错误信息
     */
    private String hasError;

    /**
     * 错误原因
     */
    private String knownError;

    /**
     * 其他错误
     */
    private String otherError;

    /**
     * 备注
     */
    private String remark;

    /**
     * 记录人签名
     */
    private String recordName;
}
