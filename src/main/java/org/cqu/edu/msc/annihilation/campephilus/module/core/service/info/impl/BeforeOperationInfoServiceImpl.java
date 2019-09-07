package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.BeforeOperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.BeforeOperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
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
public class BeforeOperationInfoServiceImpl extends AbstractInfoService<BeforeOperationInfo, Integer> implements BeforeOperationInfoService {

    private final BeforeOperationInfoRepository beforeOperationInfoRepository;

    @Autowired
    public BeforeOperationInfoServiceImpl(BeforeOperationInfoRepository beforeOperationInfoRepository) {
        this.beforeOperationInfoRepository = beforeOperationInfoRepository;
    }

    @Override
    public JpaRepository<BeforeOperationInfo, Integer> getJpaRepository() {
        return beforeOperationInfoRepository;
    }

    @Override
    protected Integer getId(BeforeOperationInfo beforeOperationInfo) {
        return beforeOperationInfo.getId();
    }

    @CacheEvict(allEntries = true)
    @Override
    public BeforeOperationInfo save(BeforeOperationInfo beforeOperationInfo) {
        // 首先查询是否存在该条数据
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(beforeOperationInfoRepository.findByAdmissionNumber(beforeOperationInfo.getAdmissionNumber()));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(getJpaRepository(), beforeOperationInfo);
    }

    @Override
    public BeforeOperationInfo saveBeforeOperationInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        PatientInfo parsePatientInfo = ParseJsonUtil.parseClassName2JsonString(instrumentForm, PatientInfo.class);
        BeforeOperationInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, BeforeOperationInfo.class);
        parseObject.setAdmissionNumber(parsePatientInfo.getAdmissionNumber());
        return this.save(parseObject);
    }

    /**
     * 通过T中的数据查询数据库中完整的字段
     *
     * @param beforeOperationInfo 泛型
     * @return 数据库中完整的字段
     */
    @Override
    public BeforeOperationInfo getDataBaseEntity(BeforeOperationInfo beforeOperationInfo) {
        return beforeOperationInfoRepository.findByAdmissionNumber(beforeOperationInfo.getAdmissionNumber());
    }
}
