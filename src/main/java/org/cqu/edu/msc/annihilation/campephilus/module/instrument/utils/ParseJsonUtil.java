package org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSyntaxException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

import java.util.Date;
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
            object = getTimeStampGson().fromJson(json, classOfT);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), json);
        }
        return object;
    }

    public static Gson getTimeStampGson() {
        GsonBuilder builder = new GsonBuilder();
        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()));
        return builder.create();
    }

    @SuppressWarnings("unchecked")
    public static OperationInfo parseTimeJsonString(ParseDataDTO parseDataDTO) {
        // 首先将JSON字符串转换为MAP
        Map<String, Object> map;
        try {
            map = new Gson().fromJson(parseDataDTO.getJsonData(), Map.class);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), parseDataDTO.toString());
        }
        OperationInfo operationInfo = new OperationInfo();
        for (String key : map.keySet()) {
            if ("operationEndTime".equals(key)) {
                operationInfo.setOperationEndTime(new Date(Long.parseLong((String) map.get("operationEndTime"))));
            } else if ("operationStartTime".equals(key)) {
                operationInfo.setOperationStartTime(new Date(Long.parseLong((String) map.get("operationStartTime"))));
            }
        }
        return operationInfo;
    }
}
