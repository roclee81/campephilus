package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 11:31
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface PatientInfoService extends CrudService<PatientInfo> {
    void savePatientInfo(PatientInfo patientInfo);

    List<PatientInfo> listAllPatientInfo(int page, int size);

    void updatePatientInfo(PatientInfo patientInfo);

    void savePatientInfoFromInstrumentForm(InstrumentForm instrumentForm);
}
