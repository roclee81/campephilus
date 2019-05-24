package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.DeviceInfoService;
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
 * @date 2019/4/29 15:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/deviceInfo")
@Slf4j
public class DeviceInfoController {

    private final DeviceInfoService deviceInfoService;

    @Autowired
    public DeviceInfoController(DeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }

    @ApiOperation(value = "查询DeviceInfo", notes = "查询数据库中DeviceInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码从0开始", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页显示的个数", required = true, dataType = "int")
    })
    @GetMapping("/")
    public ResponseEntity<ResultVO> listDeviceInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                                   @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerListUtils.listAllResultVOResponseEntity(deviceInfoService.listAllDeviceInfo(page, size));
    }

    @ApiOperation(value = "上传DeviceInfo", notes = "上传DeviceInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "DeviceInfo", value = "DeviceInfo JSON对象", required = true, dataType = "DeviceInfo"),
    })
    @PostMapping("/")
    public ResponseEntity<ResultVO> saveDeviceInfo(@Valid DeviceInfo deviceInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerSaveUtils.saveResultVOResponseEntity(deviceInfoService, deviceInfo);
    }

    @ApiOperation(value = "更新DeviceInfo", notes = "更新DeviceInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "DeviceInfo", value = "DeviceInfo JSON对象", required = true, dataType = "DeviceInfo"),
    })
    @PutMapping("/")
    public ResponseEntity<ResultVO> updateDeviceInfo(@Valid DeviceInfo deviceInfo, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return ControllerUpdateUtils.updateResultVOResponseEntity(deviceInfoService, deviceInfo);
    }
}
