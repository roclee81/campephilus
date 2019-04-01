package org.cqu.edu.mrc.annihilation.campephilus.dto;

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
    private Integer operationStatistical;

    /**
     * 采集器上传数量统计，总的数量
     */
    private Long collectorUploadStatistical;

    /**
     * 手术参与医院数量，总的数量
     */
    private Integer operationHospitalStatistical;

    /**
     * 手术中使用到的仪器，总的数量
     * 通过仪器的SN统计
     */
    private Integer operationDeviceStatistical;

    /**
     * 当天的手术次数的统计
     */
    private Integer operationStatisticalDay;

    /**
     * 当天的采集器上传数量统计
     */
    private Integer collectorUploadStatisticalDay;

    /**
     * 当天的手术参与医院数量
     */
    private Integer operationHospitalStatisticalDay;

    /**
     * 当天的手术中使用到的仪器
     * 通过仪器的SN统计
     */
    private Integer operationDeviceStatisticalDay;
}
