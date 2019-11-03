package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
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

    @PostMapping(value = "/list")
    public ResultVO saveList(@Valid InstrumentForm instrumentForm, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ResultVO.checkAndReturn(operationMarkInfoService.saveList(instrumentForm),
                instrumentForm.getCode() + 1);
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
