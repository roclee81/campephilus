package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.HospitalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/info/hospital")
@Slf4j
public class HospitalInfoController extends BaseController<HospitalInfo> {

    private final HospitalInfoService hospitalInfoService;

    @Autowired
    public HospitalInfoController(HospitalInfoService hospitalInfoService) {
        this.hospitalInfoService = hospitalInfoService;
    }


    @Override
    protected CrudService<HospitalInfo> getCrudService() {
        return hospitalInfoService;
    }

}