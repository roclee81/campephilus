package org.cqu.edu.msc.annihilation.common.vo;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/13 11:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ResultVO {

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
