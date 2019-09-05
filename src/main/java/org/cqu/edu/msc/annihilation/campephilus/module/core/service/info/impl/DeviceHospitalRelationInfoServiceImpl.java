package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.DeviceHospitalRelationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.DeviceHospitalRelationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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

    @Autowired
    public DeviceHospitalRelationInfoServiceImpl(DeviceHospitalRelationInfoRepository deviceHospitalRelationInfoRepository) {
        this.deviceHospitalRelationInfoRepository = deviceHospitalRelationInfoRepository;
    }

    private Integer getId(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {
        return deviceHospitalRelationInfo.getId();
    }

    @CacheEvict(allEntries = true)
    @Override
    public DeviceHospitalRelationInfo save(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {
        // 首先查询是否存在该条数据，根据AdmissionNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(deviceHospitalRelationInfoRepository
                .findDeviceHospitalRelationInfoByDeviceCodeAndDeviceSerialNumber(
                        deviceHospitalRelationInfo.getDeviceCode(), deviceHospitalRelationInfo.getDeviceSerialNumber()));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(deviceHospitalRelationInfoRepository, deviceHospitalRelationInfo);
    }

    @CacheEvict(allEntries = true)
    @Override
    public synchronized void update(DeviceHospitalRelationInfo t) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(deviceHospitalRelationInfoRepository, getId(t), t);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void delete(DeviceHospitalRelationInfo t) {
        // TODO
    }

    @Override
    public List<DeviceHospitalRelationInfo> listById(Object id) {
        return null;
    }

    @Override
    public List<DeviceHospitalRelationInfo> listAll(int page, int size) {
        Page<DeviceHospitalRelationInfo> searchResult = deviceHospitalRelationInfoRepository.findAll(PageRequest.of(page, size));
        return ConvertUtils.convertObjectTimeStamp(searchResult.getContent());
    }

    @Override
    public long countAll() {
        return deviceHospitalRelationInfoRepository.count();
    }

}
