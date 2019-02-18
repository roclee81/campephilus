package org.cqu.edu.mrc.annihilation.campephilus.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 16:29
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class OperationMarkDTO {
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

    /**
     * 数据插入时间
     */
    private Date gmtCreate;
}
