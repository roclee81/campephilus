package org.cqu.edu.msc.annihilation.campephilus.module.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.common.enums.ErrorEnum;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

import java.io.Serializable;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/24 23:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public class SaveException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;
    private String errorMeg;
    private String errorData;

    public SaveException(ResponseEnum responseEnum, String errorMeg, String errorData) {
        super();
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
        this.errorMeg = errorMeg;
        this.errorData = errorData;
    }

    public SaveException(ErrorEnum errorEnum, String errorMeg, String errorData) {
        super();
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
        this.errorMeg = errorMeg;
        this.errorData = errorData;
    }

    public SaveException(ResponseEnum responseEnum) {
        super();
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }
}
