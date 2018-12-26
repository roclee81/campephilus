package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationMarkDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
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
 * @date 2018/12/19 20:45
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationMarkService {

    /**
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<OperationMarkDO> getOperationMarkDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * @param operationNumber
     * @param markType
     * @param pageable
     * @return
     */
    Page<OperationMarkDO> getOperationMarkDOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable);

    /**
     * @param markTimeBefore
     * @param pageable
     * @return
     */
    Page<OperationMarkDO> getOperationMarkDOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable);

    /**
     * @param markTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationMarkDO> getOperationMarkDOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable);

    /**
     * @param markTimeBefore
     * @param markTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationMarkDO> getOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable);

    /**
     * @param operationMarkDO
     */
    void saveOperationMarkDO(OperationMarkDO operationMarkDO);

    /**
     *
     * @param parseDataDTO
     * @return
     */
    boolean saveOperationMarkDO(ParseDataDTO parseDataDTO);

}
