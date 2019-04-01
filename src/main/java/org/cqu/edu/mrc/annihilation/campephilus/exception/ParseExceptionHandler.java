package org.cqu.edu.mrc.annihilation.campephilus.exception;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
     * 处理SaveException异常
     */
    @ExceptionHandler(value = ParseException.class)
    @ResponseBody
    public ResultVO handleDeviceException(ParseException e) {
        log.error(e.getErrorMsg(), e.getErrorData());
        Map<String, Object> result = new HashMap<>(2);
        result.put(DataConstants.DATA_MAP, e.getMsg());
        return new ResultVO(e.getCode(), result);
    }
}
