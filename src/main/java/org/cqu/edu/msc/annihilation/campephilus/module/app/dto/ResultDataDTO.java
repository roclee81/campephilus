package org.cqu.edu.msc.annihilation.campephilus.module.app.dto;

import lombok.Data;

import java.util.Map;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/30 11:50
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
