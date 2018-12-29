package org.cqu.edu.mrc.realdata.modules.app.dto;

import lombok.Data;

import java.util.Map;

/**
 * realdata
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
    private Map msg;

    public ResultDataDTO() {
    }

    public ResultDataDTO(Integer code, Map msg) {
        this.code = code;
        this.msg = msg;
    }
}
