package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.LogInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.LogInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.LogInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 16:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class LogInfoServiceImpl implements LogInfoService {

    private final LogInfoRepository logInfoRepository;

    public LogInfoServiceImpl(LogInfoRepository logInfoRepository) {
        this.logInfoRepository = logInfoRepository;
    }

    @Override
    public void save(LogInfo logInfo) {
        ServiceCrudUtils.saveObjectAndCheckSuccess(logInfoRepository, logInfo);
    }

    @Override
    public void update(LogInfo logInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudUtils.updateObjectAndCheckSuccess(logInfoRepository, logInfo.getId(), logInfo);
    }

    @Override
    public List<LogInfo> listAll(int page, int size) {
        Page<LogInfo> searchResult = logInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void delete(LogInfo logInfo) {

    }
}
