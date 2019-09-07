package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 22:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class OperationInfoDTO implements Serializable {

    private static final long serialVersionUID = -5085503116296589504L;
    /**
     * 手术顺序号
     */
    private Integer operationNumber;

    /**
     * 手术名称
     */
    private String operationName;

    private Long longOperationStartTime;

    private Long longOperationEndTime;

    /**
     * 手术状态
     */
    private Integer operationState;

    /**
     * 全国医院序列号，唯一
     */
    private String hospitalCode;

    /**
     * 医院的手术顺序号
     * 每个医院的都不一样
     */
    private String hospitalOperationNumber;

    private Long longModified;

    private Long longCreate;
}

