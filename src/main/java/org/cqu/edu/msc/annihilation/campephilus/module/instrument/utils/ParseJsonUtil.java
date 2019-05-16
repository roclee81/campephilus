package org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ParseDataDTO;

import java.util.Map;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/10 9:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ParseJsonUtil {

    @SuppressWarnings("unchecked")
    public static <T> T parseJsonString(ParseDataDTO parseDataDTO, Class<T> classOfT) {

        // 首先将JSON字符串转换为MAP
        Map<String, Object> map;
        try {
            map = new Gson().fromJson(parseDataDTO.getJsonData(), Map.class);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), parseDataDTO.toString());
        }

        // 将MAP转换为类
        String json = new Gson().toJson(map);
        T object;
        try {
            object = new Gson().fromJson(json, classOfT);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), json);
        }
        return object;
    }

    @SuppressWarnings("unchecked")
    public static <T> T parseJsonString(ParseDataDTO parseDataDTO, Class<T> classOfT, String className) {

        // 首先将JSON字符串转换为MAP
        Map<String, Object> map;
        try {
            map = new Gson().fromJson(parseDataDTO.getJsonData(), Map.class);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), parseDataDTO.toString());
        }

        // 将MAP转换为类
        String json = new Gson().toJson(map.get(className));
        T object;
        try {
            object = new Gson().fromJson(json, classOfT);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), json);
        }
        return object;
    }
}
