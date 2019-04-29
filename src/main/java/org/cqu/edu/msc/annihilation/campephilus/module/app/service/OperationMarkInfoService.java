package org.cqu.edu.msc.annihilation.campephilus.module.app.service;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.OperationMarkInfo;

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

    List<OperationMarkInfo> listAllOperationMarkInfo();

    List<OperationMarkInfo> listAllOperationMarkInfo(int page, int size);
}
