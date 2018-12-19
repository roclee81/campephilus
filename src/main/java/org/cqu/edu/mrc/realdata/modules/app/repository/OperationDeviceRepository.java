package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationDeviceDO;
import org.springframework.data.domain.Page;
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
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByCollectorMacAddress(String macAddress);

    /**
     * @param operationHospitalCode
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationHospitalCode(Integer operationHospitalCode);

    /**
     * @param operationStartTimeBefore
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationStartTimeBefore(Date operationStartTimeBefore);

    /**
     * @param operationStartTimeAfter
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationStartTimeAfter(Date operationStartTimeAfter);

    /**
     * @param operationStartTimeBefore
     * @param operationStartTimeAfter
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter);

    /**
     * @param operationTimeBefore
     * @param operationTimeAfter
     * @return
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationTimeBetween(Date operationTimeBefore, Date operationTimeAfter);
}
