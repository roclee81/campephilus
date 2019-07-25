package org.cqu.edu.msc.annihilation.campephilus.module.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

import java.io.Serializable;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/25 0:53
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ParseException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;
    private String errorMsg;
    private String errorData;

    private ParseException(ResponseEnum responseEnum) {
        super();
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
    }

    private ParseException(ResponseEnum responseEnum, String errorMsg, String errorData) {
        super();
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
        this.errorMsg = errorMsg;
        this.errorData = errorData;
    }

    public static void dataFormatException(Exception e, Object errorData) {
        throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR, e.toString(), errorData.toString());
    }

    public static void dataFormatException(String errorData) {
        throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR, "ParseException", errorData);
    }

    public static void dataFormatException() {
        throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR);
    }

    public static void codeException() {
        throw new ParseException(ResponseEnum.CODE_ERROR);
    }

    public static void dataFormatException(String errorMsg, String errorData) {
        throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR, errorMsg, errorData);
    }
}
