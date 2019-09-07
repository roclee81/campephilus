package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/operation")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION)
public class OperationInfoController {

    private final OperationInfoService operationInfoService;

    @Autowired
    public OperationInfoController(OperationInfoService operationInfoService) {
        this.operationInfoService = operationInfoService;
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(operationInfoService.listOperationInfoDTO(page, size));
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(operationInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid OperationInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.save(operationInfoService, t);
    }

    @PutMapping("")
    public ResultVO update(@Valid OperationInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.update(operationInfoService, t);
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid OperationInfo t, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerCrudUtils.delete(operationInfoService, t);
    }

    @Cacheable(key = "'method:'+#root.methodName+',operationNumber:'+#p0")
    @GetMapping("/state")
    public ResultVO getOperationStateByOperationNumber(@RequestParam(value = "operationNumber", defaultValue = "1") int operationNumber) {
        int operationState = operationInfoService.getOperationStateByOperationNumber(operationNumber);
        return ControllerCrudUtils.list(operationState);
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @GetMapping("/current")
    public ResultVO getCurrentOperationInfo() {
        Map<Integer, Integer> map = operationInfoService.getCurrentOperationInfo();
        return ControllerCrudUtils.list(map);
    }
}