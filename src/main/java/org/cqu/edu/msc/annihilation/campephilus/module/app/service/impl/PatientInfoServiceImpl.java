package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.PatientInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class PatientInfoServiceImpl implements PatientInfoService {

    private final PatientInfoRepository patientInfoRepository;

    @Autowired
    public PatientInfoServiceImpl(PatientInfoRepository patientInfoRepository) {
        this.patientInfoRepository = patientInfoRepository;
    }

    @Override
    public synchronized void savePatientInfo(PatientInfo patientInfo) {
        // 首先查询是否存在该条数据，根据patientId和admissionNumber查询
        PatientInfo searchResult = patientInfoRepository.findPatientInfoByPatientIdAndAdmissionNumber(
                patientInfo.getPatientId(), patientInfo.getAdmissionNumber());
        if (null != searchResult) {
            return;
        }
        PatientInfo result = patientInfoRepository.save(patientInfo);
        SaveException.checkSaveSuccess(result, patientInfo);
    }

    @Override
    public List<PatientInfo> listAllPatientInfo(int page, int size) {
        Page<PatientInfo> searchResult = patientInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }
}
