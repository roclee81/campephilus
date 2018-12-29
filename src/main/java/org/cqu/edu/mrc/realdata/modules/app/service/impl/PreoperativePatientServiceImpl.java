package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.PreoperativePatientDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.repository.PreoperativePatientRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.PreoperativePatientService;
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
 * @date 2018/12/26 16:46
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
@Slf4j
public class PreoperativePatientServiceImpl implements PreoperativePatientService {

    private final PreoperativePatientRepository preoperativePatientRepository;

    @Autowired
    public PreoperativePatientServiceImpl(PreoperativePatientRepository preoperativePatientRepository) {
        this.preoperativePatientRepository = preoperativePatientRepository;
    }

    @Override
    public void savePreoperativePatientDO(PreoperativePatientDO preoperativePatientDO) {
        preoperativePatientRepository.save(preoperativePatientDO);
    }

    @Override
    public Page<PreoperativePatientDO> getPreoperativePatientDOSByPatientId(String patientId, Pageable pageable) {
        return preoperativePatientRepository.findPreoperativePatientDOSByPatientId(patientId, pageable);
    }

    @Override
    public boolean savePreoperativePatientDO(ParseDataDTO parseDataDTO) {
        if (null == parseDataDTO) {
            return false;
        }

        Map dataMap = parseDataDTO.getDataMap();
        int operationNumber = parseDataDTO.getOperationNumber();

        Map patientData;
        String patientId;
        try {
            // 检查是否有patientId,没有直接返回false
            if (dataMap.containsKey(DataConstants.PATIENT_ID)) {
                patientId = (String) dataMap.get(DataConstants.PATIENT_ID);
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

        PreoperativePatientDO preoperativePatientDO = new PreoperativePatientDO(patientId, parseDataDTO.getMacAddress(), operationNumber, new Date(), 0, null, patientData);
        this.savePreoperativePatientDO(preoperativePatientDO);
        log.info("Insert the success :{}", preoperativePatientDO.toString());
        return true;
    }
}
