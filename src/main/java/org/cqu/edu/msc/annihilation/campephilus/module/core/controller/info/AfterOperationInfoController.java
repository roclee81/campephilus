package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AfterOperationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private AfterOperationInfoService afterOperationInfoService;

//    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
//    @GetMapping("")
//    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
//                         @RequestParam(value = "size", defaultValue = "20") int size) {
//        return ControllerCrudUtils.listAll(afterOperationInfoService.listAll(page, size));
//    }
//
//    @Cacheable(key = "'method:'+#root.methodName")
//    @GetMapping("/count")
//    public ResultVO countAll() {
//        return ControllerCrudUtils.list(afterOperationInfoService.countAll());
//    }
//
//    @PostMapping("")
//    public ResultVO save(@Valid AfterOperationInfo t, BindingResult bindingResult) {
//        BindingResultUtils.checkBindingResult(bindingResult);
//        return ControllerCrudUtils.save(afterOperationInfoService, t);
//    }
//
//    @PutMapping("")
//    public ResultVO update(@Valid AfterOperationInfo t, BindingResult bindingResult) {
//        BindingResultUtils.checkBindingResult(bindingResult);
//        return ControllerCrudUtils.update(afterOperationInfoService, t);
//    }
//
//    @DeleteMapping("")
//    public ResultVO delete(@Valid AfterOperationInfo t, BindingResult bindingResult) {
//        BindingResultUtils.checkBindingResult(bindingResult);
//        return ControllerCrudUtils.delete(afterOperationInfoService, t);
//    }
}
