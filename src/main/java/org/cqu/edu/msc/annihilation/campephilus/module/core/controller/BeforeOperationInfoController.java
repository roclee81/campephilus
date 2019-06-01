package org.cqu.edu.msc.annihilation.campephilus.module.core.controller;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.BeforeOperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/17 12:59
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/beforeOperationInfo")
public class BeforeOperationInfoController extends BaseController<BeforeOperationInfo>{

    private final BeforeOperationInfoService beforeOperationInfoService;

    public BeforeOperationInfoController(BeforeOperationInfoService beforeOperationInfoService) {
        this.beforeOperationInfoService = beforeOperationInfoService;
    }

    @Override
    CrudService<BeforeOperationInfo> getCrudService() {
        return beforeOperationInfoService;
    }
}
