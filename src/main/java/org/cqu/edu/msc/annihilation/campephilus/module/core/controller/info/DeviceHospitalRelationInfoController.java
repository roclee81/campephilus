package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.DeviceHospitalRelationInfoService;
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
 * @date 2019/5/17 13:01
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/deviceHospitalRelation")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_DEVICE_HOSPITAL_RELATION)
public class DeviceHospitalRelationInfoController {

    private final DeviceHospitalRelationInfoService deviceHospitalRelationInfoService;

    public DeviceHospitalRelationInfoController(DeviceHospitalRelationInfoService deviceHospitalRelationInfoService) {
        this.deviceHospitalRelationInfoService = deviceHospitalRelationInfoService;
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(deviceHospitalRelationInfoService.listAll(page, size));
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(deviceHospitalRelationInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid DeviceHospitalRelationInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        deviceHospitalRelationInfoService.save(t);
        return ResultVOUtils.success(t);
    }

    @PutMapping("")
    public ResultVO update(@Valid DeviceHospitalRelationInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        deviceHospitalRelationInfoService.update(t);
        return ResultVOUtils.success(t);
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid DeviceHospitalRelationInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        deviceHospitalRelationInfoService.delete(t);
        return ResultVOUtils.success(t);
    }
}
