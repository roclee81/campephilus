package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionDepthAnesthesiaDO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionHemoglobinDO;
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
public interface InvasiveDetectionHemoglobinRepository extends MongoRepository<InvasiveDetectionHemoglobinDO, String> {

    /**
     *
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionHemoglobinDO> findInvasiveDetectionHemoglobinDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     *
     * @param updateTimeBefore
     * @param updateTimeAfter
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionHemoglobinDO> findInvasiveDetectionHemoglobinDOSByUpdateTimeBetween(Date updateTimeBefore, Date updateTimeAfter, Pageable pageable);


}
