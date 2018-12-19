package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:28
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document
@Data
public class OperationDeviceDO {

    /**
     * 手术顺序号
     */
    @Id
    private Integer operationNumber;

    /**
     * 数据采集器MAC地址
     */
    private String collectorMacAddress;

    /**
     * 进行手术的所在医院代码 采用国家医院代码,这个需要手术标记人员手动输入
     */
    private Integer operationHospitalCode;

    /**
     * 手术开始时间
     */
    private Date operationStartTime;

    /**
     * 手术结束时间
     */
    private Date operationEndTime;

    /**
     * 手术进行的时间
     */
    private Date operationTime;

    /**
     * 手术中使用的设备信息 标明设备的ID及设备型号
     */
    private Map deviceInformation;


}
