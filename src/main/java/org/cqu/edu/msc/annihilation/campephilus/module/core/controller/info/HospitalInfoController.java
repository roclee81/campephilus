package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.HospitalInfoService;
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
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/hospital")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_HOSPITAL)
public class HospitalInfoController {

    private final HospitalInfoService hospitalInfoService;

    @Autowired
    public HospitalInfoController(HospitalInfoService hospitalInfoService) {
        this.hospitalInfoService = hospitalInfoService;
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(hospitalInfoService.listAll(page, size));
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(hospitalInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid HospitalInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        hospitalInfoService.save(t);
        return ResultVOUtils.success(t);
    }

    @PutMapping("")
    public ResultVO update(@Valid HospitalInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        hospitalInfoService.update(t);
        return ResultVOUtils.success(t);
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid HospitalInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        hospitalInfoService.delete(t);
        return ResultVOUtils.success(t);
    }
}
