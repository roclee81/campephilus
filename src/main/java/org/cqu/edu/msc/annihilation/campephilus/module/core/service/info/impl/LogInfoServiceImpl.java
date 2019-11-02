package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.LogInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.LogInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.LogInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 16:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_LOG)
@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoRepository repository;

    @Override
    public ResultDTO save(LogInfo t) {
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, t);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void saveLogInfoFromInstrumentFrom(InstrumentForm instrumentForm) {
        LogInfo parseObject = ParseJsonUtil.parseJsonString(instrumentForm, LogInfo.class);
        this.save(parseObject);
    }
}
