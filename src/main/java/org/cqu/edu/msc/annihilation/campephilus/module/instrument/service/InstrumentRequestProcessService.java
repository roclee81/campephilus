package org.cqu.edu.msc.annihilation.campephilus.module.instrument.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.form.InstrumentRequestForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ResultDataDTO;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/24 21:39
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 处理上传的数据，通过解析code来判断上传了什么数据
 */
public interface InstrumentRequestProcessService {

    /**
     * 解析并且处理表单信息
     * 处理完成后将返回ResultDataDTO
     *
     * @param instrumentRequestForm 接收到的表单
     * @return 返回的DTO
     */
    ResultDataDTO processInstrumentData(InstrumentRequestForm instrumentRequestForm);

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
