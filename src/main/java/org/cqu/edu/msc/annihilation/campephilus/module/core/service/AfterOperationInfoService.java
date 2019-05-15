package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:50
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface AfterOperationInfoService {
    void saveAfterOperationInfo(AfterOperationInfo afterOperationInfo);

    void updateAfterOperationInfo(AfterOperationInfo afterOperationInfo);

    List<AfterOperationInfo> listAllAfterOperationInfo(int page, int size);
}
