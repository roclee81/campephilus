package org.cqu.edu.mrc.annihilation.campephilus.modules.app.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.modules.app.dto.DeviceDTO;
import org.cqu.edu.mrc.annihilation.campephilus.modules.app.dto.OperationInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.modules.app.dto.PatientInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.modules.app.service.DataSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/28 20:56
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class DataSearchServiceImpl implements DataSearchService {

    private final DeviceServiceImpl deviceService;
    private final PatientInformationServiceImpl patientInformationService;
    private final OperationInformationServiceImpl operationInformationService;

    @Autowired
    public DataSearchServiceImpl(DeviceServiceImpl deviceService, PatientInformationServiceImpl patientInformationService, OperationInformationServiceImpl operationInformationService) {
        this.deviceService = deviceService;
        this.patientInformationService = patientInformationService;
        this.operationInformationService = operationInformationService;
    }

    @Override
    public List<DeviceDTO> listDeviceData(int operationNumber, String deviceId, Pageable pageable) {
        if (operationNumber == -1 && deviceId.length() > 0) {
            return deviceService.listDeviceDTOSByDeviceId(deviceId, pageable);
        }

        if (operationNumber > 0 && deviceId.length() > 0) {
            return deviceService.listDeviceDTOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageable);
        }

        return new ArrayList<>();
    }

    @Override
    public List<PatientInformationDTO> listPatientData(int operationNumber, String patientId, Pageable pageable) {

        if (operationNumber == -1 && patientId.length() > 0) {
            return patientInformationService.listPatientInformationDTOSByPatientId(patientId, pageable);
        }

        List<PatientInformationDTO> result = new ArrayList<>();
        if (operationNumber > 0 && patientId.length() == 0) {
            result.add(patientInformationService.getPatientInformationDTOByOperationNumber(operationNumber));
            return result;
        }

        if (operationNumber > 0 && patientId.length() > 0) {
            result.add(patientInformationService.getPatientInformationDTOByPatientIdAndOperationNumber(patientId, operationNumber));
            return result;
        }

        return result;
    }

    @Override
    public List<OperationInformationDTO> listOperationData(int operationNumber, String collectorMacAddress, Pageable pageable) {

        if (operationNumber == 0) {
            return operationInformationService.listOperationInformationDTOS(pageable);
        }

        List<OperationInformationDTO> result = new ArrayList<>();
        // 如果传入了不为0，则是查询特定的OperationInformationDTO
        if (operationNumber > 1) {
            result.add(operationInformationService.getOperationInformationDTOByOperationNumber(operationNumber));
        }

        return result;
    }
}
