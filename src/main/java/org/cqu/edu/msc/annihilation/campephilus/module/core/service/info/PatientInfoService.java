package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 11:31
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface PatientInfoService {

    /**
     * 保存
     *
     * @param patientInfo
     * @return
     */
    PatientInfo save(PatientInfo patientInfo);

    /**
     * 更新
     *
     * @param patientInfo
     */
    void update(PatientInfo patientInfo);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<PatientInfo> listAll(int page, int size);

    /**
     * 删除
     *
     * @param patientInfo
     */
    void delete(PatientInfo patientInfo);

    /**
     * 统计所有
     *
     * @return
     */
    long countAll();

    /**
     * @param instrumentForm
     * @return
     */
    PatientInfo savePatientInfoFromInstrumentForm(InstrumentForm instrumentForm);
}
