package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.DeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.DeviceInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

    private final DeviceInfoRepository deviceInfoRepository;

    @Autowired
    public DeviceInfoServiceImpl(DeviceInfoRepository deviceInfoRepository) {
        this.deviceInfoRepository = deviceInfoRepository;
    }

    @Override
    public synchronized void saveDeviceInfo(DeviceInfo deviceInfo) {
        // 首先查询是否存在该条数据，根据deviceProducer和deviceSerialNumber查询
        DeviceInfo searchResult = deviceInfoRepository.findDeviceInfoByDeviceProducerAndDeviceSerialNumber(
                deviceInfo.getDeviceProducer(), deviceInfo.getDeviceSerialNumber());
        if (null != searchResult) {
            // 判断到存在该仪器存在，则直接返回，不抛出异常
            return;
        }
        DeviceInfo result = deviceInfoRepository.save(deviceInfo);
        SaveException.checkSaveSuccess(result, deviceInfo);
    }

    @Override
    public synchronized void updateDeviceInfo(DeviceInfo deviceInfo) {
        // 检查deviceInfo的id来判断是否是更新数据，同时判断是否存在该id的数据
        Integer id = deviceInfo.getId();
        if (null == id || deviceInfoRepository.findById(id).isEmpty()) {
            throw new SaveException(ResponseEnum.UPDATE_ID_ERROR);
        }
        DeviceInfo result = deviceInfoRepository.save(deviceInfo);
        SaveException.checkSaveSuccess(result, deviceInfo);
    }

    @Override
    public List<DeviceInfo> listAllDeviceInfo(int page, int size) {
        Page<DeviceInfo> searchResult = deviceInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }
}
