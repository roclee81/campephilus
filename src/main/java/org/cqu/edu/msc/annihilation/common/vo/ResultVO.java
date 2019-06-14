package org.cqu.edu.msc.annihilation.common.vo;

import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/13 11:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ResultVO implements Serializable {

    private static final long serialVersionUID = -6307758086932966263L;

    private Integer code;

    private Object msg;

    public ResultVO(Integer code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
