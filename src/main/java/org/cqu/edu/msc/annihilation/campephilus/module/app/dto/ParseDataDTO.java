package org.cqu.edu.msc.annihilation.campephilus.module.app.dto;

import lombok.Data;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/30 11:50
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class ParseDataDTO {

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

    public ParseDataDTO() {
    }

    public ParseDataDTO(Integer code, String collectorMacAddress, Integer operationNumber, String jsonData) {
        this.code = code;
        this.collectorMacAddress = collectorMacAddress;
        this.operationNumber = operationNumber;
        this.jsonData = jsonData;
    }
}
