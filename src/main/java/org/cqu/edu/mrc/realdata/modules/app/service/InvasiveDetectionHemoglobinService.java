package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionHemoglobinDO;
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
 * @date 2018/12/20 14:59
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface InvasiveDetectionHemoglobinService {

    /**
     * 通过手术顺序号查询该手术中的有创检测的数据
     *
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return InvasiveDetectionHemoglobinDO的分页信息
     */
    Page<InvasiveDetectionHemoglobinDO> getInvasiveDetectionHemoglobinDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * 查询数据上传时间在输入范围内的数据
     *
     * @param gmtCreateBefore 待查询的之前数据创建时间
     * @param gmtCreateAfter  待查询的之后数据创建时间
     * @param pageable        分页信息
     * @return InvasiveDetectionHemoglobinDO的分页信息
     */
    Page<InvasiveDetectionHemoglobinDO> getInvasiveDetectionHemoglobinDOSByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable);


}
