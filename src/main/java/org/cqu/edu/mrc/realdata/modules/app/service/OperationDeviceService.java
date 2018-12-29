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
     * 保存operationDeviceDO
     *
     * @param operationDeviceDO operationDeviceDO实体
     */
    void saveOperationDeviceDO(OperationDeviceDO operationDeviceDO);

    /**
     * 通过ParseDataDTO中的信息解析后得到operationDeviceDO来保存信息
     *
     * @param parseDataDTO 初次解析的数据
     * @return 是否保存成功
     */
    boolean saveOperationDeviceDO(ParseDataDTO parseDataDTO);

    /**
     * 更新存储的数据
     * 先查询再根据ID存储
     * @param parseDataDTO
     * @return
     */
    boolean updateOperationDeviceDO(ParseDataDTO parseDataDTO);

    /**
     * 通过手术顺序号得到OperationDeviceDO
     *
     * @param operationNumber 手术顺序号
     * @return OperationDeviceDO
     */
    OperationDeviceDO getOperationDeviceDOSByOperationNumber(Integer operationNumber);

    /**
     * 通过采集器的MAC地址查询OperationDeviceDO数据
     *
     * @param collectorMacAddress 采集器的MAC地址
     * @param pageable            分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByCollectorMacAddress(String collectorMacAddress, Pageable pageable);

    /**
     * 通过手术执行医院的代码得到手术的设备信息OperationDeviceDO
     *
     * @param operationHospitalCode 医院的代码
     * @param pageable              分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByOperationHospitalCode(String operationHospitalCode, Pageable pageable);

    /**
     * 通过输入的手术开始时间的查询之前的所有数据
     *
     * @param operationStartTimeBefore 手术开始的时间
     * @param pageable                 分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByOperationStartTimeBefore(Date operationStartTimeBefore, Pageable pageable);

    /**
     * 通过输入的手术开始时间的查询之后的所有数据
     *
     * @param operationStartTimeAfter 手术开始的时间
     * @param pageable                分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByOperationStartTimeAfter(Date operationStartTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术开始时间的查询这一段时间的所有数据
     *
     * @param operationStartTimeBefore 手术开始的时间之前
     * @param operationStartTimeAfter  手术开始的时间之后
     * @param pageable                 分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术进行时间的查询这一段时间的所有数据
     *
     * @param operationTimeBefore 手术进行时间之前
     * @param operationTimeAfter  手术进行时间之前
     * @param pageable            分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> getOperationDeviceDOSByOperationTimeBetween(Date operationTimeBefore, Date operationTimeAfter, Pageable pageable);
}
