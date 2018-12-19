package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientIdOperationNumberDO;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 22:44
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface PatientIdOperationNumberRepository extends MongoRepository<PatientIdOperationNumberDO, String> {

    /**
     * @param patientId
     * @return
     */
    Page<PatientIdOperationNumberDO> findPatientIdOperationNumberDOSByPatientId(Integer patientId);

    /**
     *
     * @param operationNumber
     * @return
     */
    Page<PatientIdOperationNumberDO> findPatientIdOperationNumberDOSByOperationNumber(Integer operationNumber);
}
