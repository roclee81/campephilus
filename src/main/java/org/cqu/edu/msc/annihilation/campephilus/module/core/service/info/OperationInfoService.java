package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
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
public interface OperationInfoService {

    /**
     * 保存
     *
     * @param operationInfo
     * @return
     */
    OperationInfo save(OperationInfo operationInfo);

    /**
     * 更新
     *
     * @param operationInfo
     */
    void update(OperationInfo operationInfo);

    List<OperationInfo> listById(Object id);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<OperationInfo> listAll(int page, int size);

    /**
     * 删除
     *
     * @param operationInfo
     */
    void delete(OperationInfo operationInfo);

    long countAll();

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
