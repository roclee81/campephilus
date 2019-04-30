package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.OperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.OperationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
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
        checkId(operationInfo);
        Optional searchResult = operationInfoRepository.findById(operationInfo.getOperationId());
        if (searchResult.isPresent()) {
            return;
        }
        OperationInfo result = operationInfoRepository.save(operationInfo);
        SaveException.checkSaveSuccess(result, operationInfo);
    }

    @Override
    public List<OperationInfo> listAllOperationInfo(int page, int size) {
        Page<OperationInfo> searchResult = operationInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void updateOperationInfo(OperationInfo operationInfo) {
        checkId(operationInfo);
        Optional searchResult = operationInfoRepository.findById(operationInfo.getOperationId());
        if (searchResult.isEmpty()) {
            throw new SaveException(ResponseEnum.UPDATE_ID_ERROR);
        }
        OperationInfo result = operationInfoRepository.save(operationInfo);
        SaveException.checkSaveSuccess(result, operationInfo);
    }

    private void checkId(OperationInfo operationInfo) {
        if (null == operationInfo.getOperationId()) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR);
        }
    }

}
