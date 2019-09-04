package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationMarkInfoService {

    /**
     * 保存
     *
     * @param operationMarkInfo
     */
    OperationMarkInfo save(OperationMarkInfo operationMarkInfo);

    /**
     * 更新
     *
     * @param operationMarkInfo
     */
    void update(OperationMarkInfo operationMarkInfo);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<OperationMarkInfo> listAll(int page, int size);

    /**
     * 删除
     *
     * @param operationMarkInfo
     */
    void delete(OperationMarkInfo operationMarkInfo);

    long countAll();

    void saveOperationMarkInfoFromInstrumentForm(InstrumentForm instrumentForm);

    /**
     * @param operationNumber
     * @return
     */
    List<OperationMarkInfo> listByOperationNumber(int operationNumber);

    /**
     * @param id
     */
    void delete(int id);
}
