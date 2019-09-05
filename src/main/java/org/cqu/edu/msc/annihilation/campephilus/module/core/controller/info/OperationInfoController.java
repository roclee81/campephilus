package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
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
public class OperationInfoController {

    private final OperationInfoService operationInfoService;

    @Autowired
    public OperationInfoController(OperationInfoService operationInfoService) {
        this.operationInfoService = operationInfoService;
    }

    @GetMapping("/state")
    public ResultVO getOperationStateByOperationNumber(
            @RequestParam(value = "operationNumber", defaultValue = "1") int operationNumber) {
        int operationState = operationInfoService.getOperationStateByOperationNumber(operationNumber);
        return ControllerCrudUtils.list(operationState);
    }

    @GetMapping("/current")
    public ResultVO getCurrentOperationInfo() {
        Map<Integer, Integer> map = operationInfoService.getCurrentOperationInfo();
        return ControllerCrudUtils.list(map);
    }

    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(operationInfoService.listAll(page, size));
    }

    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(operationInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid OperationInfo operationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        operationInfoService.save(operationInfo);
        return ResultVOUtils.success();
    }

    @PutMapping("")
    public ResultVO update(@Valid OperationInfo operationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        operationInfoService.update(operationInfo);
        return ResultVOUtils.success();
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid OperationInfo operationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        operationInfoService.delete(operationInfo);
        return ResultVOUtils.success();
    }
}