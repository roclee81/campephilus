package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.Map;

/**
 * realdata
 * 医疗仪器输出的数据，根据每台仪器的不同Id建表
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 15:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document
@Data
public class DeviceDO {

    /**
     * 编号 MongoDB自动生成
     */
    private String id;

    /**
     * 手术的顺序号，唯一
     */
    private Integer operationNumber;

    /**
     * 仪器输出数据的顺序号，每场手术都会从0开始
     */
    private Integer deviceDataNumber;

    /**
     * 更新时间 数据更新时间
     */
    private Date updateTime;

    /**
     * 仪器输出数据 仪器输出数据
     */
    private Map deviceData;

}
