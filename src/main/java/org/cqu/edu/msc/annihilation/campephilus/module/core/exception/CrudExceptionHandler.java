package org.cqu.edu.msc.annihilation.campephilus.module.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.sys.log.entity.SystemLog;
import org.cqu.edu.msc.annihilation.campephilus.module.sys.log.service.SystemLogService;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/24 23:13
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@ControllerAdvice
@Slf4j
public class CrudExceptionHandler {

    @Autowired
    private SystemLogService systemLogService;

    /**
     * 处理SaveException异常
     */
    @ExceptionHandler(value = CrudException.class)
    @ResponseBody
    public ResultVO handleCrudException(CrudException e) {
        // 传递的值有错误信息，才将日志保存
        if (Objects.nonNull(e.getErrorMsg()) && Objects.nonNull(e.getErrorData()) && Objects.nonNull(e.getCrudTypeEnum())) {
            systemLogService.save(SystemLog.structureSystemErrorLog("Exception: errorMeg = " + e.toString()));
            log.error(e.getCrudTypeEnum().getMsg() + "Exception: errorMeg = {}, errorData = {}", e.getErrorMsg(), e.getErrorData());
        }
        return ResultVOUtils.error(e.getCode(), e.getMsg());
    }
}
