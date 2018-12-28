package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientIdOperationNumberDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
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
public interface PatientIdOperationNumberService {

    /**
     * 通过患者的ID查询PatientIdOperationNumberDO信息
     *
     * @param patientId 患者的ID
     * @param pageable  分页信息
     * @return PatientIdOperationNumberDO分页信息
     */
    Page<PatientIdOperationNumberDO> getPatientIdOperationNumberDOSByPatientId(String patientId, Pageable pageable);

    /**
     * 通过手术顺序号查询PatientIdOperationNumberDO信息
     *
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return PatientIdOperationNumberDO分页信息
     */
    Page<PatientIdOperationNumberDO> getPatientIdOperationNumberDOByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * 得到所有的PatientIdOperationNumberDO信息
     *
     * @param pageable 分页信息
     * @return PatientIdOperationNumberDO的分页信息
     */
    Page<PatientIdOperationNumberDO> getAll(Pageable pageable);

    /**
     * 保存PatientIdOperationNumberDO
     *
     * @param patientIdOperationNumberDO PatientIdOperationNumberDO信息
     */
    void savePatientIdOperationNumberDO(PatientIdOperationNumberDO patientIdOperationNumberDO);

    /**
     * 通过ParseDataDTO中的信息解析后得到PatientIdOperationNumberDO来保存信息
     *
     * @param parseDataDTO 初次解析的数据
     * @return 是否保存成功
     */
    boolean savePatientIdOperationNumberDO(ParseDataDTO parseDataDTO);

    /**
     * 统计PatientIdOperationNumberDO表中的记录的条数
     *
     * @return PatientIdOperationNumberDO表中的记录的条数
     */
    Integer countAll();

}
