package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.DeviceInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.DeviceInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_DEVICE)
@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

    private final DeviceInfoRepository deviceInfoRepository;

    @Autowired
    public DeviceInfoServiceImpl(DeviceInfoRepository deviceInfoRepository) {
        this.deviceInfoRepository = deviceInfoRepository;
    }

    private Integer getId(DeviceInfo deviceInfo) {
        return deviceInfo.getId();
    }

    @CacheEvict(allEntries = true)
    @Override
    public DeviceInfo save(DeviceInfo deviceInfo) {
        // 首先查询是否存在该条数据，根据deviceProducer和deviceSerialNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(deviceInfoRepository.findDeviceInfoByDeviceCodeAndDeviceSerialNumber(
                deviceInfo.getDeviceCode(), deviceInfo.getDeviceSerialNumber()));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(deviceInfoRepository, deviceInfo);
    }

    @CacheEvict(allEntries = true)
    @Override
    public synchronized void update(DeviceInfo t) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(deviceInfoRepository, getId(t), t);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void delete(DeviceInfo t) {
        // TODO
    }

    @Override
    public List<DeviceInfo> listById(Object id) {
        return null;
    }

    @Override
    public List<DeviceInfo> listAll(int page, int size) {
        Page<DeviceInfo> searchResult = deviceInfoRepository.findAll(PageRequest.of(page, size));
        return ConvertUtils.convertObjectTimeStamp((searchResult.getContent()));
    }

    @Override
    public long countAll() {
        return deviceInfoRepository.count();
    }

}
