package org.cqu.edu.msc.annihilation.campephilus.module.core.repository;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/18 21:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface DeviceInfoRepository extends JpaRepository<DeviceInfo, Integer> {

    DeviceInfo findDeviceInfoByDeviceCodeAndDeviceSerialNumber(String deviceCode, String deviceSerialNumber);
}
