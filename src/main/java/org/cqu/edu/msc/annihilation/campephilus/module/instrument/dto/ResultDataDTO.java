package org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto;

import lombok.Data;
import org.cqu.edu.msc.annihilation.common.constant.DataConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/29 11:06
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class ResultDataDTO {
    /**
     * 数据传输操作码
     */
    private Integer code;

    /**
     * 包含信息的Msg
     */
    private Map<String, Object> msg;

    private ResultDataDTO(Integer code, Map<String, Object> msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultDataDTO convert(Integer code, Object mac, Object operationNumber) {
        Map<String, Object> map = new HashMap<>(4);
        map.put(DataConstants.MAC, mac);
        map.put(DataConstants.OPERATION_NUMBER, operationNumber);
        return new ResultDataDTO(code, map);
    }

}
