package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.BeforeOperationInfoService;
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
        List<BeforeOperationInfo> searchResult = beforeOperationInfoService.listAllBeforeOperationInfo(page, size);
        if (searchResult.size() != 0) {
            return new ResponseEntity<>(ResultVO.success(searchResult), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultVO.dataNotExist(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveBeforeOperationInfo(@Valid BeforeOperationInfo beforeOperationInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        beforeOperationInfoService.saveBeforeOperationInfo(beforeOperationInfo);
        return new ResponseEntity<>(ResultVO.success(beforeOperationInfo), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateDeviceInfo(@Valid BeforeOperationInfo beforeOperationInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        beforeOperationInfoService.updateBeforeOperationInfo(beforeOperationInfo);
        return new ResponseEntity<>(ResultVO.success(beforeOperationInfo), HttpStatus.OK);
    }
}
