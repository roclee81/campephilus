package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.LogInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.LogInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.LogInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 16:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class LogInfoServiceImpl extends AbstractInfoService<LogInfo, Integer> implements LogInfoService {

    private final LogInfoRepository logInfoRepository;

    public LogInfoServiceImpl(LogInfoRepository logInfoRepository) {
        this.logInfoRepository = logInfoRepository;
    }

    @Override
    public JpaRepository<LogInfo, Integer> getJpaRepository() {
        return logInfoRepository;
    }

    @Override
    protected Integer getId(LogInfo logInfo) {
        return logInfo.getId();
    }

    @Override
    public void save(LogInfo logInfo) {
        ServiceCrudUtils.saveObjectAndCheckSuccess(logInfoRepository, logInfo);
    }

    @Override
    public void saveLogInfoFromInstrumentFrom(InstrumentForm instrumentForm) {
        LogInfo parseObject = ParseJsonUtil.parseJsonString(instrumentForm, LogInfo.class);
        this.save(parseObject);
    }

    @Override
    public long countAll() {
        return getJpaRepository().count();
    }
}
