package org.cqu.edu.mrc.annihilation.campephilus.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/21 13:48
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document
@Data
public class CollectorInformationDO {

    /**
     * 编号 MongoDB自动生成
     */
    private String id;

    /**
     * 采集器的MAC地址
     */
    @Field(value = "collector_mac_address")
    private String collectorMacAddress;

    /**
     * 采集器的状态
     */
    @Field(value = "collector_state")
    private Integer collectorState;

    /**
     * 采集器参与的手术次数
     */
    @Field(value = "collector_operation_times")
    private Integer collectorOperationTimes;

    /**
     * 采集器发送数据次数
     */
    @Field(value = "collector_upload_data_times")
    private Long collectorUploadDataTimes;

    /**
     * 采集器最后上传数据时间
     */
    @Field(value = "gmt_collector_last_upload_data")
    private Date gmtCollectorLastUploadData;

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
