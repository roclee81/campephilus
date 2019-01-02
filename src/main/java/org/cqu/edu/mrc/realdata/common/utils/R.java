package org.cqu.edu.mrc.realdata.common.utils;

import org.apache.http.HttpStatus;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 * http最外层返回类
 */
public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public R(Integer code, Map msg) {
        put(DataConstants.CODE, code);
        put(DataConstants.MSG, msg);
    }

    public R(Integer code, String msg) {
        put(DataConstants.CODE, code);
        put(DataConstants.MSG, msg);
    }

    public R() {
        put("code", 200);
        put("data", "success");
    }

    public static R error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "Unknown exception, please contact administrator");
    }

    public static R error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("data", msg);
        return r;
    }

    public static R success(String msg) {
        R r = new R();
        r.put("data", msg);
        return r;
    }

    public static R success(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("data", msg);
        return r;
    }

    public static R success(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R success() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
