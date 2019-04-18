package org.cqu.edu.msc.annihilation.campephilus.module.app.service;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.PatientInformationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/9 0:02
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface PatientInformationService {

    /**
     * 通过operationNumber得到PatientInformationDO
     * 结果是唯一的
     *
     * @param operationNumber 手术顺序号
     * @return PatientInformationDO实体
     */
    PatientInfo getPatientInformationDOByOperationNumber(Integer operationNumber);

    /**
     * 通过operationNumber得到PatientInformationDTO
     * 结果是唯一的
     *
     * @param operationNumber 手术顺序号
     * @return PatientInformationDTO实体
     */
    PatientInformationDTO getPatientInformationDTOByOperationNumber(Integer operationNumber);

    /**
     * 通过patientId和operationNumber得到PatientInformationDO
     * 结果是唯一的
     *
     * @param patientId       患者ID
     * @param operationNumber 手术顺序号
     * @return PatientInformationDO实体
     */
    PatientInfo getPatientInformationDOByPatientIdAndOperationNumber(String patientId, Integer operationNumber);

    /**
     * 通过patientId和operationNumber得到PatientInformationDTO
     * 结果是唯一的
     *
     * @param patientId       患者ID
     * @param operationNumber 手术顺序号
     * @return PatientInformationDTO实体
     */
    PatientInformationDTO getPatientInformationDTOByPatientIdAndOperationNumber(String patientId, Integer operationNumber);

    /**
     * 通过患者的ID得到PatientInformationDO信息
     *
     * @param patientId 患者ID
     * @param pageable  分页信息
     * @return PatientInformationDO分页信息
     */
    Page<PatientInfo> listPatientInformationDOSByPatientId(String patientId, Pageable pageable);

    /**
     * 通过患者的ID得到PatientInformationDTO信息
     *
     * @param patientId 患者ID
     * @param pageable  分页信息
     * @return PatientInformationDTO列表
     */
    List<PatientInformationDTO> listPatientInformationDTOSByPatientId(String patientId, Pageable pageable);

    /**
     * 保存PatientInformationDO信息
     *
     * @param patientInfo patientInformationDO实体
     * @return 是否保存成功
     */
    boolean savePatientInformationDO(PatientInfo patientInfo);

    /**
     * 通过ParseDataDTO中的信息解析后得到PatientInformationDO来保存信息
     *
     * @param parseDataDTO 初次解析的数据
     * @return 是否保存成功
     */
    boolean savePatientInformationDO(ParseDataDTO parseDataDTO);

    /**
     * 更新PatientInformationDO信息
     *
     * @param parseDataDTO 初次解析的数据
     * @return 是否保存成功
     */
    boolean updatePatientInformationDO(ParseDataDTO parseDataDTO);
}
