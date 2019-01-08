package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientInformationDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.PatientInformationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/9 0:02
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface PatientInformationService {

    /**
     * 通过患者的ID得到PatientInformationDO信息
     *
     * @param patientId 患者ID
     * @param pageable  分页信息
     * @return PatientInformationDO分页信息
     */
    Page<PatientInformationDO> getPatientInformationDOSByPatientId(String patientId, Pageable pageable);

    /**
     * 通过患者的ID得到PatientInformationDTO信息
     *
     * @param patientId 患者ID
     * @param pageable  分页信息
     * @return PatientInformationDTO列表
     */
    List<PatientInformationDTO> getPatientInformationDTOSByPatientId(String patientId, Pageable pageable);

    /**
     * 保存PatientInformationDO信息
     *
     * @param patientInformationDO patientInformationDO实体
     */
    void savePostoperativePatientDO(PatientInformationDO patientInformationDO);

    /**
     * 通过ParseDataDTO中的信息解析后得到PatientInformationDO来保存信息
     *
     * @param parseDataDTO 初次解析的数据
     * @return 是否保存成功
     */
    boolean savePatientInformationDO(ParseDataDTO parseDataDTO);
}
