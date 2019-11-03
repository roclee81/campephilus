package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.EvaluationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/9/17
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface EvaluationInfoService {

    /**
     * 接续instrumentForm数据并保存数据
     *
     * @param instrumentForm instrumentForm
     */
    void saveEvaluationInfoFromInstrumentForm(InstrumentForm instrumentForm);

    ResultDTO saveList(InstrumentForm instrumentForm);

    ResultDTO save(EvaluationInfo t);

    ResultDTO delete(EvaluationInfo t);

    ResultDTO update(EvaluationInfo t);
}
