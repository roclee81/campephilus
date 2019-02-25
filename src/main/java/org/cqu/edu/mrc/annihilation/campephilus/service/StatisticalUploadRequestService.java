package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalUploadRequestDO;
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
public interface StatisticalUploadRequestService {

    /**
     * 通过存储日期找到对应日期的StatisticalUploadRequestDO数据
     *
     * @param statisticalDate 统计的日期，例如：2019-02-25
     * @return 对应日期的StatisticalUploadRequestDO数据，如果没有为null
     */
    StatisticalUploadRequestDO getStatisticalUploadRequestDOByStatisticalDate(String statisticalDate);

    /**
     * 通过对应的数据创建的时间区间找到对应的Page<StatisticalUploadRequestDO>
     *
     * @param gmtCreateBefore 创建时间左区间
     * @param gmtCreateAfter  创建时间右区间
     * @param pageable        分页信息
     * @return 如果找到则返回Page<StatisticalUploadRequestDO>，如果没找到则返回空的Page
     */
    Page<StatisticalUploadRequestDO> listStatisticalUploadRequestDOByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable);

    /**
     * 通过对应的数据修改的时间区间找到对应的Page<StatisticalUploadRequestDO>
     *
     * @param gmtModifiedBefore 修改时间左区间
     * @param gmtModifiedAfter  修改时间右区间
     * @param pageable          分页信息
     * @return 如果找到则返回Page<StatisticalUploadRequestDO>，如果没找到则返回空的Page
     */
    Page<StatisticalUploadRequestDO> listStatisticalUploadRequestDOByGmtModifiedBetween(Date gmtModifiedBefore, Date gmtModifiedAfter, Pageable pageable);

    /**
     * 保存StatisticalUploadRequestDO
     *
     * @param statisticalUploadRequestDO StatisticalUploadRequestDO实体
     * @return StatisticalUploadRequestDO，如果保存不成功，则返回null
     */
    StatisticalUploadRequestDO saveStatisticalUploadRequestDO(StatisticalUploadRequestDO statisticalUploadRequestDO);


}
