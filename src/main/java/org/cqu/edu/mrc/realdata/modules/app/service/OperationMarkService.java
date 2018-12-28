package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationMarkDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
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
 * @date 2018/12/19 20:45
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface OperationMarkService {

    /**
     * 通过手术顺序号查询该手术的所有标记信息
     *
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return OperationMarkDO的分页信息
     */
    Page<OperationMarkDO> getOperationMarkDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * 通过手术顺序号和手术标记的类型查询所有标记信息
     *
     * @param operationNumber 手术顺序号
     * @param markType        手术标记的类型
     * @param pageable        分页信息
     * @return OperationMarkDO的分页信息
     */
    Page<OperationMarkDO> getOperationMarkDOSByOperationNumberAndMarkType(Integer operationNumber, Integer markType, Pageable pageable);

    /**
     * 通过输入的手术标记的时间查询之前的所有标记信息
     *
     * @param markTimeBefore 手术标记的时间
     * @param pageable       分页信息
     * @return OperationMarkDO的分页信息
     */
    Page<OperationMarkDO> getOperationMarkDOSByMarkTimeBefore(Date markTimeBefore, Pageable pageable);

    /**
     * 通过输入的手术标记的时间查询之后的所有标记信息
     *
     * @param markTimeAfter 手术标记时间
     * @param pageable      分页信息
     * @return OperationMarkDO的分页信息
     */
    Page<OperationMarkDO> getOperationMarkDOSByMarkTimeAfter(Date markTimeAfter, Pageable pageable);

    /**
     * 通过输入的手术标记的时间查询中间一段时间的所有标记信息
     *
     * @param markTimeBefore 手术标记时间之前
     * @param markTimeAfter  手术标记时间之后
     * @param pageable       分页信息
     * @return OperationMarkDO的分页信息
     */
    Page<OperationMarkDO> getOperationMarkDOSByMarkTimeBetween(Date markTimeBefore, Date markTimeAfter, Pageable pageable);

    /**
     * 保存数据
     * @param operationMarkDO operationMarkDO实体
     */
    void saveOperationMarkDO(OperationMarkDO operationMarkDO);

    /**
     * 通过ParseDataDTO中的信息解析后得到OperationMarkDO来保存信息
     * @param parseDataDTO 初次解析的数据
     * @return 是否保存成功
     */
    boolean saveOperationMarkDO(ParseDataDTO parseDataDTO);

}
