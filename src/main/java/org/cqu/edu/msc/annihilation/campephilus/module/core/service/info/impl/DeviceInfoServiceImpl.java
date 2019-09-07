package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.DeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.DeviceInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.DeviceInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_DEVICE)
@Service
public class DeviceInfoServiceImpl extends AbstractInfoService<DeviceInfo, Integer> implements DeviceInfoService {

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
    public DeviceInfo save(DeviceInfo deviceInfo) {
        // 首先查询是否存在该条数据，根据deviceProducer和deviceSerialNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(deviceInfoRepository.findDeviceInfoByDeviceCodeAndDeviceSerialNumber(
                deviceInfo.getDeviceCode(), deviceInfo.getDeviceSerialNumber()));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(deviceInfoRepository, deviceInfo);
    }

}
