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
public interface OperationDeviceRepository extends MongoRepository<OperationDeviceDO, String> {

    /**
     * 通过手术顺序号得到OperationDeviceDO
     *
     * @param operationNumber 手术顺序号
     * @return OperationDeviceDO
     */
    OperationDeviceDO findOperationDeviceDOSByOperationNumber(Integer operationNumber);

    /**
     * 通过采集器的MAC地址查询OperationDeviceDO数据
     *
     * @param collectorMacAddress 采集器的MAC地址
     * @param pageable            分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByCollectorMacAddress(String collectorMacAddress, Pageable pageable);

    /**
     * 通过手术执行医院的代码得到手术的设备信息OperationDeviceDO
     *
     * @param operationHospitalCode 医院的代码
     * @param pageable              分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationHospitalCode(String operationHospitalCode, Pageable pageable);

    /**
     * 通过输入的手术开始时间的查询之前的所有数据
     *
     * @param operationStartTimeBefore 手术开始的时间
     * @param pageable                 分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationStartTimeBefore(Date operationStartTimeBefore, Pageable pageable);

    /**
     * 通过输入的手术开始时间的查询之后的所有数据
     *
     * @param operationStartTimeAfter 手术开始的时间
     * @param pageable                分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationStartTimeAfter(Date operationStartTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术开始时间的查询这一段时间的所有数据
     *
     * @param operationStartTimeBefore 手术开始的时间之前
     * @param operationStartTimeAfter  手术开始的时间之后
     * @param pageable                 分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术进行时间的查询这一段时间的所有数据
     *
     * @param operationTimeBefore 手术进行时间之前
     * @param operationTimeAfter  手术进行时间之前
     * @param pageable            分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByOperationTimeBetween(Date operationTimeBefore, Date operationTimeAfter, Pageable pageable);
}
