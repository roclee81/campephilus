package org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSyntaxException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
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
    public static <T> T parseJsonString(InstrumentForm instrumentForm, Class<T> classOfT) {
        String json = instrumentForm.getData();
        T object;
        try {
            object = getGsonObject().fromJson(json, classOfT);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), json);
        }
        return object;
    }

    @SuppressWarnings("unchecked")
    public static <T> T parseJsonString(InstrumentForm instrumentForm, Class<T> classOfT, String className) {
        // 首先将JSON字符串转换为MAP
        Map<String, Object> map = getJsonMap(instrumentForm);

        // 将MAP转换为类
        String json = getGsonObject().toJson(map.get(className));
        T object;
        try {
            object = getGsonObject().fromJson(json, classOfT);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), json);
        }
        return object;
    }

    @SuppressWarnings("unchecked")
    public static OperationInfo parseTimeJsonString(InstrumentForm instrumentForm) {
        // 首先将JSON字符串转换为MAP
        Map<String, Object> map = getJsonMap(instrumentForm);
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

    private static Gson getGsonObject() {
        GsonBuilder builder = new GsonBuilder();
        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()));
        return builder.create();
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> getJsonMap(InstrumentForm instrumentForm) {
        try {
            return new Gson().fromJson(instrumentForm.getData(), Map.class);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), instrumentForm.toString());
        }
    }
}
