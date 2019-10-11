package org.cqu.edu.msc.annihilation.campephilus.module.sys.log.service.log.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.sys.log.entity.SystemLog;
import org.cqu.edu.msc.annihilation.campephilus.module.sys.log.repository.log.SystemLogRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.sys.log.service.log.SystemLogService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/10/11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private SystemLogRepository systemLogRepository;


    @Override
    public void save(SystemLog systemLog) {
        ServiceCrudCheckUtils.saveObjectAndCheckSuccess(systemLogRepository, systemLog);
    }

    @Override
    public List<SystemLog> listCurrentDay(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return systemLogRepository.findByGmtCreateAfter(TimeStampUtils.getCurrentDayZeroLocalDateTime(), pageable);
    }

    @Override
    public List<SystemLog> listCurrentDayAndLogLevel(int page, int size, int logLevel) {
        Pageable pageable = PageRequest.of(page, size);
        return systemLogRepository.findByGmtCreateAfterAndLogLevel(TimeStampUtils.getCurrentDayZeroLocalDateTime(), logLevel, pageable);
    }

    @Override
    public List<SystemLog> list(int page, int size) {
        return systemLogRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
