package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.DeviceHospitalRelationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ControllerListUtils;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtil;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    private final DeviceHospitalRelationInfoService deviceHospitalRelationInfoService;

    public DeviceHospitalRelationInfoController(DeviceHospitalRelationInfoService deviceHospitalRelationInfoService) {
        this.deviceHospitalRelationInfoService = deviceHospitalRelationInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<ResultVO> listDeviceHospitalRelationInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                   @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.getResultVOResponseEntity(deviceHospitalRelationInfoService.listAllDeviceHospitalRelationInfo(page, size));
    }

    @PostMapping("/")
    public ResponseEntity<ResultVO> saveAfterOperationInfo(@Valid DeviceHospitalRelationInfo deviceHospitalRelationInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        deviceHospitalRelationInfoService.saveDeviceHospitalRelationInfo(deviceHospitalRelationInfo);
        return new ResponseEntity<>(ResultVO.success(deviceHospitalRelationInfo), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ResultVO> updateDeviceInfo(@Valid DeviceHospitalRelationInfo deviceHospitalRelationInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        deviceHospitalRelationInfoService.updateDeviceHospitalRelationInfo(deviceHospitalRelationInfo);
        return new ResponseEntity<>(ResultVO.success(deviceHospitalRelationInfo), HttpStatus.OK);
    }
}
