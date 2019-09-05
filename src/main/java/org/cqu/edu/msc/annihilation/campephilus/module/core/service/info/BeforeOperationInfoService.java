package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface BeforeOperationInfoService {

    /**
     * 保存
     *
     * @param beforeOperationInfo
     */
    BeforeOperationInfo save(BeforeOperationInfo beforeOperationInfo);

    /**
     * 更新
     *
     * @param beforeOperationInfo
     */
    void update(BeforeOperationInfo beforeOperationInfo);

    List<BeforeOperationInfo> listById(Object id);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<BeforeOperationInfo> listAll(int page, int size);

    /**
     * 删除
     *
     * @param beforeOperationInfo
     */
    void delete(BeforeOperationInfo beforeOperationInfo);

    long countAll();

    BeforeOperationInfo saveBeforeOperationInfoFromInstrumentForm(InstrumentForm instrumentForm);
}