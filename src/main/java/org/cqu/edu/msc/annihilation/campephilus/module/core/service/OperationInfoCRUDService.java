package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ParseDataDTO;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationInfoCRUDService extends CRUDService<OperationInfo> {
    void saveOperationInfo(OperationInfo operationInfo);

    List<OperationInfo> listAllOperationInfo(int page, int size);

    void updateOperationInfo(OperationInfo operationInfo);

    void saveOperationInfoFromParseDataDTO(ParseDataDTO parseDataDTO);

    Integer countOperationInfo();
}
