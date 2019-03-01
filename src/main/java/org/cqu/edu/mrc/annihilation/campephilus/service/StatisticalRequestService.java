package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalRequestDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.CurrentStatisticsRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/25 23:31
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface StatisticalRequestService {

    /**
     * 通过存储日期找到对应日期的StatisticalRequestDO数据
     *
     * @param statisticalDate 统计的日期，例如：2019-02-25
     * @return 对应日期的StatisticalRequestDO数据，如果没有为null
     */
    StatisticalRequestDO getStatisticalRequestDOByStatisticalDate(String statisticalDate);

    /**
     * 通过对应的数据创建的时间区间找到对应的Page<StatisticalRequestDO>
     *
     * @param gmtCreateBefore 创建时间左区间
     * @param gmtCreateAfter  创建时间右区间
     * @param pageable        分页信息
     * @return 如果找到则返回Page<StatisticalRequestDO>，如果没找到则返回空的Page
     */
    Page<StatisticalRequestDO> listStatisticalRequestDOByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable);

    /**
     * 通过对应的数据修改的时间区间找到对应的Page<StatisticalRequestDO>
     *
     * @param gmtModifiedBefore 修改时间左区间
     * @param gmtModifiedAfter  修改时间右区间
     * @param pageable          分页信息
     * @return 如果找到则返回Page<StatisticalRequestDO>，如果没找到则返回空的Page
     */
    Page<StatisticalRequestDO> listStatisticalRequestDOByGmtModifiedBetween(Date gmtModifiedBefore, Date gmtModifiedAfter, Pageable pageable);

    /**
     * 保存StatisticalRequestDO
     *
     * @param statisticalRequestDO StatisticalRequestDO实体
     * @return StatisticalRequestDO，如果保存不成功，则返回null
     */
    StatisticalRequestDO saveStatisticalRequestDO(StatisticalRequestDO statisticalRequestDO);

    /**
     * 得到最后一条StatisticalRequestDO数据
     *
     * @return StatisticalRequestDO，如果保存不成功，则返回null
     */
    StatisticalRequestDO getLastStatisticalRequestDO();

    //TODO 未实现

    /**
     * 更新StatisticalRequestDO
     *
     * @param statisticalRequestDO 需要更新的实体
     * @return 如果更新成功则返回StatisticalRequestDO，如果失败或者数据不存在则返回null
     */
    StatisticalRequestDO updateStatisticalRequestDO(StatisticalRequestDO statisticalRequestDO);

    /**
     * 得到实时统计的CurrentStatisticsRequestDTO
     * 该方法将定时进行调用，每秒进行调用，但该方式目前仅存放于内存中，并未存入到数据库中
     * 方法将调用数据库，查询数据库中当天的数据，进行统计
     * 将通过查询数据库中保存的数据进行统计，数据库中只有前一个小时的数据
     * 在统计当天的统计时将加上当前小时的统计信息
     *
     * @param currentStatisticsRequestDTO 存储于内存中，实时更新
     * @return CurrentStatisticsRequestDTO
     */
    CurrentStatisticsRequestDTO updateCurrentStatisticsRequestDTO(CurrentStatisticsRequestDTO currentStatisticsRequestDTO);
}
