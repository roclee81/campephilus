package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.DeviceHospitalRelationInfoService;
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

    private final DeviceHospitalRelationInfoService deviceHospitalRelationInfoService;

    public DeviceHospitalRelationInfoController(DeviceHospitalRelationInfoService deviceHospitalRelationInfoService) {
        this.deviceHospitalRelationInfoService = deviceHospitalRelationInfoService;
    }

    @ApiOperation(value = "查询DeviceHospitalRelationInfo", notes = "查询数据库中DeviceHospitalRelationInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码从0开始", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页显示的个数", required = true, dataType = "int")
    })
    @GetMapping("/")
    public ResponseEntity<ResultVO> listDeviceHospitalRelationInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                   @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(deviceHospitalRelationInfoService.listAllDeviceHospitalRelationInfo(page, size));
    }

    @ApiOperation(value = "上传DeviceHospitalRelationInfo", notes = "上传DeviceHospitalRelationInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "DeviceHospitalRelationInfo", value = "DeviceHospitalRelationInfo JSON对象", required = true, dataType = "DeviceHospitalRelationInfo"),
    })
    @PostMapping("/")
    public ResponseEntity<ResultVO> saveDeviceHospitalRelationInfo(@Valid DeviceHospitalRelationInfo deviceHospitalRelationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(deviceHospitalRelationInfoService, deviceHospitalRelationInfo);
    }

    @ApiOperation(value = "更新DeviceHospitalRelationInfo", notes = "更新DeviceHospitalRelationInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "DeviceHospitalRelationInfo", value = "DeviceHospitalRelationInfo JSON对象", required = true, dataType = "DeviceHospitalRelationInfo"),
    })
    @PutMapping("/")
    public ResponseEntity<ResultVO> updateDeviceHospitalRelationInfo(@Valid DeviceHospitalRelationInfo deviceHospitalRelationInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(deviceHospitalRelationInfoService, deviceHospitalRelationInfo);
    }
}
