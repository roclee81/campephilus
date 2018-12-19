package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationMarkDO;
import org.springframework.data.domain.Page;
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
     * @return
     */
    Page<OperationMarkDO> findOperationMarkDOSByOperationNumber(Integer operationNumber);

    /**
     * @param operationNumber
     * @param markType
     * @return
     */
    Page<OperationMarkDO> findOperationMarkDOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType);

    /**
     * @param markTimeBefore
     * @return
     */
    Page<OperationMarkDO> findOperationMarkDOSByMarkTimeBefore(Date markTimeBefore);

    /**
     * @param markTimeAfter
     * @return
     */
    Page<OperationMarkDO> findOperationMarkDOSByMarkTimeAfter(Date markTimeAfter);

    /**
     * @param markTimeBefore
     * @param markTimeAfter
     * @return
     */
    Page<OperationMarkDO> findOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter);
}
