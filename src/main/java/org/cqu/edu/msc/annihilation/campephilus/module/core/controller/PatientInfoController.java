package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.PatientInfoService;
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
 * @date 2019/4/29 11:31
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/patientInfo")
@Slf4j
public class PatientInfoController {

    private final PatientInfoService patientInfoService;

    @Autowired
    public PatientInfoController(PatientInfoService patientInfoService) {
        this.patientInfoService = patientInfoService;
    }

    @ApiOperation(value = "查询PatientInfo", notes = "查询数据库中PatientInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码从0开始", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页显示的个数", required = true, dataType = "int")
    })
    @GetMapping("/")
    public ResponseEntity<ResultVO> listPatientInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(patientInfoService.listAllPatientInfo(page, size));
    }

    @ApiOperation(value = "上传PatientInfo", notes = "上传PatientInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "PatientInfo", value = "PatientInfo JSON对象", required = true, dataType = "PatientInfo"),
    })
    @PostMapping("/")
    public ResponseEntity<ResultVO> savePatientInfo(@Valid PatientInfo patientInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(patientInfoService, patientInfo);
    }

    @ApiOperation(value = "更新PatientInfo", notes = "更新PatientInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "PatientInfo", value = "PatientInfo JSON对象", required = true, dataType = "PatientInfo"),
    })
    @PutMapping("/")
    public ResponseEntity<ResultVO> updatePatientInfo(@Valid PatientInfo patientInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(patientInfoService, patientInfo);
    }

}
