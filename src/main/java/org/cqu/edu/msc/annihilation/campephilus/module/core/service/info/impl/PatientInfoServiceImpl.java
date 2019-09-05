package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.PatientInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.PatientInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
@Service
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_PATIENT)
public class PatientInfoServiceImpl implements PatientInfoService {

    private final PatientInfoRepository patientInfoRepository;

    @Autowired
    public PatientInfoServiceImpl(PatientInfoRepository patientInfoRepository) {
        this.patientInfoRepository = patientInfoRepository;
    }

    @CacheEvict(allEntries = true)
    @Override
    public PatientInfo savePatientInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        PatientInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, PatientInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        return this.save(parseObject);
    }

    @Override
    public PatientInfo save(PatientInfo patientInfo) {
        // 首先查询是否存在该条数据，根据admissionNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(patientInfoRepository.findByAdmissionNumber(
                patientInfo.getAdmissionNumber()));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(patientInfoRepository, patientInfo);
    }

    @CacheEvict(allEntries = true)
    @Override
    public synchronized void update(PatientInfo patientInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(
                patientInfoRepository, patientInfo.getId(), patientInfo);
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @Override
    public List<PatientInfo> listAll(int page, int size) {
        Page<PatientInfo> searchResult = patientInfoRepository.findAll(PageRequest.of(page, size));
        return ConvertUtils.convertObjectTimeStamp(searchResult.getContent());
    }

    @CacheEvict(allEntries = true)
    @Override
    public void delete(PatientInfo patientInfo) {
        // 判断t是否为null，同时查询t是否存在在数据库中，如果存在则删除
        if (Objects.nonNull(patientInfo) && Objects.nonNull(patientInfo = getDataBaseEntity(patientInfo))) {
            patientInfoRepository.delete(patientInfo);
            // TODO 打印需不需要提取出来
            log.info("delete:{}", patientInfo.toString());
        }
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @Override
    public long countAll() {
        return patientInfoRepository.count();
    }

    /**
     * 通过PatientInfo中的数据查询数据库中完整的字段
     *
     * @param patientInfo 泛型
     * @return 数据库中完整的字段
     */
    private PatientInfo getDataBaseEntity(PatientInfo patientInfo) {
        return patientInfoRepository.findByAdmissionNumber(patientInfo.getAdmissionNumber());
    }
}
