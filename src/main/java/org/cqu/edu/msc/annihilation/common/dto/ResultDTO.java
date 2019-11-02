package org.cqu.edu.msc.annihilation.common.dto;

import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/11/2
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 主要用于方法返回信息，Service层往Controller层传输的对象
 */
public class ResultDTO implements Serializable {

    private static final long serialVersionUID = -2927490301829187712L;

    /**
     * 返回处理结果
     *
     * @see org.cqu.edu.msc.annihilation.common.enums.ResponseEnum
     */
    private Integer code;

    /**
     * 返回具体错误信息，主要是提示使用该接口的用户具体错误
     */
    private Object msg;

    /**
     * 返回的数据，查询数据等
     */
    private Object data;

    public static ResultDTO success() {
        return new ResultDTO(ResponseEnum.SUCCESS);
    }

    public static ResultDTO success(Object o) {
        return new ResultDTO(ResponseEnum.SUCCESS, o);
    }


    public static ResultDTO unknownError(Object o) {
        return new ResultDTO(ResponseEnum.UNKNOWN_ERROR, o.toString());
    }

    public static ResultDTO unknownError(String msg, Object o) {
        return new ResultDTO(ResponseEnum.UNKNOWN_ERROR.getCode(),
                msg, o);
    }

    public static ResultDTO dataFormatError() {
        return new ResultDTO(ResponseEnum.DATA_FORMAT_ERROR);
    }

    public static ResultDTO dataFormatError(String msg, Object o) {
        return new ResultDTO(ResponseEnum.DATA_FORMAT_ERROR.getCode(),
                msg, o);
    }

    public static ResultDTO dataExisted(Object o) {
        return new ResultDTO(ResponseEnum.DATA_EXISTED, o);
    }

    public static ResultDTO dataNotExist() {
        return new ResultDTO(ResponseEnum.DATA_NOT_EXIST);
    }

    public static ResultDTO checkAndReturn(Object o) {
        return Objects.isNull(o) ? dataNotExist() : success(o);
    }

    public static <T> ResultDTO checkAndReturn(Page<T> tPage) {
        return tPage.getContent().size() == 0 ? dataNotExist() : success(tPage.getContent());
    }

    private ResultDTO() {
    }

    private ResultDTO(Integer code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResultDTO(Integer code, Object msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResultDTO(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

    private ResultDTO(ResponseEnum responseEnum, Object data) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code=" + code +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }
}