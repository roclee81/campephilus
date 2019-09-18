package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info.OperationInfoDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;

import java.util.List;
import java.util.Map;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationInfoService extends CrudService<OperationInfo> {

    List<OperationInfoDTO> listOperationInfoDTO(int page, int size);

    OperationInfo saveOperationInfoFromInstrumentForm(InstrumentForm instrumentForm);

    Integer countOperationInfo();

    int getOperationStateByOperationNumber(int operationNumber);

    void updateOperationStartTimeFromInstrumentForm(InstrumentForm instrumentForm);

    void updateOperationEndTimeFromInstrumentForm(InstrumentForm instrumentForm);

    /**
     * 得到当前正在进行的手术的场次号和状态
     * 就是包括未开始的和正在进行的
     *
     * @return Map<Integer, Integer>
     */
    Map<Integer, Integer> getCurrentOperationInfo();
}
