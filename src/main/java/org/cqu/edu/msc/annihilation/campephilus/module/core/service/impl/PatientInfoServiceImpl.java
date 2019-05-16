package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.PatientInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.PatientInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:12
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class PatientInfoServiceImpl implements PatientInfoService {

    private final PatientInfoRepository patientInfoRepository;

    @Autowired
    public PatientInfoServiceImpl(PatientInfoRepository patientInfoRepository) {
        this.patientInfoRepository = patientInfoRepository;
    }

    @Override
    public synchronized void savePatientInfo(PatientInfo patientInfo) {
        checkId(patientInfo);
        // 首先查询是否存在该条数据，根据patientId和admissionNumber查询
        PatientInfo searchResult = patientInfoRepository.findPatientInfoByPatientIdAndAdmissionNumber(
                patientInfo.getPatientId(), patientInfo.getAdmissionNumber());
        if (null != searchResult) {
            return;
        }
        PatientInfo result = patientInfoRepository.save(patientInfo);
        SaveException.checkSaveSuccess(result, patientInfo);
    }

    @Override
    public List<PatientInfo> listAllPatientInfo(int page, int size) {
        Page<PatientInfo> searchResult = patientInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public synchronized void updatePatientInfo(PatientInfo patientInfo) {
        // 首先查询是否存在该条数据，根据patientId和admissionNumber查询
        PatientInfo searchResult = patientInfoRepository.findPatientInfoByPatientIdAndAdmissionNumber(
                patientInfo.getPatientId(), patientInfo.getAdmissionNumber());
        if (null == searchResult) {
            throw new SaveException(ResponseEnum.UPDATE_ID_ERROR);
        }
        PatientInfo result = patientInfoRepository.save(patientInfo);
        SaveException.checkSaveSuccess(result, patientInfo);
    }

    @Override
    public void savePatientInfoFromParseDataDTO(ParseDataDTO parseDataDTO) {
        PatientInfo parseObject = ParseJsonUtil.parseJsonString(parseDataDTO, PatientInfo.class);
        this.savePatientInfo(parseObject);
    }

    private void checkId(PatientInfo patientInfo) {
        if (null == patientInfo.getAdmissionNumber() || null == patientInfo.getId()) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR);
        }
    }
}
