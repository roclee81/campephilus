package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.PatientInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.PatientInfoService;
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

    private final PatientInfoRepository patientInfoRepository;

    @Autowired
    public PatientInfoServiceImpl(PatientInfoRepository patientInfoRepository) {
        this.patientInfoRepository = patientInfoRepository;
    }

    @Override
    public void savePatientInfo(PatientInfo patientInfo) {
        //
    }
}
