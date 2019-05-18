package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.PatientInfoCRUDService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerListUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerSaveUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerUpdateUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
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

    private final PatientInfoCRUDService patientInfoService;

    @Autowired
    public PatientInfoController(PatientInfoCRUDService patientInfoService) {
        this.patientInfoService = patientInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<ResultVO> listPatientInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(patientInfoService.listAllPatientInfo(page, size));
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveOperationInfo(@Valid PatientInfo patientInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(patientInfoService, patientInfo);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateOperationInfo(@Valid PatientInfo patientInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(patientInfoService, patientInfo);
    }

}
