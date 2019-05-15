package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.HospitalInfoService;
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
@RequestMapping(value = "/hospitalInfo")
@Slf4j
public class HospitalInfoController {

    private final HospitalInfoService hospitalInfoService;

    @Autowired
    public HospitalInfoController(HospitalInfoService hospitalInfoService) {
        this.hospitalInfoService = hospitalInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<ResultVO> listHospitalInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "20") int size) {
        List<HospitalInfo> searchResult = hospitalInfoService.listAllOperationInfo(page, size);
        if (searchResult.size() != 0) {
            return new ResponseEntity<>(ResultVO.success(searchResult), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultVO.dataNotExist(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveHospitalInfo(@Valid HospitalInfo hospitalInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        hospitalInfoService.saveHospitalInfo(hospitalInfo);
        return new ResponseEntity<>(ResultVO.success(hospitalInfo), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateHospitalInfo(@Valid HospitalInfo hospitalInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        hospitalInfoService.updateHospitalInfo(hospitalInfo);
        return new ResponseEntity<>(ResultVO.success(hospitalInfo), HttpStatus.OK);
    }
}