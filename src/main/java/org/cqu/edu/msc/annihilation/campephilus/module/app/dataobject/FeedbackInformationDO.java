package org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    @Field(value = "message")
    private String message;
}
