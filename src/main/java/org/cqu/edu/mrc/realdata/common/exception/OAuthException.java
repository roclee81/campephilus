package org.cqu.edu.mrc.realdata.common.exception;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 */
public class OAuthException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public OAuthException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public OAuthException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public OAuthException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public OAuthException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
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
}
