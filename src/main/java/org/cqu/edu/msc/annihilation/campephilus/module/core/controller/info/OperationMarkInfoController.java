package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
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
public class OperationMarkInfoController {

    private final OperationMarkInfoService operationMarkInfoService;

    @Autowired
    public OperationMarkInfoController(OperationMarkInfoService operationMarkInfoService) {
        this.operationMarkInfoService = operationMarkInfoService;
    }

    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(operationMarkInfoService.listAll(page, size));
    }

    @GetMapping("/count")
    public ResultVO countAll() {
        return ControllerCrudUtils.list(operationMarkInfoService.countAll());
    }

    @PostMapping("")
    public ResultVO save(@Valid OperationMarkInfo operationMarkInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        operationMarkInfoService.save(operationMarkInfo);
        return ResultVOUtils.success();
    }

    @PutMapping("")
    public ResultVO update(@Valid OperationMarkInfo operationMarkInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        operationMarkInfoService.update(operationMarkInfo);
        return ResultVOUtils.success();
    }

    @DeleteMapping("")
    public ResultVO delete(@Valid OperationMarkInfo operationMarkInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        operationMarkInfoService.delete(operationMarkInfo);
        return ResultVOUtils.success();
    }

    @DeleteMapping("/id")
    public ResultVO delete(@RequestParam(value = "id", defaultValue = "-1") int id) {
        operationMarkInfoService.delete(id);
        return ResultVOUtils.success();
    }

    @GetMapping("/operationNumber")
    public ResultVO listByOperationNumber(
            @RequestParam(value = "operationNumber", defaultValue = "-1") int operationNumber) {
        return ControllerCrudUtils.list(operationMarkInfoService.listByOperationNumber(operationNumber));
    }
}
