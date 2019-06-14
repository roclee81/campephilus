package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.DeviceHospitalRelationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.DeviceHospitalRelationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class DeviceHospitalRelationInfoServiceImpl extends AbstractInfoService<DeviceHospitalRelationInfo, Integer> implements DeviceHospitalRelationInfoService {

    private final DeviceHospitalRelationInfoRepository deviceHospitalRelationInfoRepository;

    public DeviceHospitalRelationInfoServiceImpl(DeviceHospitalRelationInfoRepository deviceHospitalRelationInfoRepository) {
        this.deviceHospitalRelationInfoRepository = deviceHospitalRelationInfoRepository;
    }

    @Override
    public JpaRepository<DeviceHospitalRelationInfo, Integer> getJpaRepository() {
        return deviceHospitalRelationInfoRepository;
    }

    @Override
    protected Integer getId(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {
        return deviceHospitalRelationInfo.getId();
    }

    @Override
    public void save(DeviceHospitalRelationInfo deviceHospitalRelationInfo) {
        // 首先查询是否存在该条数据，根据AdmissionNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(deviceHospitalRelationInfoRepository
                .findDeviceHospitalRelationInfoByDeviceCodeAndDeviceSerialNumber(
                        deviceHospitalRelationInfo.getDeviceCode(), deviceHospitalRelationInfo.getDeviceSerialNumber()));
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudUtils.saveObjectAndCheckSuccess(deviceHospitalRelationInfoRepository, deviceHospitalRelationInfo);
    }
}
