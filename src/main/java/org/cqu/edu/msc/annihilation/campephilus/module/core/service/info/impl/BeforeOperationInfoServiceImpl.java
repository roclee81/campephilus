package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.BeforeOperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.BeforeOperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_BEFORE_OPERATION)
@Service
public class BeforeOperationInfoServiceImpl implements BeforeOperationInfoService {

    @Autowired
    private BeforeOperationInfoRepository repository;

    @Override
    public ResultDTO saveBeforeOperationInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        PatientInfo parsePatientInfo = ParseJsonUtil.parseClassName2JsonString(instrumentForm, PatientInfo.class);
        BeforeOperationInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, BeforeOperationInfo.class);
        parseObject.setAdmissionNumber(parsePatientInfo.getAdmissionNumber());
        return save(parseObject);
    }

    @CacheEvict(allEntries = true)
    @Override
    public ResultDTO save(BeforeOperationInfo t) {
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, t);
    }

    @Override
    public ResultDTO delete(BeforeOperationInfo t) {
        return ServiceCrudCheckUtils.deleteObjectAndCheck(repository, t);
    }

    @Override
    public ResultDTO update(BeforeOperationInfo t) {
        return ServiceCrudCheckUtils.updateObjectAndCheck(repository, t);
    }
}
