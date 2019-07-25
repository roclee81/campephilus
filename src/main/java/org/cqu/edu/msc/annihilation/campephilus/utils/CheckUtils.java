package org.cqu.edu.msc.annihilation.campephilus.utils;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.CrudException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.common.constant.DataConstants;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

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
     * @param saveObject 保存的对象
     */
    public static void checkSaveSuccess(Object result, Object saveObject) {
        if (Objects.isNull(result)) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, DataConstants.SAVE_ERROR, saveObject.toString());
        }
        log.info("Insert the success :{}", saveObject.toString());
    }

    public static void checkUpdateSuccess() {

    }

    public static void checkDeleteSuccess() {

    }

    public static void checkDataIsExist(Object searchResult) {
        if (Objects.nonNull(searchResult)) {
            // 判断到存在该仪器存在，则直接返回，抛出异常
            CrudException.dataIsExist();
        }
    }

    public static void checkDataIsNotExist(Object searchResult) {
        if (Objects.isNull(searchResult)) {
            // 判断到存在该仪器存在，则直接返回，抛出异常
            CrudException.dataIsNotExisted();
        }
    }
}
