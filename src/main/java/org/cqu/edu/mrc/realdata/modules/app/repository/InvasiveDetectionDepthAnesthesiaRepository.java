package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionCerebraOxygenSaturationDO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionDepthAnesthesiaDO;
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
 * @date 2018/12/20 14:59
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface InvasiveDetectionDepthAnesthesiaRepository extends MongoRepository<InvasiveDetectionDepthAnesthesiaDO, String> {

    /**
     *
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionDepthAnesthesiaDO> findInvasiveDetectionDepthAnesthesiaDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     *
     * @param updateTimeBefore
     * @param updateTimeAfter
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionDepthAnesthesiaDO> findInvasiveDetectionDepthAnesthesiaDOSByUpdateTimeBetween(Date updateTimeBefore, Date updateTimeAfter, Pageable pageable);

}
