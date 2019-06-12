package org.cqu.edu.msc.annihilation.common.vo;

import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 10:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ResultVO implements Serializable {

    private static final long serialVersionUID = -3317912514177592875L;

    private Integer code;

    private Object msg;

    private ResultVO(Integer code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultVO error(Integer code, Object msg) {
        return new ResultVO(code, msg);
    }

    public static ResultVO unknowError() {
        return new ResultVO(ResponseEnum.UNKNOWN_ERROR.getCode(), ResponseEnum.UNKNOWN_ERROR.getMsg());
    }

    public static ResultVO notFound() {
        return new ResultVO(ResponseEnum.DATA_NOT_EXIST.getCode(), ResponseEnum.DATA_NOT_EXIST.getMsg());
    }

    public static ResultVO success(Object msg) {
        return new ResultVO(ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static ResultVO isExisted(Object msg) {
        return new ResultVO(ResponseEnum.DATA_EXISTED.getCode(), msg);
    }

    public static ResultVO checkAndReturn(Object object) {
        return null == object ? notFound() : success(object);
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg=" + msg +
                '}';
    }


}
