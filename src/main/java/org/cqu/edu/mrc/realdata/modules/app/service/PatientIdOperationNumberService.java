package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientIdOperationNumberDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 22:44
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface PatientIdOperationNumberService{

    /**
     *
     * @param patientId
     * @param pageable
     * @return
     */
    Page<PatientIdOperationNumberDO> getPatientIdOperationNumberDOSByPatientId(Integer patientId, Pageable pageable);

    /**
     *
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<PatientIdOperationNumberDO> getPatientIdOperationNumberDOByOperationNumber(Integer operationNumber, Pageable pageable);
}
