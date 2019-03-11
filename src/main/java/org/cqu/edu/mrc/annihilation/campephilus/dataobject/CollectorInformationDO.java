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
@Document(value = "collector_information")
@Data
public class CollectorInformationDO extends CommonDO {

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

    public static CollectorInformationDO getCollectorInformationDOInstance() {
        CollectorInformationDO collectorInformationDO = new CollectorInformationDO();
        collectorInformationDO.setGmtCreate(new Date());
        collectorInformationDO.setGmtCreate(new Date());
        collectorInformationDO.setCollectorUploadDataTimes(1L);
        collectorInformationDO.setCollectorOperationTimes(1);
        return collectorInformationDO;
    }
}
