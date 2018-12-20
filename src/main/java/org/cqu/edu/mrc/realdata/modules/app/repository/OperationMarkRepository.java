package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationMarkDO;
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
 * @date 2018/12/19 20:45
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface OperationMarkRepository extends MongoRepository<OperationMarkDO, String> {

    /**
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<OperationMarkDO> findOperationMarkDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * @param operationNumber
     * @param markType
     * @param pageable
     * @return
     */
    Page<OperationMarkDO> findOperationMarkDOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable);

    /**
     * @param markTimeBefore
     * @param pageable
     * @return
     */
    Page<OperationMarkDO> findOperationMarkDOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable);

    /**
     * @param markTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationMarkDO> findOperationMarkDOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable);

    /**
     * @param markTimeBefore
     * @param markTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationMarkDO> findOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable);
}
