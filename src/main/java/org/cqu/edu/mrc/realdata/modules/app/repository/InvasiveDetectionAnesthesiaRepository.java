package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionAnesthesiaDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
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
@Repository
public interface InvasiveDetectionAnesthesiaRepository extends MongoRepository<InvasiveDetectionAnesthesiaDO, String> {

    /**
     *
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionAnesthesiaDO> findInvasiveDetectionAnesthesiaDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     *
     * @param updateTimeBefore
     * @param updateTimeAfter
     * @param pageable
     * @return
     */
    Page<InvasiveDetectionAnesthesiaDO> findInvasiveDetectionAnesthesiaDOSByUpdateTimeBetween(Date updateTimeBefore, Date updateTimeAfter, Pageable pageable);
}
