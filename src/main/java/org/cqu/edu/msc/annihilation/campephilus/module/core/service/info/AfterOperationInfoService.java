package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:50
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface AfterOperationInfoService {

    ResultDTO save(AfterOperationInfo t);

    ResultDTO delete(AfterOperationInfo t);

    ResultDTO update(AfterOperationInfo t);
}
