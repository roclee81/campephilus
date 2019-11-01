package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.AfterOperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AfterOperationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:54
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_AFTER_OPERATION)
@Service
public class AfterOperationInfoServiceImpl implements AfterOperationInfoService {

    @Autowired
    private AfterOperationInfoRepository afterOperationInfoRepository;
}
