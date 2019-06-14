package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.DeviceInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.DeviceInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class DeviceInfoServiceImpl extends AbstractInfoService<DeviceInfo,Integer> implements DeviceInfoService {

    private final DeviceInfoRepository deviceInfoRepository;

    @Autowired
    public DeviceInfoServiceImpl(DeviceInfoRepository deviceInfoRepository) {
        this.deviceInfoRepository = deviceInfoRepository;
    }

    @Override
    public JpaRepository<DeviceInfo, Integer> getJpaRepository() {
        return deviceInfoRepository;
    }

    @Override
    protected Integer getId(DeviceInfo deviceInfo) {
        return deviceInfo.getId();
    }

    @Override
    public synchronized void saveDeviceInfo(DeviceInfo deviceInfo) {
        // 首先查询是否存在该条数据，根据deviceProducer和deviceSerialNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(deviceInfoRepository.findDeviceInfoByDeviceCodeAndDeviceSerialNumber(
                deviceInfo.getDeviceCode(), deviceInfo.getDeviceSerialNumber()));
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudUtils.saveObjectAndCheckSuccess(deviceInfoRepository, deviceInfo);
    }

    @Override
    public synchronized void updateDeviceInfo(DeviceInfo deviceInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudUtils.updateObjectAndCheckSuccess(deviceInfoRepository, deviceInfo.getId(), deviceInfo);
    }


    @Override
    public void save(DeviceInfo deviceInfo) {
        this.saveDeviceInfo(deviceInfo);
    }

    @Override
    public void update(DeviceInfo deviceInfo) {
        this.updateDeviceInfo(deviceInfo);
    }


}
