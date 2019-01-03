package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationInformationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * realdata
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
     * 通过手术顺序号查询OperationInformationNumberDO信息
     * 由于手术顺序号唯一，所以结果只会有一个，如果查询到的结果有多个将会返回null
     *
     * @param operationNumber 手术顺序号
     * @return OperationInformationDO分页信息
     */
    OperationInformationDO findOperationInformationDOByOperationNumber(Integer operationNumber);

    /**
     * 得到所有的OperationInformationDO信息
     *
     * @param pageable 分页信息
     * @return OperationInformationDO分页信息
     */
    Page<OperationInformationDO> findAll(Pageable pageable);

    /**
     * 保存OperationInformationDO
     *
     * @param operationInformationDO OperationInformationDO信息
     */
    void saveOperationInformationDO(OperationInformationDO operationInformationDO);

    /**
     * 统计OperationInformationDO表中的记录的条数
     *
     * @return OperationInformationDO表中的记录的条数
     */
    Integer countAll();
}
