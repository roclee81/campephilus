package org.cqu.edu.mrc.realdata.modules.app.dto;

import lombok.Data;

import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/24 16:33
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class MedicalDataDTO {

    /**
     * 数据传输操作码
     */
    private Integer code;

    /**
     * 数据Map
     */
    private Map msg;
}
