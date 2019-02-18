package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.convertor.PatientInformationDOConvertPatientInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.PatientInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.PatientInformationRepository;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.PatientInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.service.PatientInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public PatientInformationDO getPatientInformationDOByOperationNumber(Integer operationNumber) {
        return patientInformationRepository.findPatientInformationDOByOperationNumber(operationNumber);
    }

    @Override
    public PatientInformationDTO getPatientInformationDTOByOperationNumber(Integer operationNumber) {
        PatientInformationDO patientInformationDO = this.getPatientInformationDOByOperationNumber(operationNumber);
        return PatientInformationDOConvertPatientInformationDTO.convert(patientInformationDO);
    }

    @Override
    public PatientInformationDO getPatientInformationDOByPatientIdAndOperationNumber(String patientId, Integer operationNumber) {
        return patientInformationRepository.findPatientInformationDOByPatientIdAndOperationNumber(patientId, operationNumber);
    }

    @Override
    public PatientInformationDTO getPatientInformationDTOByPatientIdAndOperationNumber(String patientId, Integer operationNumber) {
        PatientInformationDO patientInformationDO = this.getPatientInformationDOByPatientIdAndOperationNumber(patientId, operationNumber);
        return PatientInformationDOConvertPatientInformationDTO.convert(patientInformationDO);
    }

    @Override
    public Page<PatientInformationDO> listPatientInformationDOSByPatientId(String patientId, Pageable pageable) {
        return patientInformationRepository.findPatientInformationDOSByPatientId(patientId, pageable);
    }

    @Override
    public List<PatientInformationDTO> listPatientInformationDTOSByPatientId(String patientId, Pageable pageable) {
        Page<PatientInformationDO> patientInformationDOPage = this.listPatientInformationDOSByPatientId(patientId, pageable);
        return PatientInformationDOConvertPatientInformationDTO.convert(patientInformationDOPage);
    }

    @Override
    public void savePatientInformationDO(PatientInformationDO patientInformationDO) {
        patientInformationRepository.savePatientInformationDO(patientInformationDO);
    }

    @Override
    public boolean savePatientInformationDO(ParseDataDTO parseDataDTO) {

        Map dataMap = parseDataDTO.getDataMap();
        int operationNumber = parseDataDTO.getOperationNumber();

        Map patientData, preoperativeData, postoperativeData;
        String patientId;
        try {
            // 检查是否有patientId,没有直接返回false
            if (dataMap.containsKey(DataConstants.PATIENT_ID)) {
                patientId = (String) dataMap.get(DataConstants.PATIENT_ID);
            } else {
                return false;
            }
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            log.error("ParseDataDTO:{},Exception:{}", parseDataDTO.toString(), exception.toString());
            return false;
        }

        // 首先查询是否已有该数据
        PatientInformationDO patientInformationDO = this.getPatientInformationDOByPatientIdAndOperationNumber(patientId, operationNumber);

        // 如果不存在则生成部分数据
        if (null == patientInformationDO) {
            try {
                // 检查是否有patientData,没有直接返回false
                if (dataMap.containsKey(DataConstants.PATIENT_DATA)) {
                    patientData = (Map) dataMap.get(DataConstants.PATIENT_DATA);
                } else {
                    return false;
                }

                // 检查是否有preoperativeData，没有直接返回false
                if (dataMap.containsKey(DataConstants.PREOPERATIVE_DATA)) {
                    preoperativeData = (Map) dataMap.get(DataConstants.PREOPERATIVE_DATA);
                } else {
                    return false;
                }
            } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
                log.error("ParseDataDTO:{},Exception:{}", parseDataDTO.toString(), exception.toString());
                return false;
            }

            patientInformationDO = new PatientInformationDO(patientId, operationNumber, 0, preoperativeData, new HashMap(16), patientData, new Date(), new Date());
        } else {
            // 如果存在首先先更新数据更改时间
            patientInformationDO.setGmtModified(new Date());
            try {
                // 检查是否有postoperativeData，没有直接返回false
                if (dataMap.containsKey(DataConstants.POSTOPERATIVE_DATA)) {
                    postoperativeData = (Map) dataMap.get(DataConstants.POSTOPERATIVE_DATA);
                } else {
                    return false;
                }
            } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
                log.error("ParseDataDTO:{},Exception:{}", parseDataDTO.toString(), exception.toString());
                return false;
            }
            patientInformationDO.setPostoperativeData(postoperativeData);
        }

        this.savePatientInformationDO(patientInformationDO);
        log.info("Insert the success :{}", patientInformationDO.toString());
        return true;
    }
}