package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationDeviceInformationDO;
import org.cqu.edu.mrc.realdata.modules.app.repository.OperationDeviceRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.OperationDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

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
public class OperationDeviceServiceImpl implements OperationDeviceService {

    private final OperationDeviceRepository operationDeviceRepository;

    @Autowired
    public OperationDeviceServiceImpl(OperationDeviceRepository operationDeviceRepository) {
        this.operationDeviceRepository = operationDeviceRepository;
    }

    @Override
    public OperationDeviceInformationDO getOperationDeviceInformationDOSByOperationNumber(Integer operationNumber) {
        return operationDeviceRepository.findOperationDeviceInformationDOSByOperationNumber(operationNumber);
    }

    @Override
    public Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByCollectorMacAddress(String macAddress, Pageable pageable) {
        return operationDeviceRepository.findOperationDeviceInformationDOSByCollectorMacAddress(macAddress, pageable);
    }

    @Override
    public Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByOperationHospitalCode(Integer operationHospitalCode, Pageable pageable) {
        return operationDeviceRepository.findOperationDeviceInformationDOSByOperationHospitalCode(operationHospitalCode, pageable);
    }

    @Override
    public Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByOperationStartTimeBefore(Date operationStartTimeBefore, Pageable pageable) {
        return operationDeviceRepository.findOperationDeviceInformationDOSByOperationStartTimeBefore(operationStartTimeBefore, pageable);
    }

    @Override
    public Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByOperationStartTimeAfter(Date operationStartTimeAfter, Pageable pageable) {
        return operationDeviceRepository.findOperationDeviceInformationDOSByOperationStartTimeAfter(operationStartTimeAfter, pageable);
    }

    @Override
    public Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable) {
        return operationDeviceRepository.findOperationDeviceInformationDOSByOperationStartTimeBetween(operationStartTimeBefore, operationStartTimeAfter, pageable);
    }

    @Override
    public Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByOperationTimeBetween(Date operationTimeBefore, Date operationTimeAfter, Pageable pageable) {
        return operationDeviceRepository.findOperationDeviceInformationDOSByOperationTimeBetween(operationTimeBefore, operationTimeAfter, pageable);
    }
}
