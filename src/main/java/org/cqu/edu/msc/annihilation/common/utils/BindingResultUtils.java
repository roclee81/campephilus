package org.cqu.edu.msc.annihilation.common.utils;

import org.cqu.edu.msc.annihilation.common.constant.DataConstants;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.ParseException;
import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 15:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class BindingResultUtils {

    /**
     * 检测bindingResult是否又错误，如果又错误将抛出ParseException异常
     *
     * @param bindingResult bindingResult
     */
    public static void checkBindingResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR, DataConstants.DATA_FIELD_FORMAT_ERROR, msg);
        }
    }
}
