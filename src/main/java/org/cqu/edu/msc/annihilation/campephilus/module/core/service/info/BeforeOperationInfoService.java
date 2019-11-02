package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface BeforeOperationInfoService {
    ResultDTO saveBeforeOperationInfoFromInstrumentForm(InstrumentForm instrumentForm);

    ResultDTO save(BeforeOperationInfo t);

    ResultDTO delete(BeforeOperationInfo t);

    ResultDTO update(BeforeOperationInfo t);
}