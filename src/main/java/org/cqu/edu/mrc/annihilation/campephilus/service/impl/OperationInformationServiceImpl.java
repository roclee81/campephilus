package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.enums.OperationStateEnum;
import org.cqu.edu.mrc.annihilation.common.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.convertor.OperationInformationDOConvertOperationInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.OperationInformationRepository;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;
import org.cqu.edu.mrc.annihilation.campephilus.dto.OperationInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.service.OperationInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/26 20:59
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
@Slf4j
public class OperationInformationServiceImpl implements OperationInformationService {

    private final OperationInformationRepository operationInformationRepository;

    @Autowired
    public OperationInformationServiceImpl(OperationInformationRepository operationInformationRepository) {
        this.operationInformationRepository = operationInformationRepository;
    }

    @Override
    public Page<OperationInformationDO> listOperationInformationDOSByPatientId(String patientId, Pageable pageable) {
        return operationInformationRepository.findOperationInformationDOSByPatientId(patientId, pageable);
    }

    @Override
    public List<OperationInformationDTO> listOperationInformationDTOSByPatientId(String patientId, Pageable pageable) {
        Page<OperationInformationDO> operationInformationDOPage = this.listOperationInformationDOSByPatientId(patientId, pageable);
        return OperationInformationDOConvertOperationInformationDTO.convert(operationInformationDOPage);
    }

    @Override
    public OperationInformationDO getOperationInformationDOByOperationNumber(Integer operationNumber) {
        return operationInformationRepository.findOperationInformationDOByOperationNumber(operationNumber);
    }

    @Override
    public OperationInformationDTO getOperationInformationDTOByOperationNumber(Integer operationNumber) {
        OperationInformationDO operationInformationDO = this.getOperationInformationDOByOperationNumber(operationNumber);
        return OperationInformationDOConvertOperationInformationDTO.convert(operationInformationDO);
    }

