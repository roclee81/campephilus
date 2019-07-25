package org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.lang3.ClassUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.ParseException;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;

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

    public static <T> T parseJsonString(InstrumentForm instrumentForm, Class<T> classOfT) {
        String json = instrumentForm.getData();
        return getTObject(classOfT, json);
    }

    public static <T> T parseClassName2JsonString(InstrumentForm instrumentForm, Class<T> classOfT) {
        String className = getClassName(classOfT);
        // 首先将JSON字符串转换为MAP
        Map<String, Object> map = getJsonMap(instrumentForm);

        // 将MAP转换为类
        String json = getGsonObject().toJson(map.get(className));
        return getTObject(classOfT, json);
    }

    private static <T> String getClassName(Class<T> classOfT) {
        String className = ClassUtils.getShortClassName(classOfT);
        String firstCharacter = className.substring(0, 1).toLowerCase();
        return firstCharacter + className.substring(1);
    }

    /**
     * 解析json字符串并转换成类
     *
     * @param classOfT 转换的类
     * @param json     带解析的json字符串
     * @param <T>      泛型
     * @return 泛型类
     */
    private static <T> T getTObject(Class<T> classOfT, String json) {
        T object = null;
        try {
            object = getGsonObject().fromJson(json, classOfT);
        } catch (JsonSyntaxException | NumberFormatException exception) {
            ParseException.dataFormatException(exception, json);
        }
        return object;
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
        } catch (JsonSyntaxException e) {
            ParseException.dataFormatException(e, instrumentForm);
        }
        return null;
    }
}
