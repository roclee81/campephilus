package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.AfterOperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.AfterOperationInfoCRUDService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ServiceSaveUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ServiceUpdateUtils;
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
public class AfterOperationInfoCRUDServiceImpl implements AfterOperationInfoCRUDService {

    private final AfterOperationInfoRepository afterOperationInfoRepository;

    public AfterOperationInfoCRUDServiceImpl(AfterOperationInfoRepository afterOperationInfoRepository) {
        this.afterOperationInfoRepository = afterOperationInfoRepository;
    }

    @Override
    public void saveAfterOperationInfo(AfterOperationInfo afterOperationInfo) {
        // 首先查询是否存在该条数据，根据AdmissionNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(afterOperationInfoRepository
                .findAfterOperationInfoByAdmissionNumber(afterOperationInfo.getAdmissionNumber()));
        // 判断保存是否成功，不成功将抛出异常
        ServiceSaveUtils.saveObjectAndCheckSuccess(afterOperationInfoRepository, afterOperationInfo);
    }

    @Override
    public void updateAfterOperationInfo(AfterOperationInfo afterOperationInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceUpdateUtils.updateObjectAndCheckSuccess(
                afterOperationInfoRepository, afterOperationInfo.getAfterOperationId(), afterOperationInfo);
    }

    @Override
    public List<AfterOperationInfo> listAllAfterOperationInfo(int page, int size) {
        Page<AfterOperationInfo> searchResult = afterOperationInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void save(AfterOperationInfo afterOperationInfo) {
        this.saveAfterOperationInfo(afterOperationInfo);
    }

    @Override
    public void update(AfterOperationInfo afterOperationInfo) {
        this.updateAfterOperationInfo(afterOperationInfo);
    }

    @Override
    public List<AfterOperationInfo> listAll(int page, int size) {
        return this.listAllAfterOperationInfo(page, size);
    }

    @Override
    public void delete(AfterOperationInfo afterOperationInfo) {

    }
}
