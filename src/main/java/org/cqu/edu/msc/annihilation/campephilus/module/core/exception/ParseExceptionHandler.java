package org.cqu.edu.msc.annihilation.campephilus.module.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.DataConstants;
import org.cqu.edu.msc.annihilation.campephilus.module.core.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResultVO> handleDeviceException(ParseException e) {
        log.error(e.getErrorMsg(), e.getErrorData());
        Map<String, Object> result = new HashMap<>(2);
        result.put(DataConstants.DATA_MAP, e.getMsg());
        return new ResponseEntity<>(new ResultVO(e.getCode(), result), HttpStatus.BAD_REQUEST);
    }
}