    @Override
    public Page<OperationInformationDO> listOperationInformationDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable) {
        return operationInformationRepository.findOperationInformationDOSByOperationStartTimeBetween(operationStartTimeBefore, operationStartTimeAfter, pageable);
    }

    @Override
    public List<OperationInformationDTO> listOperationInformationDTOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable) {
        Page<OperationInformationDO> operationInformationDOPage = this.listOperationInformationDOSByOperationStartTimeBetween(operationStartTimeBefore, operationStartTimeAfter, pageable);
        return OperationInformationDOConvertOperationInformationDTO.convert(operationInformationDOPage);
    }

    @Override
    public Page<OperationInformationDO> listOperationInformationDOSByOperationTimeBetween(Long operationTimeBefore, Long operationTimeAfter, Pageable pageable) {
        return operationInformationRepository.findOperationInformationDOSByOperationTimeBetween(operationTimeBefore, operationTimeAfter, pageable);
    }

    @Override
    public List<OperationInformationDTO> listOperationInformationDTOSByOperationTimeBetween(Long operationTimeBefore, Long operationTimeAfter, Pageable pageable) {
        Page<OperationInformationDO> operationInformationDOPage = this.listOperationInformationDOSByOperationTimeBetween(operationTimeBefore, operationTimeAfter, pageable);
        return OperationInformationDOConvertOperationInformationDTO.convert(operationInformationDOPage);
    }

    @Override
    public Page<OperationInformationDO> listOperationInformationDOS(Pageable pageable) {
        return operationInformationRepository.findOperationInformationDOS(pageable);
    }

    @Override
    public List<OperationInformationDTO> listOperationInformationDTOS(Pageable pageable) {
        Page<OperationInformationDO> operationInformationDOPage = this.listOperationInformationDOS(pageable);
        return OperationInformationDOConvertOperationInformationDTO.convert(operationInformationDOPage);
    }

    @Override
    public OperationInformationDO saveOperationInformationDO(OperationInformationDO operationInformationDO) {
        return operationInformationRepository.saveOperationInformationDO(operationInformationDO);
    }

    @Override
    public boolean saveOperationInformationDO(ParseDataDTO parseDataDTO) {
        Map dataMap = parseDataDTO.getDataMap();
        int operationNumber = parseDataDTO.getOperationNumber();

        Map<String, Object> operationInfoMap;
        String patientId;
        Date operationStartTime;
        String operationHospitalCode;
        List<Map<String, Object>> deviceInformation;
        try {
            // 检查是否有operationInfo,没有直接返回false
            if (dataMap.containsKey(DataConstants.OPERATION_INFOMATION)) {
                operationInfoMap = (Map<String, Object>) dataMap.get(DataConstants.OPERATION_INFOMATION);
                // 检查是否有operationHospitalCode,没有直接返回false
                if (operationInfoMap.containsKey(DataConstants.OPERATION_HOSPITAL_CODE)) {
                    operationHospitalCode = (String) operationInfoMap.get(DataConstants.OPERATION_HOSPITAL_CODE);
                } else {
                    return false;
                }

                // 检查是否有patientId,没有直接返回false
                if (operationInfoMap.containsKey(DataConstants.PATIENT_ID)) {
                    patientId = (String) operationInfoMap.get(DataConstants.PATIENT_ID);
                } else {
                    return false;
                }

                // 检查是否有operationStartTime，没有直接返回false
                if (operationInfoMap.containsKey(DataConstants.OPERATION_START_TIME)) {
                    operationStartTime = new Date(Long.parseLong((String) operationInfoMap.get(DataConstants.OPERATION_START_TIME)));
                } else {
                    return false;
                }
            } else {
                return false;
            }

            // 检查是否有deviceInformation,没有直接返回false
            if (dataMap.containsKey(DataConstants.DEVICE_INFORMATION)) {
                deviceInformation = (List<Map<String, Object>>) dataMap.get(DataConstants.DEVICE_INFORMATION);
            } else {
                return false;
            }
        } catch (ClassCastException | NumberFormatException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Data property parsing error", exception.toString(), parseDataDTO.toString());
        }

        OperationInformationDO operationInformationDO = new OperationInformationDO();
        operationInformationDO.setOperationNumber(operationNumber);
        operationInformationDO.setCollectorMacAddress(parseDataDTO.getMacAddress());
        operationInformationDO.setPatientId(patientId);
        operationInformationDO.setOperationHospitalCode(operationHospitalCode);
        operationInformationDO.setDeviceInformation(deviceInformation);
        operationInformationDO.setOperationStartTime(operationStartTime);
        operationInformationDO.setOperationEndTime(null);
        operationInformationDO.setOperationState(OperationStateEnum.IN_PREPARATION.getCode());
        operationInformationDO.setGmtCreate(new Date());
        operationInformationDO.setGmtModified(new Date());

        OperationInformationDO result = this.saveOperationInformationDO(operationInformationDO);
        if (null == result) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Data save error", DataConstants.SAVE_ERROR, operationInformationDO.toString());
        } else {
            log.info("Insert the success :{}", operationInformationDO.toString());
            return true;
        }
    }

    @Override
    public boolean updateOperationInformationDO(ParseDataDTO parseDataDTO) {
        if (null == parseDataDTO) {
            return false;
        }

        // 通过operationNumber先查询出存储的数据，如果没有也将会报错
        int operationNumber = parseDataDTO.getOperationNumber();
        OperationInformationDO operationInformationDO;
        try {
            operationInformationDO = operationInformationRepository.findOperationInformationDOByOperationNumber(operationNumber);
        } catch (IncorrectResultSizeDataAccessException e) {
            return false;
        }

        if (null == operationInformationDO) {
            return false;
        }

        // 重新设定该条数据修改时间
        operationInformationDO.setGmtModified(new Date());

        Map dataMap = parseDataDTO.getDataMap();

        Date operationEndTime;
        try {
            // 检查是否有operationEndTime,没有直接返回false
            if (dataMap.containsKey(DataConstants.OPERATION_END_TIME)) {
                operationEndTime = new Date(Long.parseLong((String) dataMap.get(DataConstants.OPERATION_END_TIME)));
            } else {
                return false;
            }

        } catch (ClassCastException | NumberFormatException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Data property parsing error", exception.toString(), parseDataDTO.toString());
        }

        operationInformationDO.setOperationEndTime(operationEndTime);

        operationInformationDO.setOperationTime(operationEndTime.getTime() - operationInformationDO.getOperationStartTime().getTime());

        this.saveOperationInformationDO(operationInformationDO);
        log.info("Update the success :{}", operationInformationDO.toString());
        return true;
    }

    @Override
    public Integer countOperationInformationDOS() {
        return operationInformationRepository.countOperationInformationDOS();
    }

}
