package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationInfoCRUDService;
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
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/operationInfo")
@Slf4j
public class OperationInfoController {

    private final OperationInfoCRUDService operationInfoService;

    @Autowired
    public OperationInfoController(OperationInfoCRUDService operationInfoService) {
        this.operationInfoService = operationInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<ResultVO> listOperationInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                      @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(operationInfoService.listAllOperationInfo(page, size));
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveOperationInfo(@Valid OperationInfo operationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(operationInfoService, operationInfo);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateOperationInfo(@Valid OperationInfo operationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(operationInfoService, operationInfo);
    }
}