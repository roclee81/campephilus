package org.cqu.edu.msc.annihilation.campephilus.module.app.utils;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.DeviceInfo;

import java.util.HashSet;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/3 11:23
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class RemoveDuplicatesUtil {
    public static HashSet<String> getDeviceSetRemoveDuplicates(List<List<DeviceInfo>> deviceList) {
        HashSet<String> hashSet = new HashSet<>();
        for (List<DeviceInfo> devices : deviceList) {
            for (DeviceInfo deviceInfo : devices) {
                hashSet.add(deviceInfo.getSerialNumber());
            }
        }
        return hashSet;
    }
}
