package org.cqu.edu.mrc.annihilation.campephilus.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.convertor.DeviceDOConvertDeviceDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.DeviceDO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.repository.DeviceRepository;
import org.cqu.edu.mrc.annihilation.campephilus.repository.impl.OperationInformationRepositoryImpl;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;
import org.cqu.edu.mrc.annihilation.campephilus.dto.DeviceDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * campephilus
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
    public Page<DeviceDO> listDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable) {
        if (operationNumber < 0 && deviceId.length() == 0) {
            return null;
        }
        if (operationNumber > 0 && deviceId.length() > 0) {
            return deviceRepository.findDeviceDOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageable);
        }
        if (operationNumber < 0 && deviceId.length() > 0) {
            return this.listDeviceDOSByDeviceId(deviceId, pageable);
        }
        return null;
    }

    @Override
    public List<DeviceDTO> listDeviceDTOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable) {
        Page<DeviceDO> deviceDOPage = this.listDeviceDOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageable);
        return DeviceDOConvertDeviceDTO.convert(deviceDOPage);
    }

    @Override
    public Page<DeviceDO> listDeviceDOByCollectorMacAddress(String collectorMacAddress, Pageable pageable) {
        //TODO 未完成，可能需要维护一张表
//        // 首先查询得到手术的基本信息
//        Page<OperationInformationDO> operationInformationDOPage = operationInformationRepository.findOperationInformationDOSByCollectorMacAddress(collectorMacAddress, pageable);
//        operationInformationDOPage.stream().forEach((operationInformationDO) -> {
//            // 遍历得到的手术基本信息
//            int operationNumber = operationInformationDO.getOperationNumber();
//            // 遍历OperationInformationDO表中deviceInformation字段的所有值
//            Map deviceInformation = operationInformationDO.listDeviceData();
//            for (Object deviceId : deviceInformation.values()) {
//                List<DeviceDTO> deviceDTOList = this.listDeviceDTOSByDeviceIdAndOperationNumber((String) deviceId, operationNumber, pageable);
//            }
//        });
        return null;
    }

    @Override
    public List<DeviceDTO> listDeviceDTOByCollectorMacAddress(String collectorMacAddress, Pageable pageable) {
        return null;
    }


    @Override
    public Page<DeviceDO> listDeviceDOSByDeviceId(String deviceId, Pageable pageable) {
        return deviceRepository.findDeviceDOSByDeviceId(deviceId, pageable);
    }

    @Override
    public List<DeviceDTO> listDeviceDTOSByDeviceId(String deviceId, Pageable pageable) {
        Page<DeviceDO> deviceDOPage = this.listDeviceDOSByDeviceId(deviceId, pageable);
        return DeviceDOConvertDeviceDTO.convert(deviceDOPage);
    }

    @Override
    public void saveDeviceDO(DeviceDO deviceDO, String deviceId) {
//        // 首先查询OperationInformation表中deviceInformation属性是否存在该设备
//        OperationInformationDO operationInformationDO = operationInformationRepository.findOperationInformationDOByOperationNumber(deviceDO.getOperationNumber());
//        if (null == operationInformationDO) {
//            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), ReplyConstants.OPERATION_INFORMATION_NOT_EXIST, ReplyConstants.OPERATION_INFORMATION_NOT_EXIST, deviceDO.toString());
//        }
//        List<Map<String, Object>> deviceInformation = operationInformationDO.getDeviceInformation();
//        if (!deviceInformation.contains(deviceId)) {
//            deviceInformation.add(deviceId);
//            operationInformationDO.setGmtModified(new Date());
//            operationInformationRepository.saveOperationInformationDO(operationInformationDO);
//        }
        deviceRepository.save(deviceDO, deviceId);
    }

    @Override
    public boolean saveDeviceDO(ParseDataDTO parseDataDTO) {
        Map dataMap = null;
//        Map dataMap = parseDataDTO.getData();
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
        } catch (ClassCastException | NumberFormatException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Data property parsing error", "Data property parsing error", parseDataDTO.toString());
        }

        DeviceDO deviceDO = new DeviceDO(operationNumber, deviceDataNumber, deviceData, new Date());
        this.saveDeviceDO(deviceDO, deviceId);
        log.info("Insert the success :{}", deviceDO.toString());
        return true;
    }
}
