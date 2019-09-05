package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.HospitalInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.HospitalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_HOSPITAL)
@Service
public class HospitalInfoServiceImpl extends AbstractInfoService<HospitalInfo,String> implements HospitalInfoService {

    private final HospitalInfoRepository hospitalInfoRepository;

    @Autowired
    public HospitalInfoServiceImpl(HospitalInfoRepository hospitalInfoRepository) {
        this.hospitalInfoRepository = hospitalInfoRepository;
    }

    @Override
    public JpaRepository<HospitalInfo, String> getJpaRepository() {
        return hospitalInfoRepository;
    }

    @Override
    protected String getId(HospitalInfo hospitalInfo) {
        return hospitalInfo.getHospitalCode();
    }

}
