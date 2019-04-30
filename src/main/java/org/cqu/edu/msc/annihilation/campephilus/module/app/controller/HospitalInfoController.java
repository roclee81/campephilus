package org.cqu.edu.msc.annihilation.campephilus.module.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.HospitalInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.app.vo.ResultVO;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/list")
    public ResultVO listHospitalInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "size", defaultValue = "20") int size) {
        List<HospitalInfo> searchResult = hospitalInfoService.listAllOperationInfo(page, size);
        return searchResult.size() == 0 ? ResultVO.dataNotExist() :
                new ResultVO(ResponseEnum.SUCCESS.getCode(), searchResult);
    }

    @PostMapping(value = "/save")
    public ResultVO saveHospitalInfo(@Valid HospitalInfo hospitalInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        hospitalInfoService.saveHospitalInfo(hospitalInfo);
        return ResultVO.success();
    }

    @PostMapping(value = "/update")
    public ResultVO updateHospitalInfo(@Valid HospitalInfo hospitalInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        hospitalInfoService.updateHospitalInfo(hospitalInfo);
        return ResultVO.success();
    }
}
