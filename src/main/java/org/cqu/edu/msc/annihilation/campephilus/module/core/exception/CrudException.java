package org.cqu.edu.msc.annihilation.campephilus.module.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/7/25 23:01
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class CrudException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -1343312269172404301L;

    private String msg;
    private int code;
    private String errorMsg;
    private String errorData;

    private CrudException(ResponseEnum responseEnum) {
        super();
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
    }

    private CrudException(ResponseEnum responseEnum, String errorMsg, String errorData) {
        super();
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
        this.errorMsg = errorMsg;
        this.errorData = errorData;
    }

    public static void dataIsExist() {
        throw new CrudException(ResponseEnum.DATA_EXISTED);
    }

    public static void dataIsNotExisted() {
        throw new CrudException(ResponseEnum.DATA_NOT_EXIST);
    }
}
