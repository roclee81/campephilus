package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.modules.app.convertor.OperationMarkDOConvertOperationMarkDTO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationMarkDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.OperationMarkDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.repository.OperationMarkRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.OperationMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * realdata
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
    public Page<OperationMarkDO> getOperationMarkDOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByOperationNumber(operationNumber, pageable);
    }

    @Override
    public List<OperationMarkDTO> getOperationMarkDTOSByOperationNumber(Integer operationNumber, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.getOperationMarkDOSByOperationNumber(operationNumber, pageable);
        return OperationMarkDOConvertOperationMarkDTO.convert(operationMarkDOPage);
    }

    @Override
    public Page<OperationMarkDO> getOperationMarkDOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByOperationNumberAndMarkType(operationNumber, markType, pageable);
    }

    @Override
    public List<OperationMarkDTO> getOperationMarkDTOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.getOperationMarkDOSByOperationNumberAndMarkType(operationNumber, markType, pageable);
        return OperationMarkDOConvertOperationMarkDTO.convert(operationMarkDOPage);
    }

    @Override
    public Page<OperationMarkDO> getOperationMarkDOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBefore(markTimeBefore, pageable);
    }

    @Override
    public List<OperationMarkDTO> getOperationMarkDTOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.getOperationMarkDOSByMarkTimeBefore(markTimeBefore, pageable);
        return OperationMarkDOConvertOperationMarkDTO.convert(operationMarkDOPage);
    }

    @Override
    public Page<OperationMarkDO> getOperationMarkDOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeAfter(markTimeAfter, pageable);
    }

    @Override
    public List<OperationMarkDTO> getOperationMarkDTOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.getOperationMarkDOSByMarkTimeAfter(markTimeAfter, pageable);
        return OperationMarkDOConvertOperationMarkDTO.convert(operationMarkDOPage);
    }

    @Override
    public Page<OperationMarkDO> getOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBetween(markTimeBefore, markTimeAfter, pageable);
    }

    @Override
    public List<OperationMarkDTO> getOperationMarkDTOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable) {
        Page<OperationMarkDO> operationMarkDOPage = this.getOperationMarkDOSByMarkTimeBetween(markTimeBefore, markTimeAfter, pageable);
        return OperationMarkDOConvertOperationMarkDTO.convert(operationMarkDOPage);
    }

    @Override
    public void saveOperationMarkDO(OperationMarkDO operationMarkDO) {
        operationMarkRepository.save(operationMarkDO);
    }

    @Override
    public boolean saveOperationMarkDO(ParseDataDTO parseDataDTO) {

        Map dataMap = parseDataDTO.getDataMap();
        int operationNumber = parseDataDTO.getOperationNumber();

        int markNumber, markType;
        Map deviceData;
        Date markTime;

        try {
            // 检查是否有markNumber,没有直接返回false
            if (dataMap.containsKey(DataConstants.MARK_NUMBER)) {
                markNumber = (int) (double) dataMap.get(DataConstants.MARK_NUMBER);
            } else {
                return false;
            }

            // 检查是否有markType,没有直接返回false
            if (dataMap.containsKey(DataConstants.MARK_TYPE)) {
                markType = (int) (double) dataMap.get(DataConstants.MARK_TYPE);
            } else {
                return false;
            }

            // 检查是否有deviceDataNumber,没有直接返回false
            if (dataMap.containsKey(DataConstants.MARK_MESSAGE)) {
                deviceData = (Map) dataMap.get(DataConstants.MARK_MESSAGE);
            } else {
                return false;
            }

            // 检查是否有markTime，没有直接返回false
            if (dataMap.containsKey(DataConstants.MARK_TIME)) {
                markTime = new Date(Long.parseLong((String) dataMap.get(DataConstants.MARK_TIME)));
            } else {
                return false;
            }
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            log.error("ParseDataDTO:{},Exception:{}", parseDataDTO.toString(), exception.toString());
            return false;
        }

        OperationMarkDO operationMarkDO = new OperationMarkDO(operationNumber, markNumber, markType, deviceData, markTime, new Date());
        this.saveOperationMarkDO(operationMarkDO);
        log.info("Insert the success :{}", operationMarkDO.toString());
        return true;
    }
}
