package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.LogInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.LogInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.LogInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 16:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_LOG)
@Service
public class LogInfoServiceImpl implements LogInfoService {

    private final LogInfoRepository logInfoRepository;

    @Autowired
    public LogInfoServiceImpl(LogInfoRepository logInfoRepository) {
        this.logInfoRepository = logInfoRepository;
    }

    private Integer getId(LogInfo logInfo) {
        return logInfo.getId();
    }

    @CacheEvict(allEntries = true)
    @Override
    public LogInfo save(LogInfo logInfo) {
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(logInfoRepository, logInfo);
    }

    @Override
    public void saveLogInfoFromInstrumentFrom(InstrumentForm instrumentForm) {
        LogInfo parseObject = ParseJsonUtil.parseJsonString(instrumentForm, LogInfo.class);
        this.save(parseObject);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void update(LogInfo t) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(logInfoRepository, getId(t), t);
    }

    /**
     * 通过T中的数据查询数据库中完整的字段
     *
     * @param t 泛型
     * @return 数据库中完整的字段
     */
    private LogInfo getDataBaseEntity(LogInfo t) {
        return null;
    }

    @CacheEvict(allEntries = true)
    @Override
    public void delete(LogInfo t) {
        // 判断t是否为null，同时查询t是否存在在数据库中，如果存在则删除
        if (Objects.nonNull(t) && Objects.nonNull(t = getDataBaseEntity(t))) {
            logInfoRepository.delete(t);
            // TODO 打印需不需要提取出来
            log.info("delete:{}", t.toString());
        }
    }

    @Override
    public List<LogInfo> listById(Object id) {
        return null;
    }

    @Override
    public List<LogInfo> listAll(int page, int size) {
        Page<LogInfo> searchResult = logInfoRepository.findAll(PageRequest.of(page, size));
        return ConvertUtils.convertObjectTimeStamp(searchResult.getContent());
    }

    @Override
    public long countAll() {
        return logInfoRepository.count();
    }


}
