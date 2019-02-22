package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dto.*;
import org.cqu.edu.mrc.annihilation.campephilus.service.CollectorInformationService;
import org.cqu.edu.mrc.annihilation.campephilus.service.DataSearchService;
import org.cqu.edu.mrc.annihilation.campephilus.service.FeedbackInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * campephilus
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
    private final CollectorInformationService collectorInformationService;
    private final FeedbackInformationService feedbackInformationService;

    @Autowired
    public DataSearchServiceImpl(DeviceServiceImpl deviceService, PatientInformationServiceImpl patientInformationService, OperationInformationServiceImpl operationInformationService, CollectorInformationService collectorInformationService, FeedbackInformationService feedbackInformationService) {
        this.deviceService = deviceService;
        this.patientInformationService = patientInformationService;
        this.operationInformationService = operationInformationService;
        this.collectorInformationService = collectorInformationService;
        this.feedbackInformationService = feedbackInformationService;
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
        if (operationNumber >= 1) {
            result.add(operationInformationService.getOperationInformationDTOByOperationNumber(operationNumber));
        }

        return result;
    }

    @Override
    public CollectorInformationDTO listCollectorData(Pageable pageable) {
        return collectorInformationService.getCollectorInformationDTO(pageable);
    }

    @Override
    public List<FeedbackInformationDTO> listFeedbackData(Pageable pageable) {
        return feedbackInformationService.listFeedbackInformationDTO(pageable);
    }

}
