package org.cqu.edu.mrc.annihilation.campephilus.exception;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.common.enums.ErrorEnum;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/24 23:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
public class SaveException extends RuntimeException {
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMeg() {
        return errorMeg;
    }

    public void setErrorMeg(String errorMeg) {
        this.errorMeg = errorMeg;
    }

    public String getErrorData() {
        return errorData;
    }

    public void setErrorData(String errorData) {
        this.errorData = errorData;
    }
}
