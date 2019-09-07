package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class OperationMarkInfoDTO implements Serializable {

    private static final long serialVersionUID = -4892589808381433198L;
    /**
     * 标记id，自动增长
     */
    private Integer id;

    /**
     * 标记大类型
     */
    private String markMainType;

    /**
     * 标记类型
     */
    private String markSubType;

    /**
     * 事件类型
     */
    private String markEvent;

    /**
     * 途径
     */
    private String giveMedicineMethod;

    /**
     * 剂量
     */
    private String giveMedicineVolume;

    /**
     * 不良反应/特殊情况
     */
    private String sideEffect;

    private Long longMarkTime;

    /**
     * 手术顺序号
     */
    private Integer operationNumber;

    private Long longModified;

    private Long longCreate;
}
