package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.OperationInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * campephilus
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
    Page<OperationInformationDO> listOperationInformationDOSByPatientId(String patientId, Pageable pageable);

    /**
     * 通过患者的ID查询PatientIdOperationNumberDTO信息
     *
     * @param patientId 患者的ID
     * @param pageable  分页信息
     * @return PatientIdOperationNumberDTO分页信息
     */
    List<OperationInformationDTO> listOperationInformationDTOSByPatientId(String patientId, Pageable pageable);

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
     * 通过手术顺序号查询OperationInformationDTO信息
     * operationNumber唯一，所以数据查询到的信息也是唯一的
     * 若有多个值，将会返回null
     *
     * @param operationNumber 手术顺序号
     * @return OperationInformationDTO分页信息
     */
    OperationInformationDTO getOperationInformationDTOByOperationNumber(Integer operationNumber);

    /**
     * 通过输入的手术开始时间的查询这一段时间的所有数据
     *
     * @param operationStartTimeBefore 手术开始的时间之前
     * @param operationStartTimeAfter  手术开始的时间之后
     * @param pageable                 分页信息
     * @return OperationInformationDO的分页信息
     */
    Page<OperationInformationDO> listOperationInformationDOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术开始时间的查询这一段时间的所有数据
     *
     * @param operationStartTimeBefore 手术开始的时间之前
     * @param operationStartTimeAfter  手术开始的时间之后
     * @param pageable                 分页信息
     * @return OperationInformationDTO的分页信息
     */
    List<OperationInformationDTO> listOperationInformationDTOSByOperationStartTimeBetween(Date operationStartTimeBefore, Date operationStartTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术进行时间的查询这一段时间的所有数据
     *
     * @param operationTimeBefore 手术进行时间之前
     * @param operationTimeAfter  手术进行时间之前
     * @param pageable            分页信息
     * @return OperationInformationDO的分页信息
     */
    Page<OperationInformationDO> listOperationInformationDOSByOperationTimeBetween(Long operationTimeBefore, Long operationTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术进行时间的查询这一段时间的所有数据
     *
     * @param operationTimeBefore 手术进行时间之前
     * @param operationTimeAfter  手术进行时间之前
     * @param pageable            分页信息
     * @return OperationInformationDTO的分页信息
     */
    List<OperationInformationDTO> listOperationInformationDTOSByOperationTimeBetween(Long operationTimeBefore, Long operationTimeAfter, Pageable pageable);

    /**
     * 得到所有的OperationInformationDO信息
     *
     * @param pageable 分页信息
     * @return OperationInformationDO的分页信息
     */
    Page<OperationInformationDO> listOperationInformationDOS(Pageable pageable);

    /**
     * 得到所有的OperationInformationDTO的信息
     *
     * @param pageable 分页信息
     * @return OperationInformationDTO的分页信息
     */
    List<OperationInformationDTO> listOperationInformationDTOS(Pageable pageable);

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
    Integer countOperationInformationDOS();

}
