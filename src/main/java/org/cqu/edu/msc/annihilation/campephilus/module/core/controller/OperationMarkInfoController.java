package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.dataobject.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.vo.ResultVO;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/operationMarkInfo")
@Slf4j
public class OperationMarkInfoController {

    private final OperationMarkInfoService operationMarkInfoService;

    @Autowired
    public OperationMarkInfoController(OperationMarkInfoService operationMarkInfoService) {
        this.operationMarkInfoService = operationMarkInfoService;
    }

    @GetMapping("/list")
    public ResultVO listOperationMarkInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "20") int size) {
        List<OperationMarkInfo> searchResult = operationMarkInfoService.listAllOperationMarkInfo(page, size);
        return searchResult.size() == 0 ? ResultVO.dataNotExist() :
                new ResultVO(ResponseEnum.SUCCESS.getCode(), searchResult);
    }

    @PostMapping(value = "/save")
    public ResultVO saveOperationInfo(@Valid OperationMarkInfo operationMarkInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        operationMarkInfoService.saveOperationMarkInfo(operationMarkInfo);
        return ResultVO.success();
    }

    @PostMapping(value = "/update")
    public ResultVO updateOperationInfo(@Valid OperationMarkInfo operationMarkInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        operationMarkInfoService.updateOperationMarkInfo(operationMarkInfo);
        return ResultVO.success();
    }

}
