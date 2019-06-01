package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AfterOperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/17 12:56
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */

@RestController
@RequestMapping(value = "/info/afterOperation")
public class AfterOperationInfoController extends BaseController<AfterOperationInfo> {

    private final AfterOperationInfoService afterOperationInfoService;

    public AfterOperationInfoController(AfterOperationInfoService afterOperationInfoService) {
        this.afterOperationInfoService = afterOperationInfoService;
    }

    @Override
    protected CrudService<AfterOperationInfo> getCrudService() {
        return afterOperationInfoService;
    }
}
