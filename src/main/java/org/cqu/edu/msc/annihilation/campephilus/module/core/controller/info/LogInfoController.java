package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.LogInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.LogInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 16:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/log")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_LOG)
public class LogInfoController {

    private final LogInfoService logInfoService;

    public LogInfoController(LogInfoService logInfoService) {
        this.logInfoService = logInfoService;
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(logInfoService.listAll(page, size));
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(logInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid LogInfo logInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        logInfoService.save(logInfo);
        return ResultVOUtils.success(logInfo);
    }

    @PutMapping("")
    public ResultVO update(@Valid LogInfo logInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        logInfoService.update(logInfo);
        return ResultVOUtils.success(logInfo);
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid LogInfo logInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        logInfoService.delete(logInfo);
        return ResultVOUtils.success(logInfo);
    }
}
