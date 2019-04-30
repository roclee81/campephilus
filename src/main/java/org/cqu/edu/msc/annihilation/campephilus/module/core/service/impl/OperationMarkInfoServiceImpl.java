package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dataobject.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.OperationMarkInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationMarkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
        // Id自动设置，不存在重复，所以不需要检查，不需要锁
        OperationMarkInfo result = operationMarkInfoRepository.save(operationMarkInfo);
        SaveException.checkSaveSuccess(result, operationMarkInfo);
    }

    @Override
    public List<OperationMarkInfo> listAllOperationMarkInfo(int page, int size) {
        Page<OperationMarkInfo> searchResult = operationMarkInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void updateOperationMarkInfo(OperationMarkInfo operationMarkInfo) {
        // 检查operationMarkInfo的id来判断是否是更新数据，同时判断是否存在该id的数据
        Integer id = operationMarkInfo.getMarkId();
        if (null == id || operationMarkInfoRepository.findById(id).isEmpty()) {
            throw new SaveException(ResponseEnum.UPDATE_ID_ERROR);
        }
        OperationMarkInfo result = operationMarkInfoRepository.save(operationMarkInfo);
        SaveException.checkSaveSuccess(result, operationMarkInfo);
    }
}
