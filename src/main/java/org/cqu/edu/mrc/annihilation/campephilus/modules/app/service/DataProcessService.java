package org.cqu.edu.mrc.annihilation.campephilus.modules.app.service;

import org.cqu.edu.mrc.annihilation.campephilus.modules.app.form.MedicalDataForm;
import org.cqu.edu.mrc.annihilation.campephilus.modules.app.dto.ResultDataDTO;

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
     * 处理完成后将返回ResultDataDTO
     *
     * @param medicalDataForm 接收到的表单
     * @return 返回的DTO
     */
    ResultDataDTO processMedicalData(MedicalDataForm medicalDataForm);

    /**
     * 得到新的手术顺序号
     * 根据operationInformation表计算得到表
     *
     * @return 下一个新的手术顺序号
     */
    Integer getNewOperationNumber();

    /**
     * 得到当前的手术顺序号
     * 根据operationInformation表计算得到表
     *
     * @return 当前的手术顺序号
     */
    Integer getCurrentOperationNumber();

}
