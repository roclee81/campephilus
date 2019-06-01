package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.DeviceHospitalRelationInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/17 13:01
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/deviceHospitalRelationInfo")
public class DeviceHospitalRelationInfoController extends BaseController<DeviceHospitalRelationInfo>{

    private final DeviceHospitalRelationInfoService deviceHospitalRelationInfoService;

    public DeviceHospitalRelationInfoController(DeviceHospitalRelationInfoService deviceHospitalRelationInfoService) {
        this.deviceHospitalRelationInfoService = deviceHospitalRelationInfoService;
    }

    @Override
    CrudService<DeviceHospitalRelationInfo> getCrudService() {
        return deviceHospitalRelationInfoService;
    }

}
