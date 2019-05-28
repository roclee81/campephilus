package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationDeviceInfoService;
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
 * @date 2019/5/28 13:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Api(value = "operationDeviceInfo相关的api")
@RestController
@RequestMapping(value = "/operationDeviceInfo")
public class OperationDeviceInfoController {

    private final OperationDeviceInfoService operationDeviceInfoService;

    @Autowired
    public OperationDeviceInfoController(OperationDeviceInfoService operationDeviceInfoService) {
        this.operationDeviceInfoService = operationDeviceInfoService;
    }

    @ApiOperation(value = "查询OperationDeviceInfo", notes = "查询数据库中OperationDeviceInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码从0开始", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页显示的个数", required = true, dataType = "int")
    })
    @GetMapping("/")
    public ResponseEntity<ResultVO> listOperationDeviceInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                            @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(operationDeviceInfoService.listAll(page, size));
    }

    @ApiOperation(value = "上传OperationDeviceInfo", notes = "上传OperationDeviceInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "OperationDeviceInfo", value = "OperationDeviceInfo JSON对象", required = true, dataType = "OperationDeviceInfo"),
    })
    @PostMapping("/")
    public ResponseEntity<ResultVO> saveOperationDeviceInfo(@Valid OperationDeviceInfo operationDeviceInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(operationDeviceInfoService, operationDeviceInfo);
    }

    @ApiOperation(value = "更改OperationDeviceInfo", notes = "更改OperationDeviceInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "OperationDeviceInfo", value = "OperationDeviceInfo JSON对象", required = true, dataType = "OperationDeviceInfo"),
    })
    @PutMapping("/")
    public ResponseEntity<ResultVO> updateOperationDeviceInfo(@Valid OperationDeviceInfo operationDeviceInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(operationDeviceInfoService, operationDeviceInfo);
    }
}
