package org.cqu.edu.msc.annihilation.campephilus.core.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 14:22
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class FeedbackInformationDTO {

    /**
     * 反馈信息
     */
    private Map<String, Object> msg;

    /**
     * 反馈信息上传的时间
     */
    private Date gmtCreate;
}
