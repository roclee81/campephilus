package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.LogInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.LogInfoService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 16:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/log")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_LOG)
public class LogInfoController extends BaseController<LogInfo> {

    private final LogInfoService logInfoService;

    public LogInfoController(LogInfoService logInfoService) {
        this.logInfoService = logInfoService;
    }

    @Override
    protected CrudService<LogInfo> getCrudService() {
        return logInfoService;
    }
}
