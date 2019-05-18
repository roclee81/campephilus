package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface DeviceInfoCRUDService extends CRUDService<DeviceInfo> {
    void saveDeviceInfo(DeviceInfo deviceInfo);

    void updateDeviceInfo(DeviceInfo deviceInfo);

    List<DeviceInfo> listAllDeviceInfo(int page, int size);
}
