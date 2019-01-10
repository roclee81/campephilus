package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientInformationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 21:46
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface PatientInformationRepository {

    /**
     * 通过operationNumber得到PatientInformationDO
     * 结果是唯一的
     *
     * @param operationNumber 手术顺序号
     * @return PatientInformationDO实体
     */
    PatientInformationDO findPatientInformationDOByOperationNumber(Integer operationNumber);

    /**
     * 通过patientId和operationNumber得到PatientInformationDO
     * 结果是唯一的
     *
     * @param patientId       患者ID
     * @param operationNumber 手术顺序号
     * @return PatientInformationDO实体
     */
    PatientInformationDO findPatientInformationDOByPatientIdAndOperationNumber(String patientId, Integer operationNumber);

    /**
     * 通过患者的ID得到PatientInformationDO信息
     *
     * @param patientId 患者ID
     * @param pageable  分页信息
     * @return PatientInformationDO分页信息
     */
    Page<PatientInformationDO> findPatientInformationDOSByPatientId(String patientId, Pageable pageable);

    /**
     * 保存 PatientInformationDO实体
     *
     * @param patientInformationDO PatientInformationDO实体
     */
    void savePatientInformationDO(PatientInformationDO patientInformationDO);
}
