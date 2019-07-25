package org.cqu.edu.msc.annihilation.campephilus.module.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * campephilus
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
     * 处理ParseException异常
     */
    @ExceptionHandler(value = ParseException.class)
    @ResponseBody
    public ResultVO handleDeviceException(ParseException e) {
        // 传递的值有错误信息，才将日志保存
        if (Objects.nonNull(e.getErrorMsg()) && Objects.nonNull(e.getErrorData())) {
            log.error("ParseException: errorMeg = {}, errorData = {}", e.getErrorMsg(), e.getErrorData());
        }
        return ResultVOUtils.error(e.getCode(), e.getMsg());
    }
}
