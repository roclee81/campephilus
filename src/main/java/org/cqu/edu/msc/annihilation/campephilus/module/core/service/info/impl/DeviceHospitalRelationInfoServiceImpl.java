package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.DeviceHospitalRelationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.DeviceHospitalRelationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_DEVICE_HOSPITAL_RELATION)
@Service
public class DeviceHospitalRelationInfoServiceImpl implements DeviceHospitalRelationInfoService {

    @Autowired
    private DeviceHospitalRelationInfoRepository repository;
}
