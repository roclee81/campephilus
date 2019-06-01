package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/operationDeviceInfo")
public class OperationDeviceInfoController extends BaseController<OperationDeviceInfo>{

    private final OperationDeviceInfoService operationDeviceInfoService;

    @Autowired
    public OperationDeviceInfoController(OperationDeviceInfoService operationDeviceInfoService) {
        this.operationDeviceInfoService = operationDeviceInfoService;
    }


    @Override
    CrudService<OperationDeviceInfo> getCrudService() {
        return operationDeviceInfoService;
    }

}
