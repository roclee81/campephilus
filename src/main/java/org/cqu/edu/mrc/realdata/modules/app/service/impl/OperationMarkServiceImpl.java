package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationMarkDO;
import org.cqu.edu.mrc.realdata.modules.app.repository.OperationMarkRepository;
import org.cqu.edu.mrc.realdata.modules.app.service.OperationMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBefore(markTimeBefore,pageable);
    }

    @Override
    public Page<OperationMarkDO> getOperationMarkDOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeAfter(markTimeAfter, pageable);
    }

    @Override
    public Page<OperationMarkDO> getOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable) {
        return operationMarkRepository.findOperationMarkDOSByMarkTimeBetween(markTimeBefore, markTimeAfter, pageable);
    }
}
