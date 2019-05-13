package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.PatientInfoService;
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

    @GetMapping("/")
    public ResponseEntity<ResultVO> listPatientInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "size", defaultValue = "20") int size) {
        List<PatientInfo> searchResult = patientInfoService.listAllPatientInfo(page, size);
        if (searchResult.size() != 0) {
            return new ResponseEntity<>(ResultVO.success(searchResult), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultVO.dataNotExist(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveOperationInfo(@Valid PatientInfo patientInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        patientInfoService.savePatientInfo(patientInfo);
        return new ResponseEntity<>(ResultVO.success(patientInfo), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateOperationInfo(@Valid PatientInfo patientInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        patientInfoService.updatePatientInfo(patientInfo);
        return new ResponseEntity<>(ResultVO.success(patientInfo), HttpStatus.OK);
    }

}
