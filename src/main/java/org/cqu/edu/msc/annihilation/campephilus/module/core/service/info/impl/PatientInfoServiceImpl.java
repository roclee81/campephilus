package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.PatientInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.PatientInfoService;
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
        // 首先查询是否存在该条数据，根据patientId和admissionNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(patientInfoRepository.findPatientInfoByAdmissionNumber(
                patientInfo.getAdmissionNumber()));
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudUtils.saveObjectAndCheckSuccess(patientInfoRepository, patientInfo);
    }

    @Override
    public List<PatientInfo> listAllPatientInfo(int page, int size) {
        Page<PatientInfo> searchResult = patientInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public synchronized void updatePatientInfo(PatientInfo patientInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudUtils.updateObjectAndCheckSuccess(
                patientInfoRepository, patientInfo.getAdmissionNumber(), patientInfo);
    }

    @Override
    public void savePatientInfoFromParseDataDTO(ParseDataDTO parseDataDTO) {
        PatientInfo parseObject = ParseJsonUtil.parseJsonString(parseDataDTO, PatientInfo.class, "patientInfo");
        parseObject.setOperationNumber(parseDataDTO.getOperationNumber());
        this.savePatientInfo(parseObject);
    }

    @Override
    public void save(PatientInfo patientInfo) {
        this.savePatientInfo(patientInfo);
    }

    @Override
    public void update(PatientInfo patientInfo) {
        this.updatePatientInfo(patientInfo);
    }

    @Override
    public List<PatientInfo> listAll(int page, int size) {
        return this.listAllPatientInfo(page, size);
    }

    @Override
    public void delete(PatientInfo patientInfo) {

    }
}
