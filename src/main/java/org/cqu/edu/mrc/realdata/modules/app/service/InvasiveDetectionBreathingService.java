package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionBreathingDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 14:58
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface InvasiveDetectionBreathingService {

    /**
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionBreathingDO> getInvasiveDetectionBreathingDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * @param updateTimeBefore
     * @param updateTimeAfter
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionBreathingDO> getInvasiveDetectionBreathingDOSByUpdateTimeBetween(Date updateTimeBefore, Date updateTimeAfter, Pageable pageable);

}
