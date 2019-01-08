package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.modules.app.convertor.PatientInformationDOConvertPatientInformationDTO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientInformationDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.PatientInformationDTO;
import org.cqu.edu.mrc.realdata.modules.app.repository.PatientInformationRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.PatientInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * realdata
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
    public Page<PatientInformationDO> getPatientInformationDOSByPatientId(String patientId, Pageable pageable) {
        return patientInformationRepository.findPatientInformationDOSByPatientId(patientId, pageable);
    }

    @Override
    public List<PatientInformationDTO> getPatientInformationDTOSByPatientId(String patientId, Pageable pageable) {
        Page<PatientInformationDO> patientInformationDOPage = this.getPatientInformationDOSByPatientId(patientId, pageable);
        return PatientInformationDOConvertPatientInformationDTO.convert(patientInformationDOPage);
    }

    @Override
    public void savePostoperativePatientDO(PatientInformationDO patientInformationDO) {
        patientInformationRepository.savePatientInformationDO(patientInformationDO);
    }

    @Override
    public boolean savePatientInformationDO(ParseDataDTO parseDataDTO) {
        //TODO 未完成，需要先查询数据，再存储
        if (null == parseDataDTO) {
            return false;
        }

        Map dataMap = parseDataDTO.getDataMap();
        int operationNumber = parseDataDTO.getOperationNumber();

        Map patientData;
        String patientId;
        Map data;
        try {
            // 检查是否有patientId,没有直接返回false
            if (dataMap.containsKey(DataConstants.PATIENT_ID)) {
                patientId = (String) dataMap.get(DataConstants.PATIENT_ID);
            } else {
                return false;
            }

            // 检查是否有data,没有直接返回false
            if (dataMap.containsKey(DataConstants.DATA_MAP)) {
                data = (Map) dataMap.get(DataConstants.DATA_MAP);
            } else {
                return false;
            }

            // 检查是否有patientData,没有直接返回false
            if (dataMap.containsKey(DataConstants.PATIENT_DATA)) {
                patientData = (Map) dataMap.get(DataConstants.PATIENT_DATA);
            } else {
                return false;
            }
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            log.error("ParseDataDTO:{},Exception:{}", parseDataDTO.toString(), exception.toString());
            return false;
        }

        PatientInformationDO patientInformationDO = new PatientInformationDO(patientId, operationNumber, 0, new HashMap(), new HashMap(), new HashMap(), new Date(), new Date());
        this.savePostoperativePatientDO(patientInformationDO);
        log.info("Insert the success :{}", patientInformationDO.toString());
        return true;
    }
}
