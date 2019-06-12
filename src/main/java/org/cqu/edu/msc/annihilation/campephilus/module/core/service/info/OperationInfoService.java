package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationInfoService extends CrudService<OperationInfo> {

    void saveOperationInfoFromInstrumentForm(InstrumentForm instrumentForm);

    Integer countOperationInfo();

    int getOperationStateByOperationNumber(int operationNumber);

    void updateOperationStartTimeFromInstrumentForm(InstrumentForm instrumentForm);

    void updateOperationEndTimeFromInstrumentForm(InstrumentForm instrumentForm);
}
