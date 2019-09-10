package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/11 17:37
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class PearlcareYy106DataDTO implements Serializable {

    private static final long serialVersionUID = 62187762511544587L;

    /**
     * 序列号
     */
    private String serialNumber;

    /**
     * 手术顺序号
     */
    private Integer operationNumber;

    /**
     * AI
     */
    private Integer AI;

    /**
     * EMG
     */
    private Integer EMG;

    /**
     * SQI
     */
    private Integer SQI;

    /**
     * BSR
     */
    private Integer BSR;

    private Long longModified;

    private Long longCreate;
}
