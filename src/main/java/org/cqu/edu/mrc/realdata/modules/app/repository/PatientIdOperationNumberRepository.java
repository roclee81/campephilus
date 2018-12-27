package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientIdOperationNumberDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
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
public interface PatientIdOperationNumberRepository {

    /**
     * @param patientId
     * @param pageable
     * @return
     */
    Page<PatientIdOperationNumberDO> findPatientIdOperationNumberDOSByPatientId(String patientId, Pageable pageable);

    /**
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<PatientIdOperationNumberDO> findPatientIdOperationNumberDOByOperationNumber(Integer operationNumber, Pageable pageable);


    /**
     * @param patientIdOperationNumberDO
     */
    void savePatientIdOperationNumberDO(PatientIdOperationNumberDO patientIdOperationNumberDO);


    /**
     * 查询表中的所有数据
     *
     * @param pageable 分页信息
     * @return
     */
    Page<PatientIdOperationNumberDO> findAll(Pageable pageable);

    /**
     * @return
     */
    Integer countAll();
}
