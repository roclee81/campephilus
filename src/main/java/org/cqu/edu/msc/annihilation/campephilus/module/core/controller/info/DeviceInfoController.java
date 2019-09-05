package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.DeviceInfoService;
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
 * @date 2019/4/29 15:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/device")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_DEVICE)
public class DeviceInfoController {

    private final DeviceInfoService deviceInfoService;

    @Autowired
    public DeviceInfoController(DeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(deviceInfoService.listAll(page, size));
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(deviceInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid DeviceInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        deviceInfoService.save(t);
        return ResultVOUtils.success(t);
    }

    @PutMapping("")
    public ResultVO update(@Valid DeviceInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        deviceInfoService.update(t);
        return ResultVOUtils.success(t);
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid DeviceInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        deviceInfoService.delete(t);
        return ResultVOUtils.success(t);
    }
}
