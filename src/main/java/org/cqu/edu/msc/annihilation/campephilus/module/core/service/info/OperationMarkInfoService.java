package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationMarkInfoService {

    ResultDTO save(OperationMarkInfo t);

    void saveOperationMarkInfoFromInstrumentForm(InstrumentForm instrumentForm);

    ResultDTO list(int page, int size);

    List<OperationMarkInfo> listOperationMarkInfoDTOByOperationNumber(int operationNumber);

    ResultDTO saveList(InstrumentForm instrumentForm);
}
