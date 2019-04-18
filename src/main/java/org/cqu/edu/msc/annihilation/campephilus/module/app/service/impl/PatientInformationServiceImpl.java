package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.PatientInformationRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.PatientInformationDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.PatientInformationService;
import org.cqu.edu.msc.annihilation.common.utils.BeanUtil;
import org.cqu.edu.msc.annihilation.common.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/9 0:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
@Slf4j
public class PatientInformationServiceImpl implements PatientInformationService {

    private final PatientInformationRepository patientInformationRepository;

    @Autowired
    public PatientInformationServiceImpl(PatientInformationRepository patientInformationRepository) {
        this.patientInformationRepository = patientInformationRepository;
    }

    @Override
    public PatientInfo getPatientInformationDOByOperationNumber(Integer operationNumber) {
        return patientInformationRepository.findPatientInformationDOByOperationNumber(operationNumber);
    }

    @Override
    public PatientInformationDTO getPatientInformationDTOByOperationNumber(Integer operationNumber) {
        PatientInfo patientInfo = this.getPatientInformationDOByOperationNumber(operationNumber);
        return ConvertUtil.convert(patientInfo,PatientInformationDTO.class);
    }

    @Override
    public PatientInfo getPatientInformationDOByPatientIdAndOperationNumber(String patientId, Integer operationNumber) {
        PatientInfo result;
        try {
            result = patientInformationRepository.findPatientInformationDOByPatientIdAndOperationNumber(patientId, operationNumber);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
        return result;
    }

    @Override
    public PatientInformationDTO getPatientInformationDTOByPatientIdAndOperationNumber(String patientId, Integer operationNumber) {
        PatientInfo patientInfo = this.getPatientInformationDOByPatientIdAndOperationNumber(patientId, operationNumber);
        return ConvertUtil.convert(patientInfo,PatientInformationDTO.class);
    }

    @Override
    public Page<PatientInfo> listPatientInformationDOSByPatientId(String patientId, Pageable pageable) {
        return patientInformationRepository.findPatientInformationDOSByPatientId(patientId, pageable);
    }

    @Override
    public List<PatientInformationDTO> listPatientInformationDTOSByPatientId(String patientId, Pageable pageable) {
        Page<PatientInfo> patientInformationDOPage = this.listPatientInformationDOSByPatientId(patientId, pageable);
        return ConvertUtil.convert(patientInformationDOPage,PatientInformationDTO.class);
    }

    @Override
    public boolean savePatientInformationDO(PatientInfo patientInfo) {
        // 首先查询是否存在该条数据，根据operationNumber查询
        PatientInfo searchResult = this.getPatientInformationDOByOperationNumber(patientInfo.getOperationNumber());
        if (null != searchResult) {
            if (null == patientInfo.getId() || !patientInfo.getId().equals(searchResult.getId())) {
                throw new SaveException(ResponseEnum.DATA_EXISTED);
            }
        }
        PatientInfo result = patientInformationRepository.savePatientInformationDO(patientInfo);
        SaveException.checkSaveSuccess(result, patientInfo);
        return true;
    }

    @Override
    public boolean savePatientInformationDO(ParseDataDTO parseDataDTO) {
        PatientInfo parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, PatientInfo.class);
        if (null == parseResult) {
            return false;
        }

        if (null == parseResult.getPatientId() || null == parseResult.getPatientData() || null == parseResult.getPreoperativeData()) {
            return false;
        }

        parseResult.setDataState(Boolean.TRUE);
        return this.savePatientInformationDO(parseResult);
    }

    @Override
    public boolean updatePatientInformationDO(ParseDataDTO parseDataDTO) {
        PatientInfo parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, PatientInfo.class);
        if (null == parseResult) {
            return false;
        }

        PatientInfo searchResult = this.getPatientInformationDOByPatientIdAndOperationNumber(parseResult.getPatientId(), parseResult.getOperationNumber());

        if (null == searchResult) {
            return false;
        }

        // 如果数据状态处于结束，就不允许更改了
        if (searchResult.getDataState().equals(Boolean.FALSE)) {
            throw new SaveException(ResponseEnum.DATA_STATE_FINISHED);
        }

        // 重新设定该条数据修改时间
        BeanUtil.copyPropertiesTargetNotNull(parseResult, searchResult);
        searchResult.setGmtModified(new Date());
        searchResult.setDataState(Boolean.FALSE);
        return this.savePatientInformationDO(searchResult);
    }
}
