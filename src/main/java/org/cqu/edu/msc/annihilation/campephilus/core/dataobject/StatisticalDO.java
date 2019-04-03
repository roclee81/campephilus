package org.cqu.edu.msc.annihilation.campephilus.core.dataobject;

import lombok.Data;
import org.cqu.edu.msc.annihilation.common.utils.DateUtil;
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
public class StatisticalDO{

    /**
     * 编号 MongoDB自动生成
     */
    private String id;

    /**
     * 统计的时间
     * 需要进行格式化
     * 存储格式为2019-02-25
     */
    @Field(value = "date")
    private String date;

    /**
     * 当天总计请求数量，所有的请求
     */
    @Field(value = "request")
    private Integer request;

    /**
     * 当天总计有效请求数量，所有的请求
     */
    @Field(value = "valid_request")
    private Integer validRequest;

    /**
     * 每小时请求数量，所有的请求
     * 存储的格式按照perHourRequest[0]代表0~1点的统计
     * 一共索引为0~23
     * perHourRequestList[23]代表23~24点的统计值
     * 一个小时保存一次
     */
    @Field(value = "per_hour_request_list")
    private List<Integer> perHourRequestList;

    /**
     * 每小时有效请求数量，所有的请求
     * 存储的格式按照perHourValidRequest[0]代表0~1点的统计
     * 一共索引为0~23
     * perHourValidRequestList[23]代表23~24点的统计值
     * 一个小时保存一次
     */
    @Field(value = "per_hour_valid_request_list")
    private List<Integer> perHourValidRequestList;

    /**
     * 采集器上传数据量
     */
    @Field(value = "collector_upload")
    private Integer collectorUpload;

    /**
     * 采集器有效上传数据量
     */
    @Field(value = "collector_valid_upload")
    private Integer collectorValidUpload;

    /**
     * 采集器每小时上传数据量
     */
    @Field(value = "per_hour_collector_upload_list")
    private List<Integer> perHourCollectorUploadList;

    /**
     * 采集器每小时有效上传数据量
     */
    @Field(value = "per_hour_collector_valid_upload_list")
    private List<Integer> perHourCollectorValidUploadList;

    /**
     * 存放当天进行的手术案例的operationNumber
     * 只计算开始的时间，不计算结束的时间，也就是说只要在当天开始就记录，在第二天结束不记录
     */
    @Field(value = "operation_number_list")
    private List<Integer> operationNumberList;

    /**
     * 记录当天进行手术的医院，存储医院的代码
     */
    @Field(value = "hospital_code_list")
    private List<String> hospitalCodeList;

    /**
     * 存储当天参与手术的设备
     * 分为每一次手术进行保存
     * 存储设备的SN码
     * 每一次手术存储一个List
     * 格式
     * "statistical_operation_device" : [
     * [
     * {
     * "deviceType" : 1.0,
     * "serialNumber" : "SN123123",
     * "serviceLife" : 2.0
     * },
     * {
     * "deviceType" : 2.0,
     * "serialNumber" : "SN1231233",
     * "serviceLife" : 3.0
     * }
     * ]
     * ]
     */
    @Field(value = "device_list")
    private List<List<DeviceCommon>> deviceList;

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

    public static StatisticalDO getStatisticalDOInstance() {
        StatisticalDO statisticalDO = new StatisticalDO();
        statisticalDO.setDate(DateUtil.getCurrentDateString());
        statisticalDO.setRequest(0);
        statisticalDO.setValidRequest(0);
        statisticalDO.setGmtModified(new Date());
        statisticalDO.setGmtCreate(new Date());

        List<Integer> statisticalPerHourRequestUploadList = new ArrayList<>();
        statisticalDO.setPerHourRequestList(statisticalPerHourRequestUploadList);

        List<Integer> statisticalPerHourValidRequestUploadList = new ArrayList<>();
        statisticalDO.setPerHourValidRequestList(statisticalPerHourValidRequestUploadList);

        statisticalDO.setCollectorUpload(0);
        statisticalDO.setCollectorValidUpload(0);

        List<Integer> statisticalPerHourCollectorUploadList = new ArrayList<>();
        statisticalDO.setPerHourCollectorUploadList(statisticalPerHourCollectorUploadList);

        List<Integer> statisticalPerHourValidCollectorUploadList = new ArrayList<>();
        statisticalDO.setPerHourCollectorValidUploadList(statisticalPerHourValidCollectorUploadList);

        List<Integer> statisticalOperationNumberList = new ArrayList<>();
        statisticalDO.setOperationNumberList(statisticalOperationNumberList);

        List<String> statisticalOperationHospitalList = new ArrayList<>();
        statisticalDO.setHospitalCodeList(statisticalOperationHospitalList);

        List<List<DeviceCommon>> statisticalOperationDevice = new ArrayList<>();
        statisticalDO.setDeviceList(statisticalOperationDevice);

        return statisticalDO;
    }
}
