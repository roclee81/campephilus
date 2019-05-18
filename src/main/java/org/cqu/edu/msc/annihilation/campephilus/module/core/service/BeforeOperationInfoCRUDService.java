package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ParseDataDTO;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface BeforeOperationInfoCRUDService extends CRUDService<BeforeOperationInfo> {
    void saveBeforeOperationInfo(BeforeOperationInfo beforeOperationInfo);

    void updateBeforeOperationInfo(BeforeOperationInfo beforeOperationInfo);

    List<BeforeOperationInfo> listAllBeforeOperationInfo(int page, int size);

    void saveBeforeOperationInfoFromDataDTO(ParseDataDTO parseDataDTO);
}