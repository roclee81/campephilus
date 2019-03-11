package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.enums.OperationStateEnum;
import org.cqu.edu.mrc.annihilation.campephilus.convertor.OperationInformationDOConvertOperationInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.repository.OperationInformationRepository;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;
import org.cqu.edu.mrc.annihilation.campephilus.dto.OperationInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.service.OperationInformationService;
import org.cqu.edu.mrc.annihilation.campephilus.utils.ParseJsonUtil;
import org.cqu.edu.mrc.annihilation.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public Page<OperationInformationDO> listOperationInformationDOSByOperationState(Integer operationState, Pageable pageable) {
        return operationInformationRepository.findOperationInformationDOSByOperationState(operationState, pageable);
    }

    @Override
    public List<OperationInformationDTO> listOperationInformationDTOSByPatientId(String patientId, Pageable pageable) {
        Page<OperationInformationDO> operationInformationDOPage = this.listOperationInformationDOSByPatientId(patientId, pageable);
        return OperationInformationDOConvertOperationInformationDTO.convert(operationInformationDOPage);
    }

    @Override
    public boolean checkOperationState(Integer operationNumber) {
        OperationInformationDO searchResult = this.getOperationInformationDOByOperationNumber(operationNumber);
        if (null != searchResult) {
            return !searchResult.getOperationState().equals(OperationStateEnum.FINISH.getCode());
        }
        return false;
    }

    @Override
    public OperationInformationDO getOperationInformationDOByOperationNumber(Integer operationNumber) {
        OperationInformationDO result;
        try {
            result = operationInformationRepository.findOperationInformationDOByOperationNumber(operationNumber);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
        return result;
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
    public boolean saveOperationInformationDO(OperationInformationDO operationInformationDO) {
        // 首先查询是否存在该条数据，根据operationNumber查询
        OperationInformationDO searchResult = this.getOperationInformationDOByOperationNumber(operationInformationDO.getOperationNumber());
        if (null != searchResult) {
            if (null == operationInformationDO.getId() || !operationInformationDO.getId().equals(searchResult.getId())) {
                throw new SaveException(ResponseEnum.DATA_EXISTED);
            }
        }

        OperationInformationDO result = operationInformationRepository.saveOperationInformationDO(operationInformationDO);
        SaveException.checkSaveSuccess(result, operationInformationDO);
        return true;
    }

    @Override
    public boolean saveOperationInformationDOFromParseDataDTO(ParseDataDTO parseDataDTO) {
        OperationInformationDO parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, OperationInformationDO.class);
        if (null == parseResult) {
            return false;
        }
        if (parseResult.getOperationStartTime() == null || parseResult.getOperationHospitalCode() == null || parseResult.getDeviceInformation() == null) {
            return false;
        }
        parseResult.setOperationEndTime(null);
        parseResult.setOperationState(OperationStateEnum.IN_PREPARATION.getCode());
        return this.saveOperationInformationDO(parseResult);
    }

    @Override
    public boolean updateOperationInformationDO(ParseDataDTO parseDataDTO) {
        OperationInformationDO parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, OperationInformationDO.class);
        if (null == parseResult) {
            return false;
        }

        OperationInformationDO searchResult = this.getOperationInformationDOByOperationNumber(parseDataDTO.getOperationNumber());

        if (null == searchResult) {
            throw new SaveException(ResponseEnum.OPERATION_NOT_READY);
        }

        // 手术状态已经结束就不允许上传数据了
        if (searchResult.getOperationState().equals(OperationStateEnum.FINISH.getCode())) {
            throw new SaveException(ResponseEnum.DATA_STATE_FINISHED);
        }

        // 重新设定该条数据修改时间
        searchResult.setGmtModified(new Date());

        BeanUtil.copyPropertiesTargetNotNull(parseResult, searchResult);
        searchResult.setOperationState(OperationStateEnum.FINISH.getCode());
        // TODO 没有对OperationTime进行处理，不知道有没有必要
        return this.saveOperationInformationDO(searchResult);
    }

    @Override
    public Integer countOperationInformationDOS() {
        return operationInformationRepository.countOperationInformationDOS();
    }
}
