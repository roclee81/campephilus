package org.cqu.edu.msc.annihilation.campephilus.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.core.dataobject.OperationMarkDO;
import org.cqu.edu.msc.annihilation.campephilus.core.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.core.repository.OperationMarkRepository;
import org.cqu.edu.msc.annihilation.campephilus.core.service.OperationInformationService;
import org.cqu.edu.msc.annihilation.campephilus.core.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.core.dto.OperationMarkDTO;
import org.cqu.edu.msc.annihilation.campephilus.core.service.OperationMarkService;
import org.cqu.edu.msc.annihilation.campephilus.core.utils.CheckStateUtil;
import org.cqu.edu.msc.annihilation.common.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2018/12/24 17:47
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
@Slf4j
public class OperationMarkServiceImpl implements OperationMarkService {

    private final OperationMarkRepository operationMarkRepository;
    private final OperationInformationService operationInformationService;

    @Autowired
    public OperationMarkServiceImpl(OperationMarkRepository operationMarkRepository, OperationInformationService operationInformationService) {
        this.operationMarkRepository = operationMarkRepository;
        this.operationInformationService = operationInformationService;
    }

    @Override
    public OperationMarkDO getOperationMarkDOByOperationNumberAndMarkNumberAndCollectorMacAddress(Integer operationNumber, Integer markNumber, String collectorMacAddress) {
        return operationMarkRepository.findOperationMarkDOByOperationNumberAndMarkNumberAndCollectorMacAddress(operationNumber, markNumber, collectorMacAddress);
    }

    @Override
    public Page<OperationMarkDO> listOperationMarkDOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByOperationNumber(operationNumber, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.listOperationMarkDOSByOperationNumber(operationNumber, pageable);
        return ConvertUtil.convert(operationMarkDOPage, OperationMarkDTO.class);
    }

    @Override
    public Page<OperationMarkDO> listOperationMarkDOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByOperationNumberAndMarkType(operationNumber, markType, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.listOperationMarkDOSByOperationNumberAndMarkType(operationNumber, markType, pageable);
        return ConvertUtil.convert(operationMarkDOPage, OperationMarkDTO.class);
    }

    @Override
    public Page<OperationMarkDO> listOperationMarkDOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBefore(markTimeBefore, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.listOperationMarkDOSByMarkTimeBefore(markTimeBefore, pageable);
        return ConvertUtil.convert(operationMarkDOPage, OperationMarkDTO.class);
    }

    @Override
    public Page<OperationMarkDO> listOperationMarkDOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeAfter(markTimeAfter, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.listOperationMarkDOSByMarkTimeAfter(markTimeAfter, pageable);
        return ConvertUtil.convert(operationMarkDOPage, OperationMarkDTO.class);
    }

    @Override
    public Page<OperationMarkDO> listOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBetween(markTimeBefore, markTimeAfter, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.listOperationMarkDOSByMarkTimeBetween(markTimeBefore, markTimeAfter, pageable);
        return ConvertUtil.convert(operationMarkDOPage, OperationMarkDTO.class);
    }

    @Override
    public boolean saveOperationMarkDO(OperationMarkDO operationMarkDO) {
        // 首先查询是否存在该条数据
        OperationMarkDO searchResult = getOperationMarkDOByOperationNumberAndMarkNumberAndCollectorMacAddress(
                operationMarkDO.getOperationNumber(),
                operationMarkDO.getMarkNumber(),
                operationMarkDO.getCollectorMacAddress());

        CheckStateUtil.checkState(searchResult, operationInformationService, operationMarkDO.getOperationNumber());

        OperationMarkDO result = operationMarkRepository.save(operationMarkDO);
        SaveException.checkSaveSuccess(result, operationMarkDO);
        return true;
    }

    @Override
    public boolean saveOperationMarkDO(ParseDataDTO parseDataDTO) {
        OperationMarkDO parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, OperationMarkDO.class);
        if (null == parseResult) {
            return false;
        }
        if (parseResult.getMarkNumber() == null || parseResult.getMarkType() == null || parseResult.getMarkMessage() == null) {
            return false;
        }

        parseResult.setDataState(Boolean.FALSE);
        return this.saveOperationMarkDO(parseResult);
    }

}
