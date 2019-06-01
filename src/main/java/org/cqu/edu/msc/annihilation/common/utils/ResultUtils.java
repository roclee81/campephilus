package org.cqu.edu.msc.annihilation.common.utils;

import org.cqu.edu.msc.annihilation.common.constant.DataConstants;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 9:43
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ResultUtils {

    public static ResponseEntity notFound() {
        Map<String, Object> result = getResultMap(ResponseEnum.DATA_NOT_EXIST.getCode(), ResponseEnum.DATA_NOT_EXIST.getMsg());
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity success(Object object) {
        Map<String, Object> result = getResultMap(ResponseEnum.SUCCESS.getCode(), object);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public static ResponseEntity error(int code, String msg) {
        Map<String, Object> result = getResultMap(code, msg);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    private static Map<String, Object> getResultMap(Integer code, Object msg) {
        Map<String, Object> result = new HashMap<>(4);
        result.put(DataConstants.CODE, code);
        result.put(DataConstants.MSG, msg);
        return result;
    }
}
