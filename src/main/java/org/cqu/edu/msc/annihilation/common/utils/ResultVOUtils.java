package org.cqu.edu.msc.annihilation.common.utils;

import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 10:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ResultVOUtils {

    private Integer code;

    private Object msg;

    private ResultVOUtils(Integer code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultVOUtils error(Integer code, Object msg) {
        return new ResultVOUtils(code, msg);
    }

    public static ResultVOUtils unknowError() {
        return new ResultVOUtils(ResponseEnum.UNKNOWN_ERROR.getCode(), ResponseEnum.UNKNOWN_ERROR.getMsg());
    }

    public static ResultVOUtils notFound() {
        return new ResultVOUtils(ResponseEnum.DATA_NOT_EXIST.getCode(), ResponseEnum.DATA_NOT_EXIST.getMsg());
    }

    public static ResultVOUtils success(Object msg) {
        return new ResultVOUtils(ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static ResultVOUtils isExisted(Object msg) {
        return new ResultVOUtils(ResponseEnum.DATA_EXISTED.getCode(), msg);
    }

    public static ResultVOUtils checkAndReturn(Object object) {
        return null == object ? notFound() : success(object);
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
