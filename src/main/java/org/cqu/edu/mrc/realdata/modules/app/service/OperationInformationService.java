package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
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
public interface OperationInformationService {

    /**
     * 通过患者的ID查询PatientIdOperationNumberDO信息
     *
     * @param patientId 患者的ID
     * @param pageable  分页信息
     * @return PatientIdOperationNumberDO分页信息
     */
    Page<OperationInformationDO> getOperationInformationDOSByPatientId(String patientId, Pageable pageable);

    /**
     * 通过手术顺序号查询OperationInformationDO信息
     * operationNumber唯一，所以数据查询到的信息也是唯一的
     * 若有多个值，将会返回null
     *
     * @param operationNumber 手术顺序号
     * @return OperationInformationDO分页信息
     */
    OperationInformationDO getOperationInformationDOByOperationNumber(Integer operationNumber);

    /**
     * 得到所有的OperationInformationDO信息
     *
     * @param pageable 分页信息
     * @return OperationInformationDO的分页信息
     */
    Page<OperationInformationDO> getAll(Pageable pageable);

    /**
     * 保存OperationInformationDO
     *
     * @param operationInformationDO OperationInformationDO信息
     */
    void saveOperationInformationDO(OperationInformationDO operationInformationDO);

    /**
     * 通过ParseDataDTO中的信息解析后得到OperationInformationDO来保存信息
     *
     * @param parseDataDTO 初次解析的数据
     * @return 是否保存成功
     */
    boolean saveOperationInformationDO(ParseDataDTO parseDataDTO);

    /**
     * 更新存储的数据
     * 先查询再根据ID存储
     *
     * @param parseDataDTO 初次解析的实体
     * @return 更新成功为true
     */
    boolean updateOperationInformationDO(ParseDataDTO parseDataDTO);

    /**
     * 统计OperationInformationDO表中的记录的条数
     *
     * @return OperationInformationDO表中的记录的条数
     */
    Integer countAll();

}
