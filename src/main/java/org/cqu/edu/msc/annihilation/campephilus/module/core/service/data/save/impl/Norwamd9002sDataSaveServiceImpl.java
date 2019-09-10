package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.DataSaveService;
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

    @Override
    public void save(Object norwamd9002sData) {

    }
}