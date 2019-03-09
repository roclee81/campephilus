package org.cqu.edu.mrc.annihilation.campephilus.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 12:34
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Document(value = "feedback_information")
@Data
public class FeedbackInformationDO extends CommonDO{
    /**
     * 反馈信息
     */
    @Field(value = "msg")
    private Map<String, Object> msg;
}
