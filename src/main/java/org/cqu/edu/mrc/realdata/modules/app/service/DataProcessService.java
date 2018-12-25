package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.common.utils.R;
import org.cqu.edu.mrc.realdata.modules.app.dto.MedicalDataDTO;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/24 21:39
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface DataProcessService {

    /**
     * 仅解析JSON数据，如果数据有错误，则返回null
     *
     * @param jsonBuffer JSON 字符串
     * @return MedicalDataDTO实体类
     */
    MedicalDataDTO parseJson(String jsonBuffer);

    /**
     *
     * @param medicalDataDTO
     * @return
     */
    Integer processCode(MedicalDataDTO medicalDataDTO);

}
