package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerListUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerSaveUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerUpdateUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping(value = "/operationMarkInfo")
@Slf4j
public class OperationMarkInfoController {

    private final OperationMarkInfoService operationMarkInfoService;

    @Autowired
    public OperationMarkInfoController(OperationMarkInfoService operationMarkInfoService) {
        this.operationMarkInfoService = operationMarkInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<ResultVO> listOperationMarkInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                          @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(operationMarkInfoService.listAllOperationMarkInfo(page, size));
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveOperationInfo(@Valid OperationMarkInfo operationMarkInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(operationMarkInfoService, operationMarkInfo);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateOperationInfo(@Valid OperationMarkInfo operationMarkInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(operationMarkInfoService, operationMarkInfo);
    }

}
