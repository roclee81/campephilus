package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationDeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.repository.OperationDeviceRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.OperationDeviceService;
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
 * @date 2018/12/24 17:40
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
@Slf4j
public class OperationDeviceServiceImpl implements OperationDeviceService {

    private final OperationDeviceRepository operationDeviceRepository;

    @Autowired
    public OperationDeviceServiceImpl(OperationDeviceRepository operationDeviceRepository) {
        this.operationDeviceRepository = operationDeviceRepository;
    }

    @Override
    public void saveOperationDeviceDO(OperationDeviceDO operationDeviceDO) {
        operationDeviceRepository.save(operationDeviceDO);
    }

    @Override
    public boolean saveOperationDeviceDO(ParseDataDTO parseDataDTO) {
        if (null == parseDataDTO) {
            return false;
        }

        Map dataMap = parseDataDTO.getDataMap();
        int operationNumber = parseDataDTO.getOperationNumber();
        String collectorMacAddress = parseDataDTO.getMacAddress();

        Map deviceInformation;
        String operationHospitalCode;

        try {
            // 检查是否有operationHospitalCode,没有直接返回false
            if (dataMap.containsKey(DataConstants.HOSPITAL_CODE)) {
                operationHospitalCode = (String) dataMap.get(DataConstants.HOSPITAL_CODE);
            } else {
                return false;
            }

            // 检查是否有deviceInformation,没有直接返回false
            if (dataMap.containsKey(DataConstants.DEVICE_INFORMATION)) {
                deviceInformation = (Map) dataMap.get(DataConstants.DEVICE_INFORMATION);
            } else {
                return false;
            }

        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            log.error("ParseDataDTO:{},Exception:{}", parseDataDTO.toString(), exception.toString());
            return false;
        }

        OperationDeviceDO operationDeviceDO = new OperationDeviceDO(operationNumber, collectorMacAddress, operationHospitalCode, new Date(), new Date(), deviceInformation);
        this.saveOperationDeviceDO(operationDeviceDO);
        log.info("Insert the success :{}", operationDeviceDO.toString());
        return true;
    }

    @Override
    public boolean updateOperationDeviceDO(ParseDataDTO parseDataDTO) {
        //TODO 未实现
        log.info("Update the success :{}", parseDataDTO.toString());
        return true;
    }

    @Override
    public OperationDeviceDO getOperationDeviceDOSByOperationNumber(Integer operationNumber) {
        return operationDeviceRepository.findOperationDeviceDOSByOperationNumber(operationNumber);
    }

    @Override
    public Page<OperationDeviceDO> getOperationDeviceDOSByCollectorMacAddress(String collectorMacAddress, Pageable pageable) {
        return operationDeviceRepository.findOperationDeviceDOSByCollectorMacAddress(collectorMacAddress, pageable);
    }

    @Override
    public Page<OperationDeviceDO> getOperationDeviceDOSByOperationHospitalCode(String operationHospitalCode, Pageable pageable) {
        return operationDeviceRepository.findOperationDeviceDOSByOperationHospitalCode(operationHospitalCode, pageable);
    }
}
