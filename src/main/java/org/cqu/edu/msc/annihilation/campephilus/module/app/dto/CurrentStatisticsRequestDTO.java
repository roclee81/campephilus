package org.cqu.edu.msc.annihilation.campephilus.module.app.dto;

import lombok.Data;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/1 0:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 用于前端显示
 * 主要用于输出每秒的请求量以及平均信息
 */
@Data
public class CurrentStatisticsRequestDTO {

    /**
     * 当前每秒的请求量
     */
    private Integer currentSecondRequestNumber;

    /**
     * 当前每秒的有效请求量
     */
    private Integer currentSecondValidRequestNumber;

    /**
     * 当前小时的请求量
     */
    private Integer currentHourRequestNumber;

    /**
     * 当前小时的有效请求量
     */
    private Integer currentHourValidRequestNumber;

    /**
     * 当天的请求量
     */
    private Integer currentDayRequestNumber;

    /**
     * 当天的有效请求量
     */
    private Integer currentDayValidRequestNumber;

    /**
     * 平均每小时请求量
     */
    private Integer averageHourRequestNumber;

    /**
     * 平均每小时有效请求量
     */
    private Integer averageHourValidRequestNumber;
}

