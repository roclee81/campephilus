package org.cqu.edu.msc.annihilation.campephilus.utils;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.CrudException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.ParseException;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author lx
 * @version V1.0
 * @date 2019/7/25 23:27
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
public class CheckUtils {

    /**
     * 检查保存的结果
     * 如果保存失败，将抛出异常
     *
     * @param result     保存的结果
     * @param saveObject 待保存的对象
     */
    public static void checkSaveSuccess(Object result, Object saveObject) {
        if (Objects.isNull(result)) {
            CrudException.saveDataFormatException(saveObject.toString());
        }
        log.info("Insert the success :{}", saveObject.toString());
    }

    public static void checkUpdateSuccess() {

    }

    public static void checkDeleteSuccess() {

    }

    /**
     * 根据查询的数据，判断数据是否存在
     * 不存在则抛出异常
     *
     * @param searchResult 查询得到的结果
     */
    public static void checkDataIsExisted(Object searchResult) {
        if (Objects.nonNull(searchResult)) {
            // 判断到存在该仪器存在，则直接返回，抛出异常
            CrudException.dataIsExisted();
        }
    }

    /**
     * 根据查询的数据，判断数据是否存在
     * 存在则抛出异常
     *
     * @param searchResult 查询得到的结果
     */
    public static void checkDataIsNotExisted(Object searchResult) {
        if (Objects.isNull(searchResult)) {
            // 判断到存在该仪器存在，则直接返回，抛出异常
            CrudException.dataIsNotExisted();
        }
    }

    /**
     * 检查解析后的结果
     * 如果结果的size为0抛出解析异常
     *
     * @param result   解析后的HashMap<String, Object>结果
     * @param jsonData 解析的数据
     */
    public static void checkParseResult(HashMap<String, Object> result, String jsonData) {
        if (result.size() == 0) {
            ParseException.dataFormatException(jsonData);
        }
    }
}
