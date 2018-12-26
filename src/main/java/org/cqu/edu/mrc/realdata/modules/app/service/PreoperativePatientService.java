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
     *
     * @param preoperativePatientDO
     */
    void savePreoperativePatientDO(PreoperativePatientDO preoperativePatientDO);

    /**
     *
     * @param patientId
     * @param pageable
     * @return
     */
    Page<PreoperativePatientDO> getPreoperativePatientDOSByPatientId(String patientId, Pageable pageable);

    /**
     *
     * @param parseDataDTO
     * @return
     */
    boolean savePreoperativePatientDO(ParseDataDTO parseDataDTO);
}
