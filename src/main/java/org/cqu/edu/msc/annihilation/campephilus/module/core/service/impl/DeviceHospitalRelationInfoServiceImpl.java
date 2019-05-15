package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.DeviceHospitalRelationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.DeviceHospitalRelationInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class DeviceHospitalRelationInfoServiceImpl implements DeviceHospitalRelationInfoService {

    private final DeviceHospitalRelationInfoRepository deviceHospitalRelationInfoRepository;

    public DeviceHospitalRelationInfoServiceImpl(DeviceHospitalRelationInfoRepository deviceHospitalRelationInfoRepository) {
        this.deviceHospitalRelationInfoRepository = deviceHospitalRelationInfoRepository;
    }

    @Override
    public void saveDeviceHospitalRelationInfo(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {
        // 首先查询是否存在该条数据，根据AdmissionNumber查询
        DeviceHospitalRelationInfo searchResult = deviceHospitalRelationInfoRepository
                .findDeviceHospitalRelationInfoByDeviceCodeAndDeviceSerialNumber(
                        deviceHospitalRelationInfo.getDeviceCode(), deviceHospitalRelationInfo.getDeviceSerialNumber());
        if (null != searchResult) {
            // 判断到存在该仪器存在，则直接返回，不抛出异常
            return;
        }
        DeviceHospitalRelationInfo result = deviceHospitalRelationInfoRepository.save(deviceHospitalRelationInfo);
        SaveException.checkSaveSuccess(result, deviceHospitalRelationInfo);
    }

    @Override
    public void updateDeviceHospitalRelationInfo(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {
        // 检查beforeOperationInfo的AdmissionNumber来判断是否是更新数据，同时判断是否存在该AdmissionNumber的数据
        Integer id = deviceHospitalRelationInfo.getId();
        if (null == id || deviceHospitalRelationInfoRepository.findById(id).isEmpty()) {
            throw new SaveException(ResponseEnum.UPDATE_ID_ERROR);
        }
        DeviceHospitalRelationInfo result = deviceHospitalRelationInfoRepository.save(deviceHospitalRelationInfo);
        SaveException.checkSaveSuccess(result, deviceHospitalRelationInfo);
    }

    @Override
    public List<DeviceHospitalRelationInfo> listAllDeviceHospitalRelationInfo(int page, int size) {
        Page<DeviceHospitalRelationInfo> searchResult = deviceHospitalRelationInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }
}
