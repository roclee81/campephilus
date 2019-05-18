package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface DeviceHospitalRelationInfoService extends ServiceFactory<DeviceHospitalRelationInfo> {
    void saveDeviceHospitalRelationInfo(DeviceHospitalRelationInfo deviceHospitalRelationInfo);

    void updateDeviceHospitalRelationInfo(DeviceHospitalRelationInfo deviceHospitalRelationInfo);

    List<DeviceHospitalRelationInfo> listAllDeviceHospitalRelationInfo(int page, int size);
}
