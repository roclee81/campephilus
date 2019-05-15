package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.AfterOperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.AfterOperationInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:54
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class AfterOperationInfoServiceImpl implements AfterOperationInfoService {

    private final AfterOperationInfoRepository afterOperationInfoRepository;

    public AfterOperationInfoServiceImpl(AfterOperationInfoRepository afterOperationInfoRepository) {
        this.afterOperationInfoRepository = afterOperationInfoRepository;
    }

    @Override
    public void saveAfterOperationInfo(AfterOperationInfo afterOperationInfo) {
        // 首先查询是否存在该条数据，根据AdmissionNumber查询
        AfterOperationInfo searchResult = afterOperationInfoRepository
                .findAfterOperationInfoByAdmissionNumber(afterOperationInfo.getAdmissionNumber());
        if (null != searchResult) {
            // 判断到存在该仪器存在，则直接返回，不抛出异常
            return;
        }
        AfterOperationInfo result = afterOperationInfoRepository.save(afterOperationInfo);
        SaveException.checkSaveSuccess(result, afterOperationInfo);
    }

    @Override
    public void updateAfterOperationInfo(AfterOperationInfo afterOperationInfo) {
        // 检查afterOperationInfo的AdmissionNumber来判断是否是更新数据，同时判断是否存在该AdmissionNumber的数据
        Integer id = afterOperationInfo.getAfterOperationId();
        if (null == id || afterOperationInfoRepository.findById(id).isEmpty()) {
            throw new SaveException(ResponseEnum.UPDATE_ID_ERROR);
        }
        AfterOperationInfo result = afterOperationInfoRepository.save(afterOperationInfo);
        SaveException.checkSaveSuccess(result, afterOperationInfo);
    }

    @Override
    public List<AfterOperationInfo> listAllAfterOperationInfo(int page, int size) {
        Page<AfterOperationInfo> searchResult = afterOperationInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }
}
