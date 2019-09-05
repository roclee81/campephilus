package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.BeforeOperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.BeforeOperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
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
 * @date 2019/5/15 16:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class BeforeOperationInfoServiceImpl implements BeforeOperationInfoService {

    private final BeforeOperationInfoRepository beforeOperationInfoRepository;

    @Autowired
    public BeforeOperationInfoServiceImpl(BeforeOperationInfoRepository beforeOperationInfoRepository) {
        this.beforeOperationInfoRepository = beforeOperationInfoRepository;
    }

    private Integer getId(BeforeOperationInfo beforeOperationInfo) {
        return beforeOperationInfo.getId();
    }

    @CacheEvict(allEntries = true)
    @Override
    public synchronized BeforeOperationInfo save(BeforeOperationInfo beforeOperationInfo) {
        // 首先查询是否存在该条数据
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(beforeOperationInfoRepository.findByAdmissionNumber(beforeOperationInfo.getAdmissionNumber()));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(beforeOperationInfoRepository, beforeOperationInfo);
    }

    @Override
    public BeforeOperationInfo saveBeforeOperationInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        PatientInfo parsePatientInfo = ParseJsonUtil.parseClassName2JsonString(instrumentForm, PatientInfo.class);
        BeforeOperationInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, BeforeOperationInfo.class);
        parseObject.setAdmissionNumber(parsePatientInfo.getAdmissionNumber());
        this.save(parseObject);
        return parseObject;
    }

    /**
     * 通过BeforeOperationInfo中的数据查询数据库中完整的字段
     *
     * @param beforeOperationInfo 泛型
     * @return 数据库中完整的字段
     */
    private BeforeOperationInfo getDataBaseEntity(BeforeOperationInfo beforeOperationInfo) {
        return beforeOperationInfoRepository.findByAdmissionNumber(beforeOperationInfo.getAdmissionNumber());
    }

    @CacheEvict(allEntries = true)
    @Override
    public synchronized void update(BeforeOperationInfo t) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(beforeOperationInfoRepository, getId(t), t);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void delete(BeforeOperationInfo t) {
        // TODO
    }

    @Override
    public List<BeforeOperationInfo> listById(Object id) {
        return null;
    }

    @Override
    public List<BeforeOperationInfo> listAll(int page, int size) {
        Page<BeforeOperationInfo> searchResult = beforeOperationInfoRepository.findAll(PageRequest.of(page, size));
        return ConvertUtils.convertObjectTimeStamp(searchResult.getContent());
    }

    @Override
    public long countAll() {
        return beforeOperationInfoRepository.count();
    }
}
