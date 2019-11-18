package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.PatientInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.PatientInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class PatientInfoServiceImpl implements PatientInfoService {

    @Autowired
    private PatientInfoRepository repository;

    @Override
    public ResultDTO save(PatientInfo patientInfo) {
        // 首先查询是否存在该条数据，根据admissionNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(repository
                .findByAdmissionNumber(patientInfo.getAdmissionNumber()));
        return ServiceCrudCheckUtils.saveObjectAndCheck(
                repository, patientInfo);
    }

    @Override
    public ResultDTO update(PatientInfo patientInfo) {
        return ServiceCrudCheckUtils.updateObjectAndCheck(
                repository, patientInfo);
    }

    @Override
    public ResultDTO delete(PatientInfo t) {
        return ServiceCrudCheckUtils.deleteObjectAndCheck(repository, t);
    }

    @Override
    public ResultDTO savePatientInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        PatientInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, PatientInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        return save(parseObject);
    }
}
