package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info.PatientInfoDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.PatientInfo;
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

    /**
     * 查询所有的PatientInfo
     * 同时封装成PatientInfoDTO
     *
     * @param page
     * @param size
     * @return
     */
    List<PatientInfoDTO> listPatientInfoDTO(int page, int size);

    /**
     * @param instrumentForm
     * @return
     */
    PatientInfo savePatientInfoFromInstrumentForm(InstrumentForm instrumentForm);
}
