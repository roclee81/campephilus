package org.cqu.edu.mrc.campephilus.modules.app.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.campephilus.common.constant.DataConstants;
import org.cqu.edu.mrc.campephilus.common.enums.ResponseEnum;
import org.cqu.edu.mrc.campephilus.modules.app.convertor.DeviceDOConvertDeviceDTO;
import org.cqu.edu.mrc.campephilus.modules.app.dataobject.DeviceDO;
import org.cqu.edu.mrc.campephilus.modules.app.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.campephilus.modules.app.exception.SaveException;
import org.cqu.edu.mrc.campephilus.modules.app.repository.DeviceRepository;
import org.cqu.edu.mrc.campephilus.modules.app.repository.impl.OperationInformationRepositoryImpl;
import org.cqu.edu.mrc.campephilus.modules.app.dto.DeviceDTO;
import org.cqu.edu.mrc.campephilus.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.campephilus.modules.app.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;


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

    private final OperationInformationRepositoryImpl operationInformationRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository, OperationInformationRepositoryImpl operationInformationRepository) {
        this.deviceRepository = deviceRepository;
        this.operationInformationRepository = operationInformationRepository;
    }

    @Override
    public Page<DeviceDO> getDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable) {
        if (operationNumber < 0 && deviceId.length() == 0) {
            return null;
        }
        if (operationNumber > 0 && deviceId.length() > 0) {
            return deviceRepository.findDeviceDOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageable);
        }
        if (operationNumber < 0 && deviceId.length() > 0) {
            return this.getDeviceDOSByDeviceId(deviceId, pageable);
        }
        return null;
    }

    @Override
    public List<DeviceDTO> getDeviceDTOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable) {
        Page<DeviceDO> deviceDOPage = this.getDeviceDOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageable);
        return DeviceDOConvertDeviceDTO.convert(deviceDOPage);
    }

    @Override
    public Page<DeviceDO> getDeviceDOByCollectorMacAddress(String collectorMacAddress, Pageable pageable) {
        //TODO 未完成，可能需要维护一张表
//        // 首先查询得到手术的基本信息
//        Page<OperationInformationDO> operationInformationDOPage = operationInformationRepository.findOperationInformationDOSByCollectorMacAddress(collectorMacAddress, pageable);
//        operationInformationDOPage.stream().forEach((operationInformationDO) -> {
//            // 遍历得到的手术基本信息
//            int operationNumber = operationInformationDO.getOperationNumber();
//            // 遍历OperationInformationDO表中deviceInformation字段的所有值
//            Map deviceInformation = operationInformationDO.getDeviceInformation();
//            for (Object deviceId : deviceInformation.values()) {
//                List<DeviceDTO> deviceDTOList = this.getDeviceDTOSByDeviceIdAndOperationNumber((String) deviceId, operationNumber, pageable);
//            }
//        });
        return null;
    }

    @Override
    public List<DeviceDTO> getDeviceDTOByCollectorMacAddress(String collectorMacAddress, Pageable pageable) {
        return null;
    }


    @Override
    public Page<DeviceDO> getDeviceDOSByDeviceId(String deviceId, Pageable pageable) {
        return deviceRepository.findDeviceDOSByDeviceId(deviceId, pageable);
    }

    @Override
    public List<DeviceDTO> getDeviceDTOSByDeviceId(String deviceId, Pageable pageable) {
        Page<DeviceDO> deviceDOPage = this.getDeviceDOSByDeviceId(deviceId, pageable);
        return DeviceDOConvertDeviceDTO.convert(deviceDOPage);
    }

    @Override
    public Map<String, Object> getDeviceDOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        OperationInformationDO operationInformationDO = operationInformationRepository.findOperationInformationDOByOperationNumber(operationNumber);
        List<String> deviceInformation = operationInformationDO.getDeviceInformation();
        Map<String, Object> result = new HashMap<>(deviceInformation.size());
        for (String deviceId : deviceInformation) {
            Page<DeviceDO> deviceDOPage = deviceRepository.findDeviceDOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageable);
            List<DeviceDTO> deviceDTOList = DeviceDOConvertDeviceDTO.convert(deviceDOPage);
            result.put(deviceId, deviceDTOList);
        }
        return result;
    }

    @Override
    public void saveDeviceDO(DeviceDO deviceDO, String deviceId) {
        // 首先查询OperationInformation表中deviceInformation属性是否存在该设备
        OperationInformationDO operationInformationDO = operationInformationRepository.findOperationInformationDOByOperationNumber(deviceDO.getOperationNumber());
        if (null == operationInformationDO) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Correspondence operationInformation table does not exist", deviceDO.toString());
        }
        List<String> deviceInformation = operationInformationDO.getDeviceInformation();
        if (!deviceInformation.contains(deviceId)) {
            deviceInformation.add(deviceId);
            operationInformationDO.setGmtModified(new Date());
            operationInformationRepository.saveOperationInformationDO(operationInformationDO);
        }
        deviceRepository.save(deviceDO, deviceId);
    }

    @Override
    public boolean saveDeviceDO(ParseDataDTO parseDataDTO) {
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

            // 检查是否有deviceData,没有直接返回false
            if (dataMap.containsKey(DataConstants.DEVICE_DATA)) {
                deviceData = (Map) dataMap.get(DataConstants.DEVICE_DATA);
            } else {
                return false;
            }
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Data property parsing error", parseDataDTO.toString());
        }

        DeviceDO deviceDO = new DeviceDO(operationNumber, deviceDataNumber, new Date(), deviceData);
        this.saveDeviceDO(deviceDO, deviceId);
        log.info("Insert the success :{}", deviceDO.toString());
        return true;
    }
}
