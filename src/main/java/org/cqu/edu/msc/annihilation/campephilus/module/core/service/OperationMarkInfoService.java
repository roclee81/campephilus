package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationMarkInfoService {

    void saveOperationMarkInfo(OperationMarkInfo operationMarkInfo);

    List<OperationMarkInfo> listAllOperationMarkInfo(int page, int size);

    void updateOperationMarkInfo(OperationMarkInfo operationMarkInfo);
}