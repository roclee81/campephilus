package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.BeforeOperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerListUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerSaveUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerUpdateUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/17 12:59
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/beforeOperationInfo")
public class BeforeOperationInfoController {

    private final BeforeOperationInfoService beforeOperationInfoService;

    public BeforeOperationInfoController(BeforeOperationInfoService beforeOperationInfoService) {
        this.beforeOperationInfoService = beforeOperationInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<ResultVO> listAfterOperationInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                           @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(beforeOperationInfoService.listAllBeforeOperationInfo(page, size));
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveBeforeOperationInfo(@Valid BeforeOperationInfo beforeOperationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(beforeOperationInfoService, beforeOperationInfo);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateDeviceInfo(@Valid BeforeOperationInfo beforeOperationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(beforeOperationInfoService, beforeOperationInfo);
    }
}
