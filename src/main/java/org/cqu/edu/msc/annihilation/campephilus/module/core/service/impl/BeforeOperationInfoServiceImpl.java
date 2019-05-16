package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
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
        BeforeOperationInfo searchResult = beforeOperationInfoRepository
                .findBeforeOperationInfoByAdmissionNumber(beforeOperationInfo.getAdmissionNumber());
        if (null != searchResult) {
            // 判断到存在该仪器存在，则直接返回，不抛出异常
            return;
        }
        BeforeOperationInfo result = null;
        try {
            result = beforeOperationInfoRepository.save(beforeOperationInfo);
        } catch (Exception e) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, e.toString(), result.toString());
        }
        SaveException.checkSaveSuccess(result, beforeOperationInfo);
    }

    @Override
    public void updateBeforeOperationInfo(BeforeOperationInfo beforeOperationInfo) {
        // 检查beforeOperationInfo的AdmissionNumber来判断是否是更新数据，同时判断是否存在该AdmissionNumber的数据
        Integer id = beforeOperationInfo.getBeforeOperationId();
        if (null == id || beforeOperationInfoRepository.findById(id).isEmpty()) {
            throw new SaveException(ResponseEnum.UPDATE_ID_ERROR);
        }
        BeforeOperationInfo result;
        try {
            result = beforeOperationInfoRepository.save(beforeOperationInfo);
        } catch (Exception e) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR);
        }
        SaveException.checkSaveSuccess(result, beforeOperationInfo);
    }

    @Override
    public List<BeforeOperationInfo> listAllBeforeOperationInfo(int page, int size) {
        Page<BeforeOperationInfo> searchResult = beforeOperationInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void saveBeforeOperationInfoFromDataDTO(ParseDataDTO parseDataDTO) {
        PatientInfo parsePatientInfo = ParseJsonUtil.parseJsonString(parseDataDTO, PatientInfo.class, "patientInfo");
        BeforeOperationInfo parseObject = ParseJsonUtil.parseJsonString(parseDataDTO, BeforeOperationInfo.class, "beforeOperationInfo");
        parseObject.setAdmissionNumber(parsePatientInfo.getAdmissionNumber());
        this.saveBeforeOperationInfo(parseObject);
    }
}
