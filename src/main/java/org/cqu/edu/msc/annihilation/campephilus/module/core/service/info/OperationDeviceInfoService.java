package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:06
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationDeviceInfoService {

    /**
     * 保存
     *
     * @param operationDeviceInfo
     */
    OperationDeviceInfo save(OperationDeviceInfo operationDeviceInfo);

    /**
     * 更新
     *
     * @param operationDeviceInfo
     */
    void update(OperationDeviceInfo operationDeviceInfo);

    List<OperationDeviceInfo> listById(Object id);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<OperationDeviceInfo> listAll(int page, int size);

    /**
     * 删除
     *
     * @param operationDeviceInfo
     */
    void delete(OperationDeviceInfo operationDeviceInfo);

    long countAll();

    OperationDeviceInfo saveOperationDeviceInfoFromInstrumentForm(InstrumentForm instrumentForm);

    OperationDeviceInfo listByOperationNumber(int operationNumber);
}
