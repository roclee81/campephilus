package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.BeforeOperationInfoService;
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

    @ApiOperation(value = "查询BeforeOperationInfo", notes = "查询数据库中BeforeOperationInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码从0开始", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页显示的个数", required = true, dataType = "int")
    })
    @GetMapping("/")
    public ResponseEntity<ResultVO> listBeforeOperationInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                           @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(beforeOperationInfoService.listAllBeforeOperationInfo(page, size));
    }

    @ApiOperation(value = "上传BeforeOperationInfo", notes = "上传BeforeOperationInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "BeforeOperationInfo", value = "BeforeOperationInfo JSON对象", required = true, dataType = "BeforeOperationInfo"),
    })
    @PostMapping("/")
    public ResponseEntity<ResultVO> saveBeforeOperationInfo(@Valid BeforeOperationInfo beforeOperationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(beforeOperationInfoService, beforeOperationInfo);
    }

    @ApiOperation(value = "更新BeforeOperationInfo", notes = "更新BeforeOperationInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "BeforeOperationInfo", value = "BeforeOperationInfo JSON对象", required = true, dataType = "BeforeOperationInfo"),
    })
    @PutMapping("/")
    public ResponseEntity<ResultVO> updateBeforeOperationInfo(@Valid BeforeOperationInfo beforeOperationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(beforeOperationInfoService, beforeOperationInfo);
    }
}
