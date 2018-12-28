package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionAnesthesiaDO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.InvasiveDetectionBloodPressureDO;
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
 * @date 2018/12/20 14:57
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface InvasiveDetectionBloodPressureRepository extends MongoRepository<InvasiveDetectionBloodPressureDO, String> {

    /**
     * 通过手术顺序号查询该手术中的有创检测的数据
     *
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return InvasiveDetectionBloodPressureDO的分页信息
     */
    Page<InvasiveDetectionBloodPressureDO> findInvasiveDetectionBloodPressureDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * 查询数据上传时间在输入范围内的数据
     *
     * @param gmtCreateBefore 待查询的之前数据创建时间
     * @param gmtCreateAfter  待查询的之后数据创建时间
     * @param pageable        分页信息
     * @return InvasiveDetectionBloodPressureDO的分页信息
     */
    Page<InvasiveDetectionBloodPressureDO> findInvasiveDetectionBloodPressureDOSByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable);

}
