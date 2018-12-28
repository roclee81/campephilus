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
     * 通过患者的ID查询PatientIdOperationNumberDO信息
     *
     * @param patientId 患者的ID
     * @param pageable  分页信息
     * @return PatientIdOperationNumberDO分页信息
     */
    Page<PatientIdOperationNumberDO> findPatientIdOperationNumberDOSByPatientId(String patientId, Pageable pageable);

    /**
     * 通过手术顺序号查询PatientIdOperationNumberDO信息
     *
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return PatientIdOperationNumberDO分页信息
     */
    Page<PatientIdOperationNumberDO> findPatientIdOperationNumberDOByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * 得到所有的PatientIdOperationNumberDO信息
     *
     * @param pageable 分页信息
     * @return PatientIdOperationNumberDO分页信息
     */
    Page<PatientIdOperationNumberDO> findAll(Pageable pageable);

    /**
     * 保存PatientIdOperationNumberDO
     *
     * @param patientIdOperationNumberDO PatientIdOperationNumberDO信息
     */
    void savePatientIdOperationNumberDO(PatientIdOperationNumberDO patientIdOperationNumberDO);

    /**
     * 统计PatientIdOperationNumberDO表中的记录的条数
     *
     * @return PatientIdOperationNumberDO表中的记录的条数
     */
    Integer countAll();
}
