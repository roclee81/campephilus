package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.DeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.repository.DeviceRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;


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
@Slf4j
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

    @Override
    public boolean saveDeviceDO(ParseDataDTO parseDataDTO) {
        if (null == parseDataDTO) {
            return false;
        }

        Map dataMap = parseDataDTO.getDataMap();
        int operationNumber = parseDataDTO.getOperationNumber();

        int deviceDataNumber;
        String deviceId;
        Map deviceData;

        try {
            // 检查是否有deviceId,没有直接返回false
            if (dataMap.containsKey(DataConstants.DEVICE_ID)) {
                deviceId = (String) dataMap.get(DataConstants.DEVICE_ID);
            } else {
                return false;
            }

            // 检查是否有deviceDataNumber,没有直接返回false
            if (dataMap.containsKey(DataConstants.DEVICE_DATA_NUMBER)) {
                deviceDataNumber = Integer.parseInt((String) dataMap.get(DataConstants.DEVICE_DATA_NUMBER));
            } else {
                return false;
            }

            // 检查是否有deviceDataNumber,没有直接返回false
            if (dataMap.containsKey(DataConstants.DEVICE_DATA)) {
                deviceData = (Map) dataMap.get(DataConstants.DEVICE_DATA);
            } else {
                return false;
            }
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            log.error("ParseDataDTO:{},Exception:{}", parseDataDTO.toString(), exception.toString());
            return false;
        }

        DeviceDO deviceDO = new DeviceDO(operationNumber, deviceDataNumber, new Date(), deviceData);
        this.saveDeviceDO(deviceDO, deviceId);
        log.info("Insert the success :{}", deviceDO.toString());
        return true;
    }
}
