package org.cqu.edu.mrc.realdata.modules.app.service;


import org.cqu.edu.mrc.realdata.modules.app.dataobject.PreoperativePatientDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:46
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface PreoperativePatientService {

    /**
     * 通过患者的ID得到PreoperativePatientDO信息
     *
     * @param patientId 患者ID
     * @param pageable  分页信息
     * @return PreoperativePatientDO分页信息
     */
    Page<PreoperativePatientDO> getPreoperativePatientDOSByPatientId(String patientId, Pageable pageable);

    /**
     * 保存PreoperativePatientDO信息
     *
     * @param preoperativePatientDO PreoperativePatientDO实体
     */
    void savePreoperativePatientDO(PreoperativePatientDO preoperativePatientDO);

    /**
     * 通过ParseDataDTO中的信息解析后得到PreoperativePatientDO来保存信息
     *
     * @param parseDataDTO 初次解析的数据
     * @return 是否保存成功
     */
    boolean savePreoperativePatientDO(ParseDataDTO parseDataDTO);
}
