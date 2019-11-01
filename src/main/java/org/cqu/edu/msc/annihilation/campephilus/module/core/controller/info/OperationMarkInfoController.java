package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
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
 * @date 2019/4/29 15:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/operationMark")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION_MARK)
public class OperationMarkInfoController {

    @Autowired
    private OperationMarkInfoService operationMarkInfoService;

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(operationMarkInfoService.listOperationMarkInfoDTO(page, size));
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(operationMarkInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid OperationMarkInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.save(operationMarkInfoService, t);
    }

    @PostMapping(value = "/list")
    public ResultVO saveList(@Valid InstrumentForm instrumentForm, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return new ResultVO(instrumentForm.getCode() + 1, "success");
//        return ResultVOUtils.checkAndReturn(operationMarkInfoService.saveList(instrumentForm));
    }

    @PutMapping("")
    public ResultVO update(@Valid OperationMarkInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.update(operationMarkInfoService, t);
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid OperationMarkInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.delete(operationMarkInfoService, t);
    }

    @Cacheable(key = "'method:'+#root.methodName+',operationNumber:'+#p0")
    @GetMapping("/operationNumber")
    public ResultVO listByOperationNumber(
            @RequestParam(value = "operationNumber", defaultValue = "-1") int operationNumber) {
        return ControllerCrudUtils.list(operationMarkInfoService.listOperationMarkInfoDTOByOperationNumber(operationNumber));
    }

    //    @DeleteMapping("/id")
//    public ResultVO delete(@RequestParam(value = "id", defaultValue = "-1") int id) {
//        return ControllerCrudUtils.delete(operationMarkInfoService, id);
//    }

}
