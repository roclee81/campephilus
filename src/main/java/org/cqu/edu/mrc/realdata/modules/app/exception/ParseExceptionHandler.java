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
 * @date 2019/1/25 0:54
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@ControllerAdvice
@Slf4j
public class ParseExceptionHandler {
    /**
     * 处理SaveException异常
     */
    @ExceptionHandler(value = ParseException.class)
    @ResponseBody
    public R handleDeviceException(ParseException e) {
        log.error(e.getErrorMeg(), e.getErrorData());
        return new R(e.getCode(), e.getMsg());
    }
}
