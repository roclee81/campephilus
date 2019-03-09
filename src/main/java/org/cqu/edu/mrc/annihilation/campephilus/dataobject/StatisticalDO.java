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
 * @date 2019/3/8 16:19
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 用于记录每天的数据
 * 每天执行手术案例、采集器上传数据量、参与医院、参与仪器
 */
@Document(value = "statistical")
@Data
public class StatisticalDO extends CommonDO {

    /**
     * 统计的时间
     * 需要进行格式化
     * 存储格式为2019-02-25
     */
    @Field(value = "statistical_date")
    private String statisticalDate;

    /**
     * 当天总计请求数量，所有的请求
     */
    @Field(value = "total_request_number")
    private Integer totalRequestNumber;

    /**
     * 当天总计有效请求数量，所有的请求
     */
    @Field(value = "total_valid_request_number")
    private Integer totalValidRequestNumber;

    /**
     * 每小时请求数量，所有的请求
     * 存储的格式按照perHourRequestNumber[0]代表0~1点的统计
     * 一共索引为0~23
     * perHourRequestNumber[23]代表23~24点的统计值
     * 一个小时保存一次
     */
    @Field(value = "per_hour_request_number")
    private List<Integer> perHourRequestNumber;

    /**
     * 每小时有效请求数量，所有的请求
     * 存储的格式按照perHourValidRequestNumber[0]代表0~1点的统计
     * 一共索引为0~23
     * perHourValidRequestNumber[23]代表23~24点的统计值
     * 一个小时保存一次
     */
    @Field(value = "per_hour_valid_request_number")
    private List<Integer> perHourValidRequestNumber;

    /**
     * 存放当天进行的手术案例的operationNumber
     * 只计算开始的时间，不计算结束的时间，也就是说只要在当天开始就记录，在第二天结束不记录
     */
    @Field(value = "operation_list")
    private List<Integer> operationList;

    /**
     * 采集器每小时上传数据量
     */
    @Field(value = "collector_per_hour_request_number")
    private List<Integer> collectorPerHourRequestNumber;

    /**
     * 采集器每小时有效上传数据量
     */
    @Field(value = "collector_per_hour_valid_request_number")
    private List<Integer> collectorPerHourValidRequestNumber;

    /**
     * 采集器上传数据量
     */
    @Field(value = "collector_request_number")
    private Integer collectorRequestNumber;

    /**
     * 采集器有效上传数据量
     */
    @Field(value = "collector_valid_request_number")
    private Integer collectorValidRequestNumber;

    /**
     * 记录当天进行手术的医院，存储医院的代码
     */
    @Field(value = "operation_hospital")
    private List<Integer> operationHospital;

    /**
     * 存储当天参与手术的设备
     * 存储设备的SN码
     */
    @Field(value = "operation_device")
    private List<String> operationDevice;

    public static StatisticalDO getStatisticalDOInstance() {
        StatisticalDO statisticalDO = new StatisticalDO();
        statisticalDO.setStatisticalDate(DateUtil.getCurrentDateString());
        statisticalDO.setTotalRequestNumber(0);
        statisticalDO.setTotalValidRequestNumber(0);
        statisticalDO.setGmtModified(new Date());
        statisticalDO.setGmtCreate(new Date());

        List<Integer> perHourRequestNumberList = new ArrayList<>();
        statisticalDO.setPerHourRequestNumber(perHourRequestNumberList);

        List<Integer> perHourValidRequestNumberList = new ArrayList<>();
        statisticalDO.setPerHourValidRequestNumber(perHourValidRequestNumberList);

        List<Integer> operationList = new ArrayList<>();
        statisticalDO.setOperationList(operationList);

        statisticalDO.setCollectorRequestNumber(0);

        statisticalDO.setCollectorValidRequestNumber(0);

        List<Integer> operationHospitalList = new ArrayList<>();
        statisticalDO.setOperationHospital(operationHospitalList);

        List<String> operationDeviceList = new ArrayList<>();
        statisticalDO.setOperationDevice(operationDeviceList);

        List<Integer> collectorPerHourRequestNumberList = new ArrayList<>();
        statisticalDO.setCollectorPerHourRequestNumber(collectorPerHourRequestNumberList);

        List<Integer> collectorPerHourValidRequestNumberList = new ArrayList<>();
        statisticalDO.setCollectorPerHourValidRequestNumber(collectorPerHourValidRequestNumberList);

        return statisticalDO;
    }
}
