package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PreoperativePatientDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:46
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface PreoperativePatientRepository extends MongoRepository<PreoperativePatientDO, String> {

    /**
     * 通过患者的ID得到PreoperativePatientDO信息
     *
     * @param patientId 患者ID
     * @param pageable  分页信息
     * @return PreoperativePatientDO分页信息
     */
    Page<PreoperativePatientDO> findPreoperativePatientDOSByPatientId(String patientId, Pageable pageable);


}
