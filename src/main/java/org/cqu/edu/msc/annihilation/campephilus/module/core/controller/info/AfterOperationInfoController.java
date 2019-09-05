package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AfterOperationInfoService;
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
 * @date 2019/5/17 12:56
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/afterOperation")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_AFTER_OPERATION)
public class AfterOperationInfoController {

    private final AfterOperationInfoService afterOperationInfoService;

    public AfterOperationInfoController(AfterOperationInfoService afterOperationInfoService) {
        this.afterOperationInfoService = afterOperationInfoService;
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(afterOperationInfoService.listAll(page, size));
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(afterOperationInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid AfterOperationInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        afterOperationInfoService.save(t);
        return ResultVOUtils.success(t);
    }

    @PutMapping("")
    public ResultVO update(@Valid AfterOperationInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        afterOperationInfoService.update(t);
        return ResultVOUtils.success(t);
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid AfterOperationInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        afterOperationInfoService.delete(t);
        return ResultVOUtils.success(t);
    }
}
