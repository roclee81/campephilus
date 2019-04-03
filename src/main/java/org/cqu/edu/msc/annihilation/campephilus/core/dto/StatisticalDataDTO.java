package org.cqu.edu.msc.annihilation.campephilus.core.dto;

import lombok.Data;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/12 21:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class StatisticalDataDTO {

    /**
     * 手术次数的统计，总的数量
     */
    private Integer operationTotal;

    /**
     * 采集器上传数量统计，总的数量
     */
    private Long collectorUploadTotal;

    /**
     * 手术参与医院数量，总的数量
     */
    private Integer operationHospitalTotal;

    /**
     * 手术中使用到的仪器，总的数量
     * 通过仪器的SN统计
     */
    private Integer operationDeviceTotal;

    /**
     * 当天的手术次数的统计
     */
    private Integer operation;

    /**
     * 当天的采集器上传数量统计
     */
    private Integer collectorUpload;

    /**
     * 当天的手术参与医院数量
     */
    private Integer operationHospital;

    /**
     * 当天的手术中使用到的仪器
     * 通过仪器的SN统计
     */
    private Integer operationDevice;
}
