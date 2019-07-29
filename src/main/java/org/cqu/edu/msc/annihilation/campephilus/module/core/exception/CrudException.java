package org.cqu.edu.msc.annihilation.campephilus.module.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cqu.edu.msc.annihilation.common.constant.DataConstants;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

import javax.validation.ValidationException;
import java.io.Serializable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/7/25 23:01
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CrudException extends RuntimeException implements Serializable {

    enum CrudTypeEnum {
        /**
         * NON
         */
        NON(0, "NON"),

        /**
         * SELECT
         */
        SELECT(1, "SELECT"),

        /**
         * SAVE
         */
        SAVE(2, "SAVE"),

        /**
         * UPDATE
         */
        UPDATE(3, "UPDATE"),

        /**
         * DELETE
         */
        DELETE(4, "DELETE");

        private Integer code;
        private String  msg;

        CrudTypeEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    private static final long serialVersionUID = -1343312269172404301L;

    private String       msg;
    private int          code;
    private String       errorMsg;
    private String       errorData;
    private CrudTypeEnum crudTypeEnum;

    private CrudException(CrudTypeEnum crudTypeEnum, ResponseEnum responseEnum) {
        super();
        this.crudTypeEnum = crudTypeEnum;
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
    }

    private CrudException(CrudTypeEnum crudTypeEnum, ResponseEnum responseEnum, String errorMsg, String errorData) {
        super();
        this.crudTypeEnum = crudTypeEnum;
        this.msg = responseEnum.getMsg();
        this.code = responseEnum.getCode();
        this.errorMsg = errorMsg;
        this.errorData = errorData;
    }

    private CrudException(CrudTypeEnum crudTypeEnum, String msg, int code, String errorMsg, String errorData) {
        super();
        this.crudTypeEnum = crudTypeEnum;
        this.msg = msg;
        this.code = code;
        this.errorMsg = errorMsg;
        this.errorData = errorData;
    }

    /**
     * 抛出数据已经存在的异常
     */
    public static void dataIsExisted() {
        throw new CrudException(CrudTypeEnum.NON, ResponseEnum.DATA_EXISTED);
    }

    public static void throwException(CrudException e) {
        throw new CrudException(CrudTypeEnum.NON, e.getMsg(), e.getCode(), e.errorMsg, e.errorData);
    }

    /**
     * 抛出数据不存在的异常
     */
    public static void dataIsNotExisted() {
        throw new CrudException(CrudTypeEnum.NON, ResponseEnum.DATA_NOT_EXIST);
    }

    public static void saveDataFormatException(String saveObjectMessage) {
        throw new CrudException(CrudTypeEnum.SAVE, ResponseEnum.DATA_FORMAT_ERROR, DataConstants.SAVE_ERROR, saveObjectMessage);
    }

    public static void saveDataFormatException(ValidationException e, Object object) {
        throw new CrudException(CrudTypeEnum.SAVE, ResponseEnum.DATA_FORMAT_ERROR, e.toString(), object.toString());
    }

    public static void saveUnknownException(Exception e, Object object) {
        throw new CrudException(CrudTypeEnum.SAVE, ResponseEnum.UNKNOWN_ERROR, e.toString(), object.toString());
    }

    public static void updateUnknownException(Exception e, Object object) {
        throw new CrudException(CrudTypeEnum.UPDATE, ResponseEnum.UNKNOWN_ERROR, e.toString(), object.toString());
    }

    public static void updateIdException() {
        throw new CrudException(CrudTypeEnum.UPDATE, ResponseEnum.UPDATE_ID_ERROR);
    }

    public static void deleteUnknownException(Exception e, Object object) {
        throw new CrudException(CrudTypeEnum.DELETE, ResponseEnum.UNKNOWN_ERROR, e.toString(), object.toString());
    }
}
