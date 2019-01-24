package org.cqu.edu.mrc.realdata.modules.app.exception;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/24 23:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class SaveException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;
    private String errorData;

    public SaveException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public SaveException(int code, String msg, String errorData) {
        super(msg);
        this.msg = msg;
        this.code = code;
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
}
