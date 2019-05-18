package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.AfterOperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerListUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtil;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/17 12:56
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/afterOperationInfo")
public class AfterOperationInfoController {

    private final AfterOperationInfoService afterOperationInfoService;

    public AfterOperationInfoController(AfterOperationInfoService afterOperationInfoService) {
        this.afterOperationInfoService = afterOperationInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<ResultVO> listAfterOperationInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                           @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.getResultVOResponseEntity(afterOperationInfoService.listAllAfterOperationInfo(page, size));
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveAfterOperationInfo(@Valid AfterOperationInfo afterOperationInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        afterOperationInfoService.saveAfterOperationInfo(afterOperationInfo);
        return new ResponseEntity<>(ResultVO.success(afterOperationInfo), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateDeviceInfo(@Valid AfterOperationInfo afterOperationInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        afterOperationInfoService.updateAfterOperationInfo(afterOperationInfo);
        return new ResponseEntity<>(ResultVO.success(afterOperationInfo), HttpStatus.OK);
    }
}
