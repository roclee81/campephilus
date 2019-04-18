package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.OperationMarkRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.OperationInformationService;
import org.cqu.edu.msc.annihilation.campephilus.module.app.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.OperationMarkDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.OperationMarkService;
import org.cqu.edu.msc.annihilation.campephilus.module.app.utils.CheckStateUtil;
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
    public OperationMarkInfo getOperationMarkDOByOperationNumberAndMarkNumberAndCollectorMacAddress(Integer operationNumber, Integer markNumber, String collectorMacAddress) {
        return operationMarkRepository.findOperationMarkDOByOperationNumberAndMarkNumberAndCollectorMacAddress(operationNumber, markNumber, collectorMacAddress);
    }

    @Override
    public Page<OperationMarkInfo> listOperationMarkDOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByOperationNumber(operationNumber, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        Page<OperationMarkInfo> operationMarkDOPage = this.listOperationMarkDOSByOperationNumber(operationNumber, pageable);
        return ConvertUtil.convert(operationMarkDOPage, OperationMarkDTO.class);
    }

    @Override
    public Page<OperationMarkInfo> listOperationMarkDOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByOperationNumberAndMarkType(operationNumber, markType, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable) {
        Page<OperationMarkInfo> operationMarkDOPage = this.listOperationMarkDOSByOperationNumberAndMarkType(operationNumber, markType, pageable);
        return ConvertUtil.convert(operationMarkDOPage, OperationMarkDTO.class);
    }

    @Override
    public Page<OperationMarkInfo> listOperationMarkDOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBefore(markTimeBefore, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable) {
        Page<OperationMarkInfo> operationMarkDOPage = this.listOperationMarkDOSByMarkTimeBefore(markTimeBefore, pageable);
        return ConvertUtil.convert(operationMarkDOPage, OperationMarkDTO.class);
    }

    @Override
    public Page<OperationMarkInfo> listOperationMarkDOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeAfter(markTimeAfter, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable) {
        Page<OperationMarkInfo> operationMarkDOPage = this.listOperationMarkDOSByMarkTimeAfter(markTimeAfter, pageable);
        return ConvertUtil.convert(operationMarkDOPage, OperationMarkDTO.class);
    }

    @Override
    public Page<OperationMarkInfo> listOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBetween(markTimeBefore, markTimeAfter, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable) {
        Page<OperationMarkInfo> operationMarkDOPage = this.listOperationMarkDOSByMarkTimeBetween(markTimeBefore, markTimeAfter, pageable);
        return ConvertUtil.convert(operationMarkDOPage, OperationMarkDTO.class);
    }

    @Override
    public boolean saveOperationMarkDO(OperationMarkInfo operationMarkInfo) {
        // 首先查询是否存在该条数据
        OperationMarkInfo searchResult = getOperationMarkDOByOperationNumberAndMarkNumberAndCollectorMacAddress(
                operationMarkInfo.getOperationNumber(),
                operationMarkInfo.getMarkNumber(),
                operationMarkInfo.getCollectorMacAddress());

        CheckStateUtil.checkState(searchResult, operationInformationService, operationMarkInfo.getOperationNumber());

        OperationMarkInfo result = operationMarkRepository.save(operationMarkInfo);
        SaveException.checkSaveSuccess(result, operationMarkInfo);
        return true;
    }

    @Override
    public boolean saveOperationMarkDO(ParseDataDTO parseDataDTO) {
        OperationMarkInfo parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, OperationMarkInfo.class);
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
