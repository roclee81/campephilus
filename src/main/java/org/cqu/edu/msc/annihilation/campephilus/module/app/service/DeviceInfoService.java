package org.cqu.edu.msc.annihilation.campephilus.module.app.service;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.DeviceInfo;

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

    List<DeviceInfo> listAllDeviceInfo(int page, int size);
}
