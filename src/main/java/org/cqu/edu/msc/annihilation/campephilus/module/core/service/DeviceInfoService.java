package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dataobject.info.DeviceInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface DeviceInfoService {

    void saveDeviceInfo(DeviceInfo deviceInfo);

    void updateDeviceInfo(DeviceInfo deviceInfo);

    List<DeviceInfo> listAllDeviceInfo(int page, int size);
}
