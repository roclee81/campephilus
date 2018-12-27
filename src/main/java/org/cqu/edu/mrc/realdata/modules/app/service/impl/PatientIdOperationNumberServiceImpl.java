package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientIdOperationNumberDO;
import org.cqu.edu.mrc.realdata.modules.app.repository.PatientIdOperationNumberRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.PatientIdOperationNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
public class PatientIdOperationNumberServiceImpl implements PatientIdOperationNumberService {

    private final PatientIdOperationNumberRepository patientIdOperationNumberRepository;

    @Autowired
    public PatientIdOperationNumberServiceImpl(PatientIdOperationNumberRepository patientIdOperationNumberRepository) {
        this.patientIdOperationNumberRepository = patientIdOperationNumberRepository;
    }

    @Override
    public Page<PatientIdOperationNumberDO> getPatientIdOperationNumberDOSByPatientId(Integer patientId, Pageable pageable) {
        return patientIdOperationNumberRepository.findPatientIdOperationNumberDOSByPatientId(patientId, pageable);
    }

    @Override
    public Page<PatientIdOperationNumberDO> getPatientIdOperationNumberDOByOperationNumber(Integer operationNumber, Pageable pageable) {
        return patientIdOperationNumberRepository.findPatientIdOperationNumberDOByOperationNumber(operationNumber, pageable);
    }
}
