package org.cqu.edu.msc.annihilation.campephilus.module.core.vo;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.DataConstants;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.ReplyConstants;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 * http最外层返回类
 */
public class ResultVO extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 3508893183854262377L;

    public ResultVO(Integer code, Object object) {
        put(DataConstants.CODE, code);
        put(DataConstants.MSG, object);
    }

    public ResultVO() {
    }

    public static ResultVO error(int code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.put("code", code);
        resultVO.put("data", msg);
        return resultVO;
    }

    public static ResultVO success(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.put("data", msg);
        return resultVO;
    }

    public static ResultVO success(int code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.put("code", code);
        resultVO.put("data", msg);
        return resultVO;
    }

    public static ResultVO success(Map<String, Object> map) {
        ResultVO resultVO = new ResultVO();
        resultVO.putAll(map);
        return resultVO;
    }

    public static ResultVO dataNotExist() {
        return new ResultVO(ResponseEnum.DATA_DOES_NOT_EXIST.getCode(), ReplyConstants.DATA_DOES_NOT_EXIST);
    }

    public static ResultVO unknownError() {
        return new ResultVO(ResponseEnum.UNKNOWN_ERROR.getCode(), ReplyConstants.UNKNOWN_ERROR);
    }

    public static ResultVO requestParameterError() {
        return new ResultVO(ResponseEnum.REQUEST_PARAMETER_DOES_NOT_EXIST.getCode(), ReplyConstants.REQUEST_PARAMETER_DOES_NOT_EXIST);
    }

    public static ResultVO success() {
        return new ResultVO();
    }

    @Override
    public ResultVO put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "ResultVO{}";
    }
}
