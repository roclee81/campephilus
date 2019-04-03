package org.cqu.edu.msc.annihilation.campephilus.core.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.core.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.core.repository.DeviceRepository;
import org.cqu.edu.msc.annihilation.campephilus.core.service.OperationInformationService;
import org.cqu.edu.msc.annihilation.campephilus.core.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.core.dataobject.DeviceDO;
import org.cqu.edu.msc.annihilation.campephilus.core.dto.DeviceDTO;
import org.cqu.edu.msc.annihilation.campephilus.core.service.DeviceService;
import org.cqu.edu.msc.annihilation.campephilus.core.utils.CheckStateUtil;
import org.cqu.edu.msc.annihilation.common.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


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
    private final OperationInformationService operationInformationService;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository, OperationInformationService operationInformationService) {
        this.deviceRepository = deviceRepository;
        this.operationInformationService = operationInformationService;
    }

    @Override
    public Page<DeviceDO> listDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable) {
        if (operationNumber < 0 && deviceId.length() == 0) {
            return null;
        }
        if (operationNumber > 0 && deviceId.length() > 0) {
            return deviceRepository.findDeviceDOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageable);
        }
        if (operationNumber < 0) {
            return this.listDeviceDOSByDeviceId(deviceId, pageable);
        }
        return null;
    }

    @Override
    public List<DeviceDTO> listDeviceDTOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable) {
        Page<DeviceDO> deviceDOPage = this.listDeviceDOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageable);
        return ConvertUtil.convert(deviceDOPage,DeviceDTO.class);
    }

    @Override
    public DeviceDO getDeviceDOByDeviceIdAndOperationNumberAndDeviceDataNumber(String deviceId, Integer operationNumber, Integer deviceDataNumber) {
        return deviceRepository.findDeviceDOByDeviceIdAndOperationNumberAndDeviceDataNumber(deviceId, operationNumber, deviceDataNumber);
    }

    @Override
    public Page<DeviceDO> listDeviceDOSByDeviceId(String deviceId, Pageable pageable) {
        return deviceRepository.findDeviceDOSByDeviceId(deviceId, pageable);
    }

    @Override
    public List<DeviceDTO> listDeviceDTOSByDeviceId(String deviceId, Pageable pageable) {
        Page<DeviceDO> deviceDOPage = this.listDeviceDOSByDeviceId(deviceId, pageable);
        return ConvertUtil.convert(deviceDOPage,DeviceDTO.class);
    }

    @Override
    public boolean saveDeviceDO(DeviceDO deviceDO) {
        // 首先查询是否存在该条数据，只要有数据就不允许覆盖保存
        DeviceDO searchResult = this.getDeviceDOByDeviceIdAndOperationNumberAndDeviceDataNumber(deviceDO.getDeviceId(), deviceDO.getOperationNumber(), deviceDO.getDeviceDataNumber());

        CheckStateUtil.checkState(searchResult, operationInformationService, deviceDO.getOperationNumber());

        DeviceDO result = deviceRepository.saveDeviceDO(deviceDO);
        SaveException.checkSaveSuccess(result, deviceDO);
        return true;
    }

    @Override
    public boolean saveDeviceDO(ParseDataDTO parseDataDTO) {
        DeviceDO parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, DeviceDO.class);

        if (null == parseResult) {
            return false;
        }
        if (parseResult.getDeviceId() == null || parseResult.getDeviceDataNumber() == null || parseResult.getDeviceData() == null) {
            return false;
        }
        return this.saveDeviceDO(parseResult);
    }
}
