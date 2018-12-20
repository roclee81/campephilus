package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationDeviceDO;
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
 * @date 2018/12/19 20:44
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface OperationDeviceRepository extends MongoRepository<OperationDeviceDO, Integer> {

    /**
     * @param operationNumber
     * @return
     */
    OperationDeviceDO findOperationDeviceDOByOperationNumber(Integer operationNumber);

    /**
     * @param macAddress
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByCollectorMacAddress(String macAddress, Pageable pageable);

    /**
     * @param operationHospitalCode
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationHospitalCode(Integer operationHospitalCode, Pageable pageable);

    /**
     * @param operationStartTimeBefore
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationStartTimeBefore(Date operationStartTimeBefore, Pageable pageable);

    /**
     * @param operationStartTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationStartTimeAfter(Date operationStartTimeAfter, Pageable pageable);

    /**
     * @param operationStartTimeBefore
     * @param operationStartTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable);

    /**
     * @param operationTimeBefore
     * @param operationTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationTimeBetween(Date operationTimeBefore, Date operationTimeAfter, Pageable pageable);
}
