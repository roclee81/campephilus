package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.PearlcareYy106Data;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.PearlcareYy106DataRepository;
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
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_DATA_PEARLCAREYY106)
@Service
public class PearlcareYy106DataSaveServiceImpl implements DataSaveService {

    @Autowired
    private PearlcareYy106DataRepository pearlcareYy106DataRepository;

    @Override
    public void save(Object pearlcareYy106Data) {
        ServiceCrudCheckUtils.saveObjectAndCheckSuccess(
                 pearlcareYy106DataRepository, (PearlcareYy106Data) pearlcareYy106Data);
    }
}