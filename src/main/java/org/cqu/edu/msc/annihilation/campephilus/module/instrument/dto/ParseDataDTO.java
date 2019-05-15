package org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/25 15:39
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParseDataDTO implements Serializable {

    private static final long serialVersionUID = 8299220035788542152L;

    /**
     * 数据传输操作码
     */
    private Integer code;

    /**
     * mac地址
     */
    private String collectorMacAddress;

    /**
     * 手术顺序号
     */
    private Integer operationNumber;

    /**
     * 数据jsonData
     */
    private String jsonData;
}
