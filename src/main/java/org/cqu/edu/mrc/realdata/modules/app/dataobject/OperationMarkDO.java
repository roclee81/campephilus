package org.cqu.edu.mrc.realdata.modules.app.dataobject;

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
 * @date 2018/12/19 20:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document
@Data
public class OperationMarkDO {

    /**
     * 编号 MongoDB自动生成
     */
    private String id;

    /**
     * 手术顺序号 手术的顺序号，唯一
     */
    private Integer operationNumber;

    /**
     * 手术标记序号 手术标记序号,递增,程序实现
     */
    private Integer markNumber;

    /**
     * 标记类型
     */
    private Integer markType;

    /**
     * 手术标记信息 手术标记信息
     */
    private Map markMessage;

    /**
     * 数据标记时间
     */
    private Date markTime;

    public OperationMarkDO(Integer operationNumber, Integer markNumber, Integer markType, Map markMessage, Date markTime) {
        this.operationNumber = operationNumber;
        this.markNumber = markNumber;
        this.markType = markType;
        this.markMessage = markMessage;
        this.markTime = markTime;
    }
}
