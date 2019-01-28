package org.cqu.edu.mrc.annihilation.campephilus.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

/**
 * campephilus
 * 有创血红蛋白
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 14:10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "invasive_detection_hemoglobin")
@Data
public class InvasiveDetectionHemoglobinDO {

    /**
     * 编号，MongoDB自动生成
     */
    private String id;

    /**
     * 设备编号 用于确定是哪一台仪器
     */
    @Field(value = "device_id")
    private Integer deviceId;

    /**
     * 手术顺序号 用于唯一标记手术
     */
    @Field(value = "operation_number")
    private Integer operationNumber;

    /**
     * 手术有创数据的标记号，每场手术都会从0开始计数
     */
    @Field(value = "invasive_data_number")
    private Integer invasiveDataNumber;

    /**
     * 记录创建人Id
     */
    @Field(value = "creator_id")
    private Integer createId;

    /**
     * 数据上传时间
     */
    @Field(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 有创数据
     */
    @Field(value = "invasive_data")
    private Map invasiveData;

}
