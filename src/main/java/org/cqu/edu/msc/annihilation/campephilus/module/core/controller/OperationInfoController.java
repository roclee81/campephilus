package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.vo.ResultVO;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    private final OperationInfoService operationInfoService;

    @Autowired
    public OperationInfoController(OperationInfoService operationInfoService) {
        this.operationInfoService = operationInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<ResultVO> listOperationInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "size", defaultValue = "20") int size) {
        List<OperationInfo> searchResult = operationInfoService.listAllOperationInfo(page, size);
        if (searchResult.size() != 0) {
            return new ResponseEntity<>(ResultVO.success(searchResult), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultVO.dataNotExist(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveOperationInfo(@Valid OperationInfo operationInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        operationInfoService.saveOperationInfo(operationInfo);
        return new ResponseEntity<>(ResultVO.success(operationInfo), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateOperationInfo(@Valid OperationInfo operationInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        operationInfoService.updateOperationInfo(operationInfo);
        return new ResponseEntity<>(ResultVO.success(operationInfo), HttpStatus.OK);
    }
}