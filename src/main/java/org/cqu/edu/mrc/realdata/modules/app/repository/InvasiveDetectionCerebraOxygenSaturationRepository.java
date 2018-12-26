package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionBloodPressureDO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionCerebraOxygenSaturationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface InvasiveDetectionCerebraOxygenSaturationRepository extends MongoRepository<InvasiveDetectionCerebraOxygenSaturationDO, String> {

    /**
     *
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionCerebraOxygenSaturationDO> findInvasiveDetectionCerebraOxygenSaturationDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     *
     * @param updateTimeBefore
     * @param updateTimeAfter
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionCerebraOxygenSaturationDO> findInvasiveDetectionCerebraOxygenSaturationDOSByUpdateTimeBetween(Date updateTimeBefore, Date updateTimeAfter, Pageable pageable);

}