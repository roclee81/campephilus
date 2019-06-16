package org.cqu.edu.msc.annihilation.campephilus.module.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.common.constant.DataConstants;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

import java.io.Serializable;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/25 0:53
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class ParseException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;
    private String errorMsg;
    private String errorData;

    public ParseException(ResponseEnum responseEnum) {
        super();
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
    }

    public ParseException(ResponseEnum responseEnum, String errorMsg, String errorData) {
        super();
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
        this.errorMsg = errorMsg;
        this.errorData = errorData;
    }

    /**
     * 检查保存的结果
     * 如果保存失败，将抛出异常
     *
     * @param saveObject 保存的对象
     */
    public static void error(Object saveObject) {
        throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, DataConstants.DATA_FORMAT_ERROR, saveObject.toString());
    }

    /**
     * 检查保存的结果
     * 如果保存失败，将抛出异常
     *
     * @param saveObject 保存的对象
     */
    public void error(String saveObject) {
        throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, DataConstants.DATA_FORMAT_ERROR, saveObject);
    }
}
