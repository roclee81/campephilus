package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.InvasiveDetectionCerebraOxygenSaturationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 14:58
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface InvasiveDetectionCerebraOxygenSaturationService {

    /**
     * 通过手术顺序号查询该手术中的有创检测的数据
     *
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return InvasiveDetectionCerebraOxygenSaturationDO的分页信息
     */
    Page<InvasiveDetectionCerebraOxygenSaturationDO> getInvasiveDetectionCerebraOxygenSaturationDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * 查询数据上传时间在输入范围内的数据
     *
     * @param gmtCreateBefore 待查询的之前数据创建时间
     * @param gmtCreateAfter  待查询的之后数据创建时间
     * @param pageable        分页信息
     * @return InvasiveDetectionCerebraOxygenSaturationDO的分页信息
     */
    Page<InvasiveDetectionCerebraOxygenSaturationDO> getInvasiveDetectionCerebraOxygenSaturationDOSByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable);

}