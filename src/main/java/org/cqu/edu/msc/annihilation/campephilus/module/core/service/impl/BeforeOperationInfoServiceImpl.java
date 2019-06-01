package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.common.exception.SaveException;
import org.cqu.edu.msc.annihilation.common.utils.ServiceCrudUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.BeforeOperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.BeforeOperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class BeforeOperationInfoServiceImpl implements BeforeOperationInfoService {

    private final BeforeOperationInfoRepository beforeOperationInfoRepository;

    public BeforeOperationInfoServiceImpl(BeforeOperationInfoRepository beforeOperationInfoRepository) {
        this.beforeOperationInfoRepository = beforeOperationInfoRepository;
    }

    @Override
    public void saveBeforeOperationInfo(BeforeOperationInfo beforeOperationInfo) {
        // 首先查询是否存在该条数据，根据AdmissionNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(beforeOperationInfoRepository
                .findBeforeOperationInfoByAdmissionNumber(beforeOperationInfo.getAdmissionNumber()));
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudUtils.saveObjectAndCheckSuccess(beforeOperationInfoRepository, beforeOperationInfo);
    }

    @Override
    public void updateBeforeOperationInfo(BeforeOperationInfo beforeOperationInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudUtils.updateObjectAndCheckSuccess(
                beforeOperationInfoRepository, beforeOperationInfo.getBeforeOperationId(), beforeOperationInfo);
    }

    @Override
    public List<BeforeOperationInfo> listAllBeforeOperationInfo(int page, int size) {
        Page<BeforeOperationInfo> searchResult = beforeOperationInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public BeforeOperationInfo saveBeforeOperationInfoFromDataDTO(ParseDataDTO parseDataDTO) {
        PatientInfo parsePatientInfo = ParseJsonUtil.parseJsonString(parseDataDTO, PatientInfo.class, "patientInfo");
        BeforeOperationInfo parseObject = ParseJsonUtil.parseJsonString(parseDataDTO, BeforeOperationInfo.class, "beforeOperationInfo");
        parseObject.setAdmissionNumber(parsePatientInfo.getAdmissionNumber());
        this.saveBeforeOperationInfo(parseObject);
        return parseObject;
    }

    @Override
    public void save(BeforeOperationInfo beforeOperationInfo) {
        this.saveBeforeOperationInfo(beforeOperationInfo);
    }

    @Override
    public void update(BeforeOperationInfo beforeOperationInfo) {
        this.updateBeforeOperationInfo(beforeOperationInfo);
    }

    @Override
    public List<BeforeOperationInfo> listAll(int page, int size) {
        return this.listAllBeforeOperationInfo(page, size);
    }

    @Override
    public void delete(BeforeOperationInfo beforeOperationInfo) {

    }
}
