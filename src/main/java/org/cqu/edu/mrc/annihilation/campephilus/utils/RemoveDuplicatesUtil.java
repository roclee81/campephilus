package org.cqu.edu.mrc.annihilation.campephilus.utils;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.DeviceCommon;

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
    public static HashSet<String> getDeviceSetRemoveDuplicates(List<List<DeviceCommon>> deviceList) {
        HashSet<String> hashSet = new HashSet<>();
        for (List<DeviceCommon> devices : deviceList) {
            for (DeviceCommon deviceCommon : devices) {
                hashSet.add(deviceCommon.getSerialNumber());
            }
        }
        return hashSet;
    }
}
