package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info.OperationMarkInfoDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationMarkInfoService extends CrudService<OperationMarkInfo> {
    void saveOperationMarkInfoFromInstrumentForm(InstrumentForm instrumentForm);

    List<OperationMarkInfoDTO> listOperationMarkInfoDTO(int page, int size);

    List<OperationMarkInfoDTO> listOperationMarkInfoDTOByOperationNumber(int operationNumber);

    ResponseEnum saveList(InstrumentForm instrumentForm);
}
