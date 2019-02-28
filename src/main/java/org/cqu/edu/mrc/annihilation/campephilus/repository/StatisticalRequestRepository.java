package org.cqu.edu.mrc.annihilation.campephilus.repository;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalRequestDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/25 21:43
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface StatisticalRequestRepository extends MongoRepository<StatisticalRequestDO, String> {

    /**
     * 通过存储日期找到对应日期的StatisticalRequestDO数据
     *
     * @param statisticalDate 统计的日期，例如：2019-02-25
     * @return 对应日期的StatisticalRequestDO数据，如果没有为null
     */
    StatisticalRequestDO findStatisticalRequestDOByStatisticalDate(String statisticalDate);

    /**
     * 通过对应的数据创建的时间区间找到对应的Page<StatisticalRequestDO>
     *
     * @param gmtCreateBefore 创建时间左区间
     * @param gmtCreateAfter  创建时间右区间
     * @param pageable        分页信息
     * @return 如果找到则返回Page<StatisticalRequestDO>，如果没找到则返回空的Page
     */
    Page<StatisticalRequestDO> findStatisticalRequestDOByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable);

    /**
     * 通过对应的数据修改的时间区间找到对应的Page<StatisticalRequestDO>
     *
     * @param gmtModifiedBefore 修改时间左区间
     * @param gmtModifiedAfter  修改时间右区间
     * @param pageable          分页信息
     * @return 如果找到则返回Page<StatisticalRequestDO>，如果没找到则返回空的Page
     */
    Page<StatisticalRequestDO> findStatisticalRequestDOByGmtModifiedBetween(Date gmtModifiedBefore, Date gmtModifiedAfter, Pageable pageable);

    /**
     * 查询最后一条数据
     *
     * @return StatisticalRequestDO实体
     */
    StatisticalRequestDO findFirstByOrderByIdDesc();
}
