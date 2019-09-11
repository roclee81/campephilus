package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.Norwamd9002sData;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.Norwamd9002sDataRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.DataSaveService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/9
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_DATA_NORWAMD9002S)
@Service
public class Norwamd9002sDataSaveServiceImpl implements DataSaveService {

    @Autowired
    private Norwamd9002sDataRepository norwamd9002sDataRepository;

    @Override
    public void save(Object norwamd9002sData) {
        ServiceCrudCheckUtils.saveObjectAndCheckSuccess(norwamd9002sDataRepository, (Norwamd9002sData) norwamd9002sData);
    }
}