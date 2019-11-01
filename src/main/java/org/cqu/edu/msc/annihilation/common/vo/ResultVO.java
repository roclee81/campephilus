package org.cqu.edu.msc.annihilation.common.vo;

import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;

import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/13 11:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 对外层返回对象，返回用户信息
 */
public class ResultVO implements Serializable {

    private static final long serialVersionUID = -6307758086932966263L;

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
     * 请求的类型，根据项目定义
     * <p>由于请求可能采用异步方式，这里定义<code>type</code></p>
     * <p>如果请求采用同步方式，可以忽略该字段</p>
     */
    private Integer type;

    /**
     * 返回的数据，查询数据等
     */
    private Object data;

    private ResultVO() {
    }

    private ResultVO(Integer code, Object msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResultVO(Integer code, Object msg, Integer type, Object data) {
        this.code = code;
        this.msg = msg;
        this.type = type;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg=" + msg +
                ", type=" + type +
                ", data=" + data +
                '}';
    }

    public static ResultVO checkAndReturn(ResultDTO resultDTO, Integer type) {
        return new ResultVO(resultDTO.getCode(), resultDTO.getMsg(), type,
                resultDTO.getMsg());
    }


}
