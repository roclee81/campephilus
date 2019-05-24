package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.HospitalInfoService;
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
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/hospitalInfo")
@Slf4j
public class HospitalInfoController {

    private final HospitalInfoService hospitalInfoService;

    @Autowired
    public HospitalInfoController(HospitalInfoService hospitalInfoService) {
        this.hospitalInfoService = hospitalInfoService;
    }

    @ApiOperation(value = "查询HospitalInfo", notes = "查询数据库中HospitalInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码从0开始", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页显示的个数", required = true, dataType = "int")
    })
    @GetMapping("/")
    public ResponseEntity<ResultVO> listHospitalInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(hospitalInfoService.listAllOperationInfo(page, size));
    }

    @ApiOperation(value = "上传HospitalInfo", notes = "上传HospitalInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "HospitalInfo", value = "HospitalInfo JSON对象", required = true, dataType = "HospitalInfo"),
    })
    @PostMapping("/")
    public ResponseEntity<ResultVO> saveHospitalInfo(@Valid HospitalInfo hospitalInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(hospitalInfoService, hospitalInfo);
    }

    @ApiOperation(value = "更新HospitalInfo", notes = "更新HospitalInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "HospitalInfo", value = "HospitalInfo JSON对象", required = true, dataType = "HospitalInfo"),
    })
    @PutMapping("/")
    public ResponseEntity<ResultVO> updateHospitalInfo(@Valid HospitalInfo hospitalInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(hospitalInfoService, hospitalInfo);
    }
}
