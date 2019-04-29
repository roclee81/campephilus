package org.cqu.edu.msc.annihilation.campephilus.module.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.DeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.DeviceInfoService;
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

    @GetMapping("/list")
    public ResultVO listDeviceInfo(@RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "20") int size) {
        List<DeviceInfo> searchResult = deviceInfoService.listAllDeviceInfo(page, size);
        return searchResult.size() == 0 ? ResultVO.dataNotExist() :
                new ResultVO(ResponseEnum.SUCCESS.getCode(), searchResult);
    }

    @PostMapping(value = "/update")
    public ResultVO updateDeviceInfo(@Valid DeviceInfo deviceInfo, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);
        deviceInfoService.saveDeviceInfo(deviceInfo);
        return ResultVO.success();
    }
}
