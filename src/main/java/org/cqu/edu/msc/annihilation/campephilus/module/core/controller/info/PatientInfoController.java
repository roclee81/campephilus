package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.PatientInfoService;
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
 * @date 2019/4/29 11:31
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/patient")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_PATIENT)
public class PatientInfoController {

    private final PatientInfoService patientInfoService;

    @Autowired
    public PatientInfoController(PatientInfoService patientInfoService) {
        this.patientInfoService = patientInfoService;
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(patientInfoService.listAll(page, size));
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(patientInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid PatientInfo patientInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        patientInfoService.save(patientInfo);
        return ResultVOUtils.success();
    }

    @PutMapping("")
    public ResultVO update(@Valid PatientInfo patientInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        patientInfoService.update(patientInfo);
        return ResultVOUtils.success();
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid PatientInfo patientInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        patientInfoService.delete(patientInfo);
        return ResultVOUtils.success();
    }
}
