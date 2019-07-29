package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.PatientInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.PatientInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class PatientInfoServiceImpl extends AbstractInfoService<PatientInfo, Integer> implements PatientInfoService {

    private final PatientInfoRepository patientInfoRepository;

    @Autowired
    public PatientInfoServiceImpl(PatientInfoRepository patientInfoRepository) {
        this.patientInfoRepository = patientInfoRepository;
    }

    @Override
    public JpaRepository<PatientInfo, Integer> getJpaRepository() {
        return patientInfoRepository;
    }

    @Override
    protected Integer getId(PatientInfo patientInfo) {
        return patientInfo.getId();
    }

    @Override
    public PatientInfo savePatientInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        PatientInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, PatientInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        return this.save(parseObject);
    }

    @Override
    public synchronized PatientInfo save(PatientInfo patientInfo) {
        // 首先查询是否存在该条数据，根据admissionNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(patientInfoRepository.findByAdmissionNumber(
                patientInfo.getAdmissionNumber()));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(patientInfoRepository, patientInfo);
    }

    @Override
    public synchronized void update(PatientInfo patientInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(
                patientInfoRepository, patientInfo.getId(), patientInfo);
    }

    /**
     * 通过T中的数据查询数据库中完整的字段
     *
     * @param patientInfo 泛型
     * @return 数据库中完整的字段
     */
    @Override
    public PatientInfo getDataBaseEntity(PatientInfo patientInfo) {
        return patientInfoRepository.findByAdmissionNumber(patientInfo.getAdmissionNumber());
    }
}
