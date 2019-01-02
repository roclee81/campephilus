package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.form.MedicalDataForm;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ResultDataDTO;

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
     * 解析并且处理表单信息
     * 处理完成后将返回DTO
     *
     * @param medicalDataForm 接收到的表单
     * @return 返回的DTO
     */
    ResultDataDTO processMedicalData(MedicalDataForm medicalDataForm);

}
