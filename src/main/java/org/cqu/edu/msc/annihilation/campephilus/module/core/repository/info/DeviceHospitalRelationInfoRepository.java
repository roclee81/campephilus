package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 15:45
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface DeviceHospitalRelationInfoRepository extends JpaRepository<DeviceHospitalRelationInfo, Integer> {
    DeviceHospitalRelationInfo findDeviceHospitalRelationInfoByDeviceCodeAndDeviceSerialNumber(String deviceCode, String deviceSerialNumber);
}
