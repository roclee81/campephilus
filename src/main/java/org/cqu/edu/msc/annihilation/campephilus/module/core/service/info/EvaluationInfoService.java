package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info.EvaluationInfoDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.EvaluationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;

import java.util.List;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/9/17
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface EvaluationInfoService extends CrudService<EvaluationInfo> {

    /**
     * 查询所有的EvaluationInfo
     * 同时封装成EvaluationInfoDTO
     *
     * @param page
     * @param size
     * @return
     */
    List<EvaluationInfoDTO> listEvaluationInfoDTO(int page, int size);

    /**
     * 接续instrumentForm数据并保存数据
     *
     * @param instrumentForm
     */
    void saveEvaluationInfoFromInstrumentForm(InstrumentForm instrumentForm);
}
