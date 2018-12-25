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
     * 通过解析Code判断请求方式并回复
     * 处理一个大型的分支，目前没有想到有什么其余的方式写该方法
     *
     * @param medicalDataDTO 接收的DTO
     * @return 按通讯规约返回Code
     */
    Integer processCode(MedicalDataDTO medicalDataDTO);

}
