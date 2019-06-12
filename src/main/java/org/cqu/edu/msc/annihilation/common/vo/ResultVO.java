package org.cqu.edu.msc.annihilation.common.vo;

import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 10:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ResultVO {

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
