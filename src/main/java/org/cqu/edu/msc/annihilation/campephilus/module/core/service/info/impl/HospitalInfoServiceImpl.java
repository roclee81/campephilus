package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.HospitalInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.HospitalInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_HOSPITAL)
@Service
public class HospitalInfoServiceImpl implements HospitalInfoService {

    private final HospitalInfoRepository hospitalInfoRepository;

    @Autowired
    public HospitalInfoServiceImpl(HospitalInfoRepository hospitalInfoRepository) {
        this.hospitalInfoRepository = hospitalInfoRepository;
    }

    private String getId(HospitalInfo hospitalInfo) {
        return hospitalInfo.getHospitalCode();
    }

    @CacheEvict(allEntries = true)
    @Override
    public synchronized HospitalInfo save(HospitalInfo t) {
        // 首先查询是否存在该条数据
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(hospitalInfoRepository.findById(getId(t)).orElse(null));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(hospitalInfoRepository, t);
    }

    @CacheEvict(allEntries = true)
    @Override
    public synchronized void update(HospitalInfo t) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(hospitalInfoRepository, getId(t), t);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void delete(HospitalInfo t) {
        // TODO 查询
    }

    @Override
    public List<HospitalInfo> listById(Object id) {
        return null;
    }

    @Override
    public List<HospitalInfo> listAll(int page, int size) {
        Page<HospitalInfo> searchResult = hospitalInfoRepository.findAll(PageRequest.of(page, size));
        return ConvertUtils.convertObjectTimeStamp(searchResult.getContent());
    }

    @Override
    public long countAll() {
        return hospitalInfoRepository.count();
    }

}
