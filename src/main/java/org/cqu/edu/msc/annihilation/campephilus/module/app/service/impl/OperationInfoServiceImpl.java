package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.OperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.OperationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:05
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class OperationInfoServiceImpl implements OperationInfoService {

    private final OperationInfoRepository operationInfoRepository;

    @Autowired
    public OperationInfoServiceImpl(OperationInfoRepository operationInfoRepository) {
        this.operationInfoRepository = operationInfoRepository;
    }

    @Override
    public synchronized void saveOperationInfo(OperationInfo operationInfo) {
        Optional searchResult = operationInfoRepository.findById(operationInfo.getOperationId());
        if (searchResult.isPresent()) {
            return;
        }
        OperationInfo result = operationInfoRepository.save(operationInfo);
        SaveException.checkSaveSuccess(result, operationInfo);
    }
}
