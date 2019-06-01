package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ParseDataDTO;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:06
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationDeviceInfoService extends CrudService<OperationDeviceInfo> {
    void saveOperationDeviceInfoFromParseDataDTO(ParseDataDTO parseDataDTO);
}