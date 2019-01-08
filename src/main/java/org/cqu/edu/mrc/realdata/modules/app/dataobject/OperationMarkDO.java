package org.cqu.edu.mrc.realdata.modules.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;
import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "operation_mark")
@Data
public class OperationMarkDO {

    /**
     * 编号 MongoDB自动生成
     */
    private String id;

    /**
     * 手术顺序号 手术的顺序号，唯一
     */
    @Field(value = "operation_number")
    private Integer operationNumber;

    /**
     * 手术标记序号 手术标记序号,递增,程序实现
     */
    @Field(value = "mark_number")
    private Integer markNumber;

    /**
     * 标记类型
     */
    @Field(value = "mark_type")
    private Integer markType;

    /**
     * 手术标记信息 手术标记信息
     */
    @Field(value = "mark_message")
    private Map markMessage;

    /**
     * 数据标记时间
     */
    @Field(value = "mark_time")
    private Date markTime;

    /**
     * 数据插入时间
     */
    @Field(value = "gmt_create")
    private Date gmtCreate;

    public OperationMarkDO(Integer operationNumber, Integer markNumber, Integer markType, Map markMessage, Date markTime, Date gmtCreate) {
        this.operationNumber = operationNumber;
        this.markNumber = markNumber;
        this.markType = markType;
        this.markMessage = markMessage;
        this.markTime = markTime;
        this.gmtCreate = gmtCreate;
    }
}
