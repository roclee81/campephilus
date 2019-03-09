package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.convertor.OperationMarkDOConvertOperationMarkDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.OperationMarkDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.OperationMarkDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.OperationStateEnum;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;
import org.cqu.edu.mrc.annihilation.campephilus.repository.OperationMarkRepository;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.service.OperationMarkService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2018/12/24 17:47
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
@Slf4j
public class OperationMarkServiceImpl implements OperationMarkService {

    private final OperationMarkRepository operationMarkRepository;

    @Autowired
    public OperationMarkServiceImpl(OperationMarkRepository operationMarkRepository) {
        this.operationMarkRepository = operationMarkRepository;
    }

    @Override
    public Page<OperationMarkDO> listOperationMarkDOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByOperationNumber(operationNumber, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.listOperationMarkDOSByOperationNumber(operationNumber, pageable);
        return OperationMarkDOConvertOperationMarkDTO.convert(operationMarkDOPage);
    }

    @Override
    public Page<OperationMarkDO> listOperationMarkDOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByOperationNumberAndMarkType(operationNumber, markType, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.listOperationMarkDOSByOperationNumberAndMarkType(operationNumber, markType, pageable);
        return OperationMarkDOConvertOperationMarkDTO.convert(operationMarkDOPage);
    }

    @Override
    public Page<OperationMarkDO> listOperationMarkDOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBefore(markTimeBefore, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.listOperationMarkDOSByMarkTimeBefore(markTimeBefore, pageable);
        return OperationMarkDOConvertOperationMarkDTO.convert(operationMarkDOPage);
    }

    @Override
    public Page<OperationMarkDO> listOperationMarkDOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeAfter(markTimeAfter, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.listOperationMarkDOSByMarkTimeAfter(markTimeAfter, pageable);
        return OperationMarkDOConvertOperationMarkDTO.convert(operationMarkDOPage);
    }

    @Override
    public Page<OperationMarkDO> listOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBetween(markTimeBefore, markTimeAfter, pageable);
    }

    @Override
    public List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.listOperationMarkDOSByMarkTimeBetween(markTimeBefore, markTimeAfter, pageable);
        return OperationMarkDOConvertOperationMarkDTO.convert(operationMarkDOPage);
    }

    @Override
    public boolean saveOperationMarkDO(OperationMarkDO operationMarkDO) {
        // TODO 不知道如何处理保存是否需要验证
        operationMarkRepository.save(operationMarkDO);
        return true;
    }

    @Override
    public boolean saveOperationMarkDO(ParseDataDTO parseDataDTO) {

        OperationMarkDO parseResult = parseParseDataDTOJsonData(parseDataDTO);
        if (null == parseResult) {
            return false;
        }
        if (parseResult.getMarkType() == null || parseResult.getMarkMessage() == null) {
            return false;
        }

        parseResult.setDataState(Boolean.FALSE);
        parseResult.setGmtCreate(new Date());
        parseResult.setGmtModified(new Date());

        return this.saveOperationMarkDO(parseResult);
    }

    private OperationMarkDO parseParseDataDTOJsonData(ParseDataDTO parseDataDTO) {
        OperationMarkDO operationMarkDO;
        try {
            operationMarkDO = new Gson().fromJson(parseDataDTO.getJsonData(), OperationMarkDO.class);
        } catch (JsonSyntaxException exception) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR, exception.toString(), parseDataDTO.toString());
        }
        operationMarkDO.setOperationNumber(parseDataDTO.getOperationNumber());
        operationMarkDO.setCollectorMacAddress(parseDataDTO.getMacAddress());
        return operationMarkDO;
    }
}
