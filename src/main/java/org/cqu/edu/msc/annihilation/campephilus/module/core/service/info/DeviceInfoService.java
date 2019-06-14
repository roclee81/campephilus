package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface DeviceInfoService extends CrudService<DeviceInfo> {
    void saveDeviceInfo(DeviceInfo deviceInfo);

    void updateDeviceInfo(DeviceInfo deviceInfo);
}
