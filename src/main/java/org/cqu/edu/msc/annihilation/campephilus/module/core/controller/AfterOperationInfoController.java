package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.AfterOperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerListUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerSaveUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerUpdateUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/17 12:56
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */

@Api(value = "afterOperationInfo相关的api")
@RestController
@RequestMapping(value = "/afterOperationInfo")
public class AfterOperationInfoController {

    private final AfterOperationInfoService afterOperationInfoService;

    public AfterOperationInfoController(AfterOperationInfoService afterOperationInfoService) {
        this.afterOperationInfoService = afterOperationInfoService;
    }

    @ApiOperation(value = "查询AfterOperationInfo", notes = "查询数据库中AfterOperationInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码从0开始", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页显示的个数", required = true, dataType = "int")
    })
    @GetMapping("/")
    public ResponseEntity<ResultVO> listAfterOperationInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                           @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(afterOperationInfoService.listAllAfterOperationInfo(page, size));
    }

    @ApiOperation(value = "上传AfterOperationInfo", notes = "上传AfterOperationInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "AfterOperationInfo", value = "AfterOperationInfo JSON对象", required = true, dataType = "AfterOperationInfo"),
    })
    @PostMapping("/")
    public ResponseEntity<ResultVO> saveAfterOperationInfo(@Valid AfterOperationInfo afterOperationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(afterOperationInfoService, afterOperationInfo);
    }

    @ApiOperation(value = "更改AfterOperationInfo", notes = "更改AfterOperationInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "AfterOperationInfo", value = "AfterOperationInfo JSON对象", required = true, dataType = "AfterOperationInfo"),
    })
    @PutMapping("/")
    public ResponseEntity<ResultVO> updateAfterOperationInfo(@Valid AfterOperationInfo afterOperationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(afterOperationInfoService, afterOperationInfo);
    }
}
