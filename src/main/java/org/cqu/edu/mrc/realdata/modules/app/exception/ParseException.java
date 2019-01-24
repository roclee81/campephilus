package org.cqu.edu.mrc.realdata.modules.app.exception;

/**
 * realdata
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
    private String errorMeg;
    private String errorData;

    public ParseException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public ParseException(int code, String msg, String errorData) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.errorData = errorData;
    }

    public ParseException(int code, String msg, String errorMeg, String errorData) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.errorMeg = errorMeg;
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

    public String getErrorMeg() {
        return errorMeg;
    }

    public void setErrorMeg(String errorMeg) {
        this.errorMeg = errorMeg;
    }
}
