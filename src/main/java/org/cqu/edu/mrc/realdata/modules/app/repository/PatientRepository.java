package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/11 17:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface PatientRepository extends MongoRepository<PatientDO, String> {

    /**
     *
     * @param patientId
     * @return
     */
    PatientDO findPatientDOByPatientId(String patientId);
}
