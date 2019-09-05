package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.LogInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 16:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface LogInfoService {

    /**
     * 保存
     *
     * @param logInfo
     */
    LogInfo save(LogInfo logInfo);

    /**
     * 更新
     *
     * @param logInfo
     */
    void update(LogInfo logInfo);

    List<LogInfo> listById(Object id);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<LogInfo> listAll(int page, int size);

    /**
     * 删除
     *
     * @param logInfo
     */
    void delete(LogInfo logInfo);

    long countAll();

    void saveLogInfoFromInstrumentFrom(InstrumentForm instrumentForm);
}
