package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationDeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * @param operationDeviceDO
     */
    void saveOperationDeviceDO(OperationDeviceDO operationDeviceDO);

    /**
     * @param parseDataDTO
     * @return
     */
    boolean saveOperationDeviceDO(ParseDataDTO parseDataDTO);

    /**
     * @param operationNumber
     * @return
     */
    OperationDeviceDO getOperationDeviceDOSByOperationNumber(Integer operationNumber);

    /**
     * @param macAddress
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByCollectorMacAddress(String macAddress, Pageable pageable);

    /**
     * @param operationHospitalCode
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByOperationHospitalCode(Integer operationHospitalCode, Pageable pageable);

    /**
     * @param operationStartTimeBefore
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByOperationStartTimeBefore(Date operationStartTimeBefore, Pageable pageable);

    /**
     * @param operationStartTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByOperationStartTimeAfter(Date operationStartTimeAfter, Pageable pageable);

    /**
     * @param operationStartTimeBefore
     * @param operationStartTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable);

    /**
     * @param operationTimeBefore
     * @param operationTimeAfter
     * @param pageable
     * @return
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByOperationTimeBetween(Date operationTimeBefore, Date operationTimeAfter, Pageable pageable);
}
