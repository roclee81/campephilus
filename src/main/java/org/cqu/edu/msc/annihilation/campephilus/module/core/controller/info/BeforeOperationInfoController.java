package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.BeforeOperationInfoService;
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
@RequestMapping(value = "/info/beforeOperation")
public class BeforeOperationInfoController extends BaseController<BeforeOperationInfo> {

    private final BeforeOperationInfoService beforeOperationInfoService;

    public BeforeOperationInfoController(BeforeOperationInfoService beforeOperationInfoService) {
        this.beforeOperationInfoService = beforeOperationInfoService;
    }

    @Override
    protected CrudService<BeforeOperationInfo> getCrudService() {
        return beforeOperationInfoService;
    }
}