package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dto.MedicalDataForm;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;

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
    MedicalDataForm parseJson(String jsonBuffer);

    /**
     * <ul>
     * <li>通过解析Code判断请求方式并回复</li>
     * <li>处理一个大型的分支，目前没有想到有什么其余的方式写该方法</li>
     * <li>目前仅处理在注册后的数据，即形成了mqtt话题后的数据</li>
     * </ul>
     *
     * @param medicalDataForm 接收的DTO
     * @return 按通讯规约返回Code
     */
    Integer processCode(ParseDataDTO parseDataDTO);

    /**
     * 得到新的手术顺序号
     * 根据patientIdOperationNumber表计算得到表
     * 目前根据synchronized来实现多线程
     *
     * @return 下一个新的手术顺序号
     */
    Integer getNewOperationNumber();

    /**
     * 对接收到的实体类MedicalDataDTO进行第一步解析
     * 缺少mac、operationNumber字段直接返回null
     *
     * @param medicalDataForm 接收到的实体类
     * @return 初次解析后的实体类
     */
    ParseDataDTO processMsg(MedicalDataForm medicalDataForm);

}
