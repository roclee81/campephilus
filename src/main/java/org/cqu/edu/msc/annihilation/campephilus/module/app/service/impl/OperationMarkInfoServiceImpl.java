package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.OperationMarkInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.OperationMarkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class OperationMarkInfoServiceImpl implements OperationMarkInfoService {

    private final OperationMarkInfoRepository operationMarkInfoRepository;

    @Autowired
    public OperationMarkInfoServiceImpl(OperationMarkInfoRepository operationMarkInfoRepository) {
        this.operationMarkInfoRepository = operationMarkInfoRepository;
    }

    @Override
    public void saveOperationMarkInfo(OperationMarkInfo operationMarkInfo) {
        // Id自动设置，不存在重复，所以不需要检查
        OperationMarkInfo result = operationMarkInfoRepository.save(operationMarkInfo);
        SaveException.checkSaveSuccess(result, operationMarkInfo);
    }
}
