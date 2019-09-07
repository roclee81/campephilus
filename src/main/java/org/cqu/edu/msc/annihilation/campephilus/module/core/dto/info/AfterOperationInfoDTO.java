package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 15:13
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class AfterOperationInfoDTO implements Serializable {

    private static final long serialVersionUID = -941673018902353283L;

    /**
     * 反馈信息
     */
    private String feedbackContent;

    /**
     * 住院号
     */
    private String admissionNumber;

    private Long longModified;

    private Long longCreate;
}
