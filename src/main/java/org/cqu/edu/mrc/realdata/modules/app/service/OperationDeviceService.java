package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationDeviceInformationDO;
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
 * @date 2018/12/19 20:44
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationDeviceService {

    /**
     * @param operationNumber
     * @return
     */
    OperationDeviceInformationDO getOperationDeviceInformationDOSByOperationNumber(Integer operationNumber);

    /**
     * @param macAddress
     * @param pageable
     * @return
     */
    Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByCollectorMacAddress(String macAddress, Pageable pageable);

    /**
     * @param operationHospitalCode
     * @param pageable
     * @return
     */
    Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByOperationHospitalCode(Integer operationHospitalCode, Pageable pageable);

    /**
     * @param operationStartTimeBefore
     * @param pageable
     * @return
     */
    Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByOperationStartTimeBefore(Date operationStartTimeBefore, Pageable pageable);

    /**
     * @param operationStartTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByOperationStartTimeAfter(Date operationStartTimeAfter, Pageable pageable);

    /**
     * @param operationStartTimeBefore
     * @param operationStartTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable);

    /**
     * @param operationTimeBefore
     * @param operationTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationDeviceInformationDO> getOperationDeviceInformationDOSByOperationTimeBetween(Date operationTimeBefore, Date operationTimeAfter, Pageable pageable);
}
