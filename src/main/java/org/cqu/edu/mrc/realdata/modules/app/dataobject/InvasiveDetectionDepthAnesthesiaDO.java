package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.Map;

/**
 * realdata
 * 有创麻醉深度
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 14:10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document
@Data
public class InvasiveDetectionDepthAnesthesiaDO {

    /**
     * 编号，MongoDB自动生成
     */
    private String id;

    /**
     * 设备编号 用于确定是哪一台仪器
     */
    private Integer deviceId;

    /**
     * 手术顺序号 用于唯一标记手术
     */
    private Integer operationNumber;

    /**
     * 手术有创数据的标记号，每场手术都会从0开始计数
     */
    private Integer invasiveDataNumber;

    /**
     * 记录创建人Id
     */
    private Integer createId;

    /**
     * 数据上传数据
     */
    private Date updateTime;

    /**
     * 有创数据
     */
    private Map invasiveData;

}
