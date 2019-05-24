package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerListUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerSaveUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerUpdateUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
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

    @ApiOperation(value = "查询OperationMarkInfo", notes = "查询数据库中OperationMarkInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码从0开始", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页显示的个数", required = true, dataType = "int")
    })
    @GetMapping("/")
    public ResponseEntity<ResultVO> listOperationMarkInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                          @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(operationMarkInfoService.listAllOperationMarkInfo(page, size));
    }

    @ApiOperation(value = "上传OperationMarkInfo", notes = "上传OperationMarkInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "OperationMarkInfo", value = "OperationMarkInfo JSON对象", required = true, dataType = "OperationMarkInfo"),
    })
    @PostMapping("/")
    public ResponseEntity<ResultVO> saveOperationMarkInfo(@Valid OperationMarkInfo operationMarkInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(operationMarkInfoService, operationMarkInfo);
    }

    @ApiOperation(value = "更新OperationMarkInfo", notes = "更新OperationMarkInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "OperationMarkInfo", value = "OperationMarkInfo JSON对象", required = true, dataType = "OperationMarkInfo"),
    })
    @PutMapping("/")
    public ResponseEntity<ResultVO> updateOperationMarkInfo(@Valid OperationMarkInfo operationMarkInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(operationMarkInfoService, operationMarkInfo);
    }

}
