package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientIdOperationNumberDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.repository.PatientIdOperationNumberRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.PatientIdOperationNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/26 20:59
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
@Slf4j
public class PatientIdOperationNumberServiceImpl implements PatientIdOperationNumberService {

    private final PatientIdOperationNumberRepository patientIdOperationNumberRepository;

    @Autowired
    public PatientIdOperationNumberServiceImpl(PatientIdOperationNumberRepository patientIdOperationNumberRepository) {
        this.patientIdOperationNumberRepository = patientIdOperationNumberRepository;
    }

    @Override
    public Page<PatientIdOperationNumberDO> getPatientIdOperationNumberDOSByPatientId(String patientId, Pageable pageable) {
        return patientIdOperationNumberRepository.findPatientIdOperationNumberDOSByPatientId(patientId, pageable);
    }

    @Override
    public Page<PatientIdOperationNumberDO> getPatientIdOperationNumberDOByOperationNumber(Integer operationNumber, Pageable pageable) {
        return patientIdOperationNumberRepository.findPatientIdOperationNumberDOByOperationNumber(operationNumber, pageable);
    }

    @Override
    public Page<PatientIdOperationNumberDO> getAll(Pageable pageable) {
        return patientIdOperationNumberRepository.findAll(pageable);
    }

    @Override
    public void savePatientIdOperationNumberDO(PatientIdOperationNumberDO patientIdOperationNumberDO) {
        patientIdOperationNumberRepository.savePatientIdOperationNumberDO(patientIdOperationNumberDO);
    }

    @Override
    public boolean savePatientIdOperationNumberDO(ParseDataDTO parseDataDTO) {
        if (null == parseDataDTO) {
            return false;
        }

        Map dataMap = parseDataDTO.getDataMap();
        int operationNumber = parseDataDTO.getOperationNumber();

        String patientId;
        try {
            // 检查是否有deviceId,没有直接返回false
            if (dataMap.containsKey(DataConstants.PATIENT_ID)) {
                patientId = (String) dataMap.get(DataConstants.PATIENT_ID);
            } else {
                return false;
            }
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            log.error("ParseDataDTO:{},Exception:{}", parseDataDTO.toString(), exception.toString());
            return false;
        }

        PatientIdOperationNumberDO patientIdOperationNumberDO = new PatientIdOperationNumberDO(patientId, new Date(), operationNumber);
        this.savePatientIdOperationNumberDO(patientIdOperationNumberDO);
        return true;
    }

    @Override
    public Integer countAll() {
        return patientIdOperationNumberRepository.countAll();
    }

}
