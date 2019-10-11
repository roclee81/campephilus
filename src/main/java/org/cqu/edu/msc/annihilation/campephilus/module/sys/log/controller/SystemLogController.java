package org.cqu.edu.msc.annihilation.campephilus.module.sys.log.controller;

import org.cqu.edu.msc.annihilation.campephilus.module.sys.log.service.SystemLogService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/10/11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/system/log")
@CrossOrigin
public class SystemLogController {

    @Autowired
    private SystemLogService systemLogService;

    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.list(systemLogService.list(page, size));
    }

    @GetMapping("/current/day")
    public ResultVO listCurrentDay(@RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "20") int size,
                                   @RequestParam(value = "logLevel", defaultValue = "0") int logLevel) {
        return ControllerCrudUtils.list(systemLogService.listCurrentDayAndLogLevel(page, size, logLevel));
    }
}
