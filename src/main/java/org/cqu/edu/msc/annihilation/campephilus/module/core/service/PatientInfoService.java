package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dataobject.info.PatientInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 11:31
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface PatientInfoService {

    void savePatientInfo(PatientInfo patientInfo);

    List<PatientInfo> listAllPatientInfo(int page, int size);

    void updatePatientInfo(PatientInfo patientInfo);
}
