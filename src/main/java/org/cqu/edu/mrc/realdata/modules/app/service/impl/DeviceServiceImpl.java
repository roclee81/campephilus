package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import com.google.gson.Gson;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.DeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.MedicalDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.repository.DeviceRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 16:46
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Page<DeviceDO> getDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable) {
        return deviceRepository.findDeviceDOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageable);
    }

    @Override
    public Page<DeviceDO> getDeviceDOSByDeviceId(String deviceId, Pageable pageable) {
        return deviceRepository.findDeviceDOSByDeviceId(deviceId, pageable);
    }

    @Override
    public Page<DeviceDO> getDeviceDOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        return deviceRepository.findDeviceDOSByOperationNumber(operationNumber, pageable);
    }

    @Override
    public void saveDeviceDO(DeviceDO deviceDO, String deviceId) {
        deviceRepository.save(deviceDO, deviceId);
    }
}
