package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.AfterOperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AfterOperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:54
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class AfterOperationInfoServiceImpl implements AfterOperationInfoService {

    private final AfterOperationInfoRepository afterOperationInfoRepository;

    @Autowired
    public AfterOperationInfoServiceImpl(AfterOperationInfoRepository afterOperationInfoRepository) {
        this.afterOperationInfoRepository = afterOperationInfoRepository;
    }

    private Integer getId(AfterOperationInfo afterOperationInfo) {
        return afterOperationInfo.getId();
    }

    @CacheEvict(allEntries = true)
    @Override
    public synchronized AfterOperationInfo save(AfterOperationInfo t) {
        // 首先查询是否存在该条数据
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(afterOperationInfoRepository.findById(getId(t)).orElse(null));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(afterOperationInfoRepository, t);
    }

    @CacheEvict(allEntries = true)
    @Override
    public synchronized void update(AfterOperationInfo t) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(afterOperationInfoRepository, getId(t), t);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void delete(AfterOperationInfo t) {
        // TODO
    }

    @Override
    public List<AfterOperationInfo> listById(Object id) {
        return null;
    }

    @Override
    public List<AfterOperationInfo> listAll(int page, int size) {
        Page<AfterOperationInfo> searchResult = afterOperationInfoRepository.findAll(PageRequest.of(page, size));
        return ConvertUtils.convertObjectTimeStamp(searchResult.getContent());
    }

    @Override
    public long countAll() {
        return afterOperationInfoRepository.count();
    }
}
