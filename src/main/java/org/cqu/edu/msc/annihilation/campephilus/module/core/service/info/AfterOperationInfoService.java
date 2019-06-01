package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:50
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface AfterOperationInfoService extends CrudService<AfterOperationInfo> {
    void saveAfterOperationInfo(AfterOperationInfo afterOperationInfo);

    void updateAfterOperationInfo(AfterOperationInfo afterOperationInfo);

    List<AfterOperationInfo> listAllAfterOperationInfo(int page, int size);
}
