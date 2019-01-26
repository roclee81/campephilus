package org.cqu.edu.mrc.annihilation.campephilus.modules.app.dto;

import lombok.Data;

import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/25 15:39
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
    private String macAddress;

    /**
     * 手术顺序号
     */
    private Integer operationNumber;

    /**
     * 数据Map
     */
    private Map dataMap;

    public ParseDataDTO() {
    }

    public ParseDataDTO(Integer code, String macAddress, Integer operationNumber, Map dataMap) {
        this.code = code;
        this.macAddress = macAddress;
        this.operationNumber = operationNumber;
        this.dataMap = dataMap;
    }
}
