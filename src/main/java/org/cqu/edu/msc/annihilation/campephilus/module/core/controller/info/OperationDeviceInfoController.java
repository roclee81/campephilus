package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationDeviceInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    private final OperationDeviceInfoService operationDeviceInfoService;

    @Autowired
    public OperationDeviceInfoController(OperationDeviceInfoService operationDeviceInfoService) {
        this.operationDeviceInfoService = operationDeviceInfoService;
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(operationDeviceInfoService.listAll(page, size));
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(operationDeviceInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid OperationDeviceInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.save(operationDeviceInfoService, t);
    }

    @PutMapping("")
    public ResultVO update(@Valid OperationDeviceInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.update(operationDeviceInfoService, t);
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid OperationDeviceInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.delete(operationDeviceInfoService, t);
    }

    @Cacheable(key = "'method:'+#root.methodName+',operationNumber:'+#p0")
    @GetMapping("/operationNumber")
    public ResultVO listByOperationNumber(
            @RequestParam(name = "operationNumber") int operationNumber) {
        return ResultVOUtils.checkAndReturn(operationDeviceInfoService.listByOperationNumber(operationNumber));
    }
}
