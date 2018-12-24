package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionBloodPressureDO;
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
 * @date 2018/12/20 14:57
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface InvasiveDetectionBloodPressureService {

    /**
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionBloodPressureDO> getInvasiveDetectionBloodPressureDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * @param updateTimeBefore
     * @param updateTimeAfter
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionBloodPressureDO> getInvasiveDetectionBloodPressureDOSByUpdateTimeBetween(Date updateTimeBefore, Date updateTimeAfter, Pageable pageable);

}
