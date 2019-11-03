package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 11:31
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface PatientInfoService {

    ResultDTO save(PatientInfo t);

    ResultDTO update(PatientInfo t);

    ResultDTO delete(PatientInfo t);

    /**
     * @param instrumentForm
     * @return
     */
    ResultDTO savePatientInfoFromInstrumentForm(InstrumentForm instrumentForm);
}
