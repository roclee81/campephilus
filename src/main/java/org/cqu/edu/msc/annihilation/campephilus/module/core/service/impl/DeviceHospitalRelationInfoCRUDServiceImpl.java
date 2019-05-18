package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.DeviceHospitalRelationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.DeviceHospitalRelationInfoCRUDService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ServiceSaveUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ServiceUpdateUtils;
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
public class DeviceHospitalRelationInfoCRUDServiceImpl implements DeviceHospitalRelationInfoCRUDService {

    private final DeviceHospitalRelationInfoRepository deviceHospitalRelationInfoRepository;

    public DeviceHospitalRelationInfoCRUDServiceImpl(DeviceHospitalRelationInfoRepository deviceHospitalRelationInfoRepository) {
        this.deviceHospitalRelationInfoRepository = deviceHospitalRelationInfoRepository;
    }

    @Override
    public void saveDeviceHospitalRelationInfo(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {
        // 首先查询是否存在该条数据，根据AdmissionNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(deviceHospitalRelationInfoRepository
                .findDeviceHospitalRelationInfoByDeviceCodeAndDeviceSerialNumber(
                        deviceHospitalRelationInfo.getDeviceCode(), deviceHospitalRelationInfo.getDeviceSerialNumber()));
        // 判断保存是否成功，不成功将抛出异常
        ServiceSaveUtils.saveObjectAndCheckSuccess(deviceHospitalRelationInfoRepository, deviceHospitalRelationInfo);
    }

    @Override
    public void updateDeviceHospitalRelationInfo(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceUpdateUtils.updateObjectAndCheckSuccess(
                deviceHospitalRelationInfoRepository, deviceHospitalRelationInfo.getId(), deviceHospitalRelationInfo);
    }

    @Override
    public List<DeviceHospitalRelationInfo> listAllDeviceHospitalRelationInfo(int page, int size) {
        Page<DeviceHospitalRelationInfo> searchResult = deviceHospitalRelationInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void save(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {
        this.saveDeviceHospitalRelationInfo(deviceHospitalRelationInfo);
    }

    @Override
    public void update(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {
        this.updateDeviceHospitalRelationInfo(deviceHospitalRelationInfo);
    }

    @Override
    public List<DeviceHospitalRelationInfo> listAll(int page, int size) {
        return this.listAllDeviceHospitalRelationInfo(page, size);
    }

    @Override
    public void delete(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {

    }
}
