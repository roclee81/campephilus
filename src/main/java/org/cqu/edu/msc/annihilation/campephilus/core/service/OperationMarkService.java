package org.cqu.edu.msc.annihilation.campephilus.core.service;

import org.cqu.edu.msc.annihilation.campephilus.core.dataobject.OperationMarkDO;
import org.cqu.edu.msc.annihilation.campephilus.core.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.core.dto.OperationMarkDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:45
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationMarkService {

    /**
     * 通过operationNumber、markNumber、collectorMacAddress查询该手术的唯一标记信息
     *
     * @param operationNumber     手术顺序号
     * @param markNumber          标记顺序号
     * @param collectorMacAddress 采集器MAC地址
     * @return 如果有则返回对应的OperationMarkDO，如果不存在返回null
     */
    OperationMarkDO getOperationMarkDOByOperationNumberAndMarkNumberAndCollectorMacAddress(Integer operationNumber, Integer markNumber, String collectorMacAddress);

    /**
     * 通过手术顺序号查询该手术的所有标记信息
     *
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return OperationMarkDO的分页信息
     */
    Page<OperationMarkDO> listOperationMarkDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * 通过手术顺序号查询该手术的所有标记信息
     *
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return OperationMarkDTO列表
     */
    List<OperationMarkDTO> listOperationMarkDTOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * 通过手术顺序号和手术标记的类型查询所有标记信息
     *
     * @param operationNumber 手术顺序号
     * @param markType        手术标记的类型
     * @param pageable        分页信息
     * @return OperationMarkDO的分页信息
     */
    Page<OperationMarkDO> listOperationMarkDOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable);

    /**
     * 通过手术顺序号查询该手术的所有标记信息
     *
     * @param operationNumber 手术顺序号
     * @param markType        标记的类型
     * @param pageable        分页信息
     * @return OperationMarkDTO列表
     */
    List<OperationMarkDTO> listOperationMarkDTOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable);

    /**
     * 通过输入的手术标记的时间查询之前的所有标记信息
     *
     * @param markTimeBefore 手术标记的时间
     * @param pageable       分页信息
     * @return OperationMarkDO的分页信息
     */
    Page<OperationMarkDO> listOperationMarkDOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable);

    /**
     * 通过输入的手术标记的时间查询之前的所有标记信息
     *
     * @param markTimeBefore 手术标记的时间
     * @param pageable       分页信息
     * @return OperationMarkDTO列表
     */
    List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable);

    /**
     * 通过输入的手术标记的时间查询之后的所有标记信息
     *
     * @param markTimeAfter 手术标记时间
     * @param pageable      分页信息
     * @return OperationMarkDO的分页信息
     */
    Page<OperationMarkDO> listOperationMarkDOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术标记的时间查询之后的所有标记信息
     *
     * @param markTimeAfter 手术标记时间
     * @param pageable      分页信息
     * @return OperationMarkDTO列表T
     */
    List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术标记的时间查询中间一段时间的所有标记信息
     *
     * @param markTimeBefore 手术标记时间之前
     * @param markTimeAfter  手术标记时间之后
     * @param pageable       分页信息
     * @return OperationMarkDO的分页信息
     */
    Page<OperationMarkDO> listOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术标记的时间查询中间一段时间的所有标记信息
     *
     * @param markTimeBefore 手术标记时间之前
     * @param markTimeAfter  手术标记时间之后
     * @param pageable       分页信息
     * @return OperationMarkDTO列表
     */
    List<OperationMarkDTO> listOperationMarkDTOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable);

    /**
     * 保存数据
     *
     * @param operationMarkDO operationMarkDO实体
     * @return 保存成功为true
     */
    boolean saveOperationMarkDO(OperationMarkDO operationMarkDO);

    /**
     * 通过ParseDataDTO中的信息解析后得到OperationMarkDO来保存信息
     *
     * @param parseDataDTO 初次解析的数据
     * @return 是否保存成功
     */
    boolean saveOperationMarkDO(ParseDataDTO parseDataDTO);

}
