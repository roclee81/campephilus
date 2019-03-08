package org.cqu.edu.mrc.annihilation.campephilus.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
public class StatisticalDO {

    /**
     * mongo自动生成id
     */
    private String id;

    /**
     * 存放当天进行的手术案例的operationNumber
     * 只计算开始的时间，不计算结束的时间，也就是说只要在当天开始就记录，在第二天结束不记录
     */
    @Field(value = "operation_list")
    private List<Integer> operationList;

    /**
     * 采集器上传数据量
     */
    @Field(value = "collector_upload_number")
    private Integer collectorUploadNumber;

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
}
