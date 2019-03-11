package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.form.InstrumentRequestForm;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ResultDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.utils.ParseResultObject;

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

    /**
     * <ul>
     * <li>通过解析Code判断请求方式并回复</li>
     * <li>处理一个大型的分支，目前没有想到有什么其余的方式写该方法
     * 运行到分支后将进行数据存储处理，将返回执行的结果</li>
     * <li>在此处不检查传入参数ParseDataDTO的非空情况，因为在表单
     * 验证后必定不为空</li>
     * </ul>
     *
     * @param parseDataDTO 初次解析的DTO
     * @return 成功为true，失败false
     */
    ParseResultObject processCode(ParseDataDTO parseDataDTO);

}
