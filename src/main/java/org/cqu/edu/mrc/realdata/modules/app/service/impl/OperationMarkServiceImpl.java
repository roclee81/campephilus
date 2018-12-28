package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationDeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationMarkDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.repository.OperationMarkRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.OperationMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Page<OperationMarkDO> getOperationMarkDOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByOperationNumberAndMarkType(operationNumber, markType, pageable);
    }

    @Override
    public Page<OperationMarkDO> getOperationMarkDOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBefore(markTimeBefore, pageable);
    }

    @Override
    public Page<OperationMarkDO> getOperationMarkDOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeAfter(markTimeAfter, pageable);
    }

    @Override
    public Page<OperationMarkDO> getOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBetween(markTimeBefore, markTimeAfter, pageable);
    }

    @Override
    public void saveOperationMarkDO(OperationMarkDO operationMarkDO) {
        operationMarkRepository.save(operationMarkDO);
    }

    @Override
    public boolean saveOperationMarkDO(ParseDataDTO parseDataDTO) {
        if (null == parseDataDTO) {
            return false;
        }

        Map dataMap = parseDataDTO.getDataMap();
        int operationNumber = parseDataDTO.getOperationNumber();

        int markNumber, markType;
        Map deviceData;

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
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            log.error("ParseDataDTO:{},Exception:{}", parseDataDTO.toString(), exception.toString());
            return false;
        }

        OperationMarkDO operationMarkDO = new OperationMarkDO(operationNumber, markNumber, markType, deviceData, new Date());
        this.saveOperationMarkDO(operationMarkDO);
        return true;
    }
}
