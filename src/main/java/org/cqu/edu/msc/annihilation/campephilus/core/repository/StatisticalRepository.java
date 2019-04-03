package org.cqu.edu.msc.annihilation.campephilus.core.repository;

import org.cqu.edu.msc.annihilation.campephilus.core.dataobject.StatisticalDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/8 16:57
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface StatisticalRepository extends MongoRepository<StatisticalDO, String> {

    /**
     * 通过存储日期找到对应日期的StatisticalDO数据
     *
     * @param date 统计的日期，例如：2019-02-25
     * @return 对应日期的StatisticalDO数据，如果没有为null
     */
    StatisticalDO findStatisticalDOByDate(String date);

    /**
     * 通过对应的数据创建的时间区间找到对应的Page<StatisticalDO>
     *
     * @param gmtCreateBefore 创建时间左区间
     * @param gmtCreateAfter  创建时间右区间
     * @param pageable        分页信息
     * @return 如果找到则返回Page<StatisticalDO>，如果没找到则返回空的Page
     */
    Page<StatisticalDO> findStatisticalDOByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable);

    /**
     * 通过对应的数据修改的时间区间找到对应的Page<StatisticalDO>
     *
     * @param gmtModifiedBefore 修改时间左区间
     * @param gmtModifiedAfter  修改时间右区间
     * @param pageable          分页信息
     * @return 如果找到则返回Page<StatisticalDO>，如果没找到则返回空的Page
     */
    Page<StatisticalDO> findStatisticalDOByGmtModifiedBetween(Date gmtModifiedBefore, Date gmtModifiedAfter, Pageable pageable);

    /**
     * 得到最后一条数据，即得到当天的数据
     *
     * @return StatisticalDO
     */
    StatisticalDO findFirstByOrderByIdDesc();

    /**
     * 找到所有的信息，通过分页信息
     *
     * @param pageable 分页信息
     * @return Page<StatisticalDO>
     */
    Page<StatisticalDO> findAllByIdNotNull(Pageable pageable);

    /**
     * 统计ID不为空的数据有多少条，即统计数据有多少条
     *
     * @return 有多少条数据
     */
    Integer countStatisticalDOSByIdNotNull();
}
