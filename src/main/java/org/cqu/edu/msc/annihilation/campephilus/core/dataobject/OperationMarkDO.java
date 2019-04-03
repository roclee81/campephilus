package org.cqu.edu.msc.annihilation.campephilus.core.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "operation_mark")
@Data
public class OperationMarkDO extends CommonDO {

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
     * 数据状态
     * 如果处于false就不允许更改了
     */
    @Field(value = "data_state")
    private Boolean dataState;
}
