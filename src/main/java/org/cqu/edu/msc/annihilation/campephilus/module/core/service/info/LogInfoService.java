package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.LogInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 16:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface LogInfoService {

    ResultDTO save(LogInfo t);

    void saveLogInfoFromInstrumentFrom(InstrumentForm instrumentForm);
}
