package org.cqu.edu.mrc.annihilation.campephilus.repository;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.OperationInformationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 22:44
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationInformationRepository {

    /**
     * 通过患者的ID查询OperationInformationNumberDO信息
     *
     * @param patientId 患者的ID
     * @param pageable  分页信息
     * @return OperationInformationDO分页信息
     */
    Page<OperationInformationDO> findOperationInformationDOSByPatientId(String patientId, Pageable pageable);

    /**
     * 通过采集器的MAC地址查询采集器上传的信息
     *
     * @param collectorMacAddress 采集器的MAC地址
     * @param pageable            分页信息
     * @return OperationInformationDO的分页信息
     */
    Page<OperationInformationDO> findOperationInformationDOSByCollectorMacAddress(String collectorMacAddress, Pageable pageable);

    /**
     * 通过手术顺序号查询OperationInformationNumberDO信息
     * 由于手术顺序号唯一，所以结果只会有一个，如果查询到的结果有多个将会返回null
     *
     * @param operationNumber 手术顺序号
     * @return OperationInformationDO分页信息
     */
    OperationInformationDO findOperationInformationDOByOperationNumber(Integer operationNumber);

    /**
     * 通过医院代码查询OperationInformationNumberDO信息
     *
     * @param operationHospitalCode 医院代码
     * @param pageable              分页信息
     * @return OperationInformationDO分页信息
     */
    Page<OperationInformationDO> findOperationInformationDOSByOperationHospitalCode(String operationHospitalCode, Pageable pageable);

    /**
     * 通过输入的手术开始时间的查询这一段时间的所有数据
     *
     * @param operationStartTimeBefore 手术开始的时间之前
     * @param operationStartTimeAfter  手术开始的时间之后
     * @param pageable                 分页信息
     * @return OperationInformationDO的分页信息
     */
    Page<OperationInformationDO> findOperationInformationDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术进行时间的查询这一段时间的所有数据
     *
     * @param operationTimeBefore 手术进行时间之前
     * @param operationTimeAfter  手术进行时间之前
     * @param pageable            分页信息
     * @return OperationInformationDO的分页信息
     */
    Page<OperationInformationDO> findOperationInformationDOSByOperationTimeBetween(Long operationTimeBefore, Long operationTimeAfter, Pageable pageable);

    /**
     * 得到所有的OperationInformationDO信息
     *
     * @param pageable 分页信息
     * @return OperationInformationDO分页信息
     */
    Page<OperationInformationDO> findOperationInformationDOS(Pageable pageable);

    /**
     * 保存OperationInformationDO
     *
     * @param operationInformationDO operationInformationDO OperationInformationDO信息
     * @return operationInformationDO 则保存完成，null则失败
     */
    OperationInformationDO saveOperationInformationDO(OperationInformationDO operationInformationDO);

    /**
     * 统计OperationInformationDO表中的记录的条数
     * 这里使用synchronized锁保证同步性
     *
     * @return OperationInformationDO表中的记录的条数
     */
    Integer countOperationInformationDOS();
}
