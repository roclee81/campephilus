package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/operationDevice")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION_DEVICE)
public class OperationDeviceInfoController {

    @Autowired
    private OperationDeviceInfoService operationDeviceInfoService;

//    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
//    @GetMapping("")
//    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
//                         @RequestParam(value = "size", defaultValue = "20") int size) {
//        return ControllerCrudUtils.listAll(operationDeviceInfoService.listAll(page, size));
//    }
//
//    @Cacheable(key = "'method:'+#root.methodName")
//    @GetMapping("/count")
//    public ResultVO countAll() {
//        return ControllerCrudUtils.list(operationDeviceInfoService.countAll());
//    }
//
//    @PostMapping("")
//    public ResultVO save(@Valid OperationDeviceInfo t, BindingResult bindingResult) {
//        BindingResultUtils.checkBindingResult(bindingResult);
//        return ControllerCrudUtils.save(operationDeviceInfoService, t);
//    }
//
//    @PutMapping("")
//    public ResultVO update(@Valid OperationDeviceInfo t, BindingResult bindingResult) {
//        BindingResultUtils.checkBindingResult(bindingResult);
//        return ControllerCrudUtils.update(operationDeviceInfoService, t);
//    }
//
//    @DeleteMapping("")
//    public ResultVO delete(@Valid OperationDeviceInfo t, BindingResult bindingResult) {
//        BindingResultUtils.checkBindingResult(bindingResult);
//        return ControllerCrudUtils.delete(operationDeviceInfoService, t);
//    }
//
//    @Cacheable(key = "'method:'+#root.methodName+',operationNumber:'+#p0")
//    @GetMapping("/operationNumber")
//    public ResultVO listByOperationNumber(
//            @RequestParam(name = "operationNumber") int operationNumber) {
//        return ResultVOUtils.checkAndReturn(operationDeviceInfoService.getByOperationNumber(operationNumber));
//    }
}
