package org.cqu.edu.mrc.realdata.modules.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/24 23:13
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@ControllerAdvice
@Slf4j
public class SaveExceptionHandler {

    /**
     * 处理SaveException异常
     */
    @ExceptionHandler(value = SaveException.class)
    @ResponseBody
    public R handleDeviceException(SaveException e) {
        log.error(e.getMsg(), e.getErrorData());
        return new R(e.getCode(), e.getMsg());
    }
}
