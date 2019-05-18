package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.DeviceHospitalRelationInfoCRUDService;
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
 * @date 2019/5/17 13:01
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/deviceHospitalRelationInfo")
public class DeviceHospitalRelationInfoController {

    private final DeviceHospitalRelationInfoCRUDService deviceHospitalRelationInfoService;

    public DeviceHospitalRelationInfoController(DeviceHospitalRelationInfoCRUDService deviceHospitalRelationInfoService) {
        this.deviceHospitalRelationInfoService = deviceHospitalRelationInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<ResultVO> listDeviceHospitalRelationInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                   @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(deviceHospitalRelationInfoService.listAllDeviceHospitalRelationInfo(page, size));
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveAfterOperationInfo(@Valid DeviceHospitalRelationInfo deviceHospitalRelationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(deviceHospitalRelationInfoService, deviceHospitalRelationInfo);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateDeviceInfo(@Valid DeviceHospitalRelationInfo deviceHospitalRelationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(deviceHospitalRelationInfoService, deviceHospitalRelationInfo);
    }
}
