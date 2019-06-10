package org.cqu.edu.msc.annihilation.campephilus.module.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.common.constant.DataConstants;
import org.cqu.edu.msc.annihilation.common.enums.ErrorEnum;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

import java.io.Serializable;
import java.util.Optional;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/24 23:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public class SaveException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;
    private String errorMeg;
    private String errorData;

    public SaveException(ResponseEnum responseEnum, String errorMeg, String errorData) {
        super();
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
        this.errorMeg = errorMeg;
        this.errorData = errorData;
    }

    public SaveException(ErrorEnum errorEnum, String errorMeg, String errorData) {
        super();
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
        this.errorMeg = errorMeg;
        this.errorData = errorData;
    }

    public SaveException(ResponseEnum responseEnum) {
        super();
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

    /**
     * 检查保存的结果
     * 如果保存失败，将抛出异常
     *
     * @param result     保存的结果
     * @param saveObject 保存的对象
     */
    public static void checkSaveSuccess(Object result, Object saveObject) {
        if (null == result) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, DataConstants.SAVE_ERROR, saveObject.toString());
        } else {
            log.info("Insert the success :{}", saveObject.toString());
        }
    }

    public static void checkDataIsExist(Object searchResult) {
        if (null != searchResult) {
            // 判断到存在该仪器存在，则直接返回，抛出异常
            throw new SaveException(ResponseEnum.DATA_EXISTED);
        }
    }

    public static void checkDataIsExist(Optional searchResult) {
        if (searchResult.isPresent()) {
            // 判断到存在该仪器存在，则直接返回，抛出异常
            throw new SaveException(ResponseEnum.DATA_EXISTED);
        }
    }

    public static void checkDataIsNotExist(Optional searchResult) {
        if (searchResult.isEmpty()) {
            // 判断到存在该仪器存在，则直接返回，抛出异常
            throw new SaveException(ResponseEnum.DATA_NOT_EXIST);
        }
    }

    public static void checkDataIsNotExist(Object searchResult) {
        if (null == searchResult) {
            // 判断到存在该仪器存在，则直接返回，抛出异常
            throw new SaveException(ResponseEnum.DATA_NOT_EXIST);
        }
    }
}
