package org.cqu.edu.msc.annihilation.campephilus.common.exception;

import org.cqu.edu.msc.annihilation.campephilus.common.enums.ResponseEnum;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/25 0:53
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ParseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;
    private String errorMsg;
    private String errorData;

    public ParseException(ResponseEnum responseEnum) {
        super();
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
    }

    public ParseException(ResponseEnum responseEnum, String errorMsg, String errorData) {
        super();
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
        this.errorMsg = errorMsg;
        this.errorData = errorData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorData() {
        return errorData;
    }

    public void setErrorData(String errorData) {
        this.errorData = errorData;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
