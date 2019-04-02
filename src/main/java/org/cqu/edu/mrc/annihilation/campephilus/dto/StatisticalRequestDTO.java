package org.cqu.edu.mrc.annihilation.campephilus.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/26 10:26
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class StatisticalRequestDTO {

    /**
     * 统计的时间
     * 需要进行格式化
     * 存储格式为2019-02-25
     */
    @Field(value = "statistical_date")
    private String statisticalDate;

    /**
     * 总计请求数量
     */
    @Field(value = "total_request_number")
    private Integer totalRequestNumber;

    /**
     * 总计有效请求数量
     */
    @Field(value = "total_valid_request_number")
    private Integer totalValidRequestNumber;

    /**
     * 每小时请求数量
     * 存储的格式按照perHourRequestNumber[0]代表0~1点的统计
     * 一共索引为0~23
     * perHourCollectorUploadStatistical[23]代表23~24点的统计值
     */
    @Field(value = "per_hour_request_number")
    private List<Integer> perHourRequestNumber;

    /**
     * 每小时有效请求数量
     * 存储的格式按照perHourRequestNumber[0]代表0~1点的统计
     * 一共索引为0~23
     * perHourCollectorUploadStatistical[23]代表23~24点的统计值
     */
    @Field(value = "per_valid_hour_request_number")
    private List<Integer> perHourValidRequestNumber;
}
