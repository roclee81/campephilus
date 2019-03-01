package org.cqu.edu.mrc.annihilation.campephilus.dataobject;

import lombok.Data;
import org.cqu.edu.mrc.annihilation.common.utils.DateUtil;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/25 21:20
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 用于统计Http请求的类
 */
@Data
@Document(value = "statistical_request")
public class StatisticalRequestDO {

    /**
     * id 自动生成
     */
    private String id;

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
     * perHourRequestNumber[23]代表23~24点的统计值
     * 一个小时保存一次
     */
    @Field(value = "per_hour_request_number")
    private List<Integer> perHourRequestNumber;

    /**
     * 每小时有效请求数量
     * 存储的格式按照perHourValidRequestNumber[0]代表0~1点的统计
     * 一共索引为0~23
     * perHourValidRequestNumber[23]代表23~24点的统计值
     * 一个小时保存一次
     */
    @Field(value = "per_valid_hour_request_number")
    private List<Integer> perHourValidRequestNumber;

    /**
     * 数据创建时间
     */
    @Field(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 数据修改时间
     */
    @Field(value = "gmt_modified")
    private Date gmtModified;

    public static StatisticalRequestDO getStatisticalUploadRequestDOInstance() {
        StatisticalRequestDO statisticalRequestDO = new StatisticalRequestDO();
        statisticalRequestDO.setStatisticalDate(DateUtil.getCurrentDateString());
        statisticalRequestDO.setTotalRequestNumber(0);
        statisticalRequestDO.setTotalValidRequestNumber(0);
        statisticalRequestDO.setGmtModified(new Date());
        statisticalRequestDO.setGmtCreate(new Date());
        List<Integer> perHourRequestNumber = new ArrayList<>();
        statisticalRequestDO.setPerHourRequestNumber(perHourRequestNumber);
        List<Integer> perHourValidRequestNumber = new ArrayList<>();
        statisticalRequestDO.setPerHourValidRequestNumber(perHourValidRequestNumber);
        return statisticalRequestDO;
    }
}
