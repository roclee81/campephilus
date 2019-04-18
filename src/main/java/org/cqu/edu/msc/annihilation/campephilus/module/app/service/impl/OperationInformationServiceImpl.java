package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.OperationInformationDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.enums.OperationStateEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.app.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.OperationInformationRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.OperationInformationService;
import org.cqu.edu.msc.annihilation.campephilus.module.app.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.common.utils.BeanUtil;
import org.cqu.edu.msc.annihilation.common.utils.ConvertUtil;
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
    public Page<OperationInfo> listOperationInformationDOSByPatientId(String patientId, Pageable pageable) {
        return operationInformationRepository.findOperationInformationDOSByPatientId(patientId, pageable);
    }

    @Override
    public Page<OperationInfo> listOperationInformationDOSByOperationState(Integer operationState, Pageable pageable) {
        return operationInformationRepository.findOperationInformationDOSByOperationState(operationState, pageable);
    }

    @Override
    public List<OperationInformationDTO> listOperationInformationDTOSByPatientId(String patientId, Pageable pageable) {
        Page<OperationInfo> operationInformationDOPage = this.listOperationInformationDOSByPatientId(patientId, pageable);
        return ConvertUtil.convert(operationInformationDOPage, OperationInformationDTO.class);
    }

    @Override
    public boolean checkOperationState(Integer operationNumber) {
        OperationInfo searchResult = this.getOperationInformationDOByOperationNumber(operationNumber);
        if (null != searchResult) {
            return !searchResult.getOperationState().equals(OperationStateEnum.FINISH.getCode());
        }
        return false;
    }

    @Override
    public OperationInfo getOperationInformationDOByOperationNumber(Integer operationNumber) {
        OperationInfo result;
        try {
            result = operationInformationRepository.findOperationInformationDOByOperationNumber(operationNumber);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
        return result;
    }

    @Override
    public OperationInformationDTO getOperationInformationDTOByOperationNumber(Integer operationNumber) {
        OperationInfo operationInfo = this.getOperationInformationDOByOperationNumber(operationNumber);
        return ConvertUtil.convert(operationInfo, OperationInformationDTO.class);
    }

    @Override
    public Page<OperationInfo> listOperationInformationDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable) {
        return operationInformationRepository.findOperationInformationDOSByOperationStartTimeBetween(operationStartTimeBefore, operationStartTimeAfter, pageable);
    }

    @Override
    public List<OperationInformationDTO> listOperationInformationDTOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable) {
        Page<OperationInfo> operationInformationDOPage = this.listOperationInformationDOSByOperationStartTimeBetween(operationStartTimeBefore, operationStartTimeAfter, pageable);
        return ConvertUtil.convert(operationInformationDOPage, OperationInformationDTO.class);
    }

    @Override
    public Page<OperationInfo> listOperationInformationDOSByOperationTimeBetween(Long operationTimeBefore, Long operationTimeAfter, Pageable pageable) {
        return operationInformationRepository.findOperationInformationDOSByOperationTimeBetween(operationTimeBefore, operationTimeAfter, pageable);
    }

    @Override
    public List<OperationInformationDTO> listOperationInformationDTOSByOperationTimeBetween(Long operationTimeBefore, Long operationTimeAfter, Pageable pageable) {
        Page<OperationInfo> operationInformationDOPage = this.listOperationInformationDOSByOperationTimeBetween(operationTimeBefore, operationTimeAfter, pageable);
        return ConvertUtil.convert(operationInformationDOPage, OperationInformationDTO.class);
    }

    @Override
    public Page<OperationInfo> listOperationInformationDOS(Pageable pageable) {
        return operationInformationRepository.findOperationInformationDOS(pageable);
    }

    @Override
    public List<OperationInformationDTO> listOperationInformationDTOS(Pageable pageable) {
        Page<OperationInfo> operationInformationDOPage = this.listOperationInformationDOS(pageable);
        return ConvertUtil.convert(operationInformationDOPage, OperationInformationDTO.class);
    }

    @Override
    public boolean saveOperationInformationDO(OperationInfo operationInfo) {
        // 首先查询是否存在该条数据，根据operationNumber查询
        OperationInfo searchResult = this.getOperationInformationDOByOperationNumber(operationInfo.getOperationNumber());
        if (null != searchResult) {
            if (null == operationInfo.getId() || !operationInfo.getId().equals(searchResult.getId())) {
                throw new SaveException(ResponseEnum.DATA_EXISTED);
            }
        }

        OperationInfo result = operationInformationRepository.saveOperationInformationDO(operationInfo);
        SaveException.checkSaveSuccess(result, operationInfo);
        return true;
    }

    @Override
    public boolean saveOperationInformationDOFromParseDataDTO(ParseDataDTO parseDataDTO) {
        OperationInfo parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, OperationInfo.class);
        if (null == parseResult) {
            return false;
        }
        if (parseResult.getOperationStartTime() == null || parseResult.getOperationHospitalCode() == null || parseResult.getDevice() == null) {
            return false;
        }
        parseResult.setOperationEndTime(null);
        parseResult.setOperationState(OperationStateEnum.IN_PREPARATION.getCode());
        return this.saveOperationInformationDO(parseResult);
    }

    @Override
    public boolean updateOperationInformationDO(ParseDataDTO parseDataDTO) {
        OperationInfo parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, OperationInfo.class);
        if (null == parseResult) {
            return false;
        }

        OperationInfo searchResult = this.getOperationInformationDOByOperationNumber(parseDataDTO.getOperationNumber());

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
