package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/8 18:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface StatisticalService {

    /**
     * 通过存储日期找到对应日期的StatisticalDO数据
     *
     * @param statisticalDate 统计的日期，例如：2019-02-25
     * @return 对应日期的StatisticalDO数据，如果没有为null
     */
    StatisticalDO getStatisticalDOByStatisticalDate(String statisticalDate);

    /**
     * 得到最后一条StatisticalDO数据，不一定是当天的数据
     * 如果在
     *
     * @return StatisticalDO，如果有最后一条数据返回，如果没有则返回null
     */
    StatisticalDO getLastStatisticalDO();

    /**
     * 找到所有的信息，通过分页信息
     *
     * @param pageable 分页信息
     * @return Page<StatisticalDO>
     */
    Page<StatisticalDO> listAllByIdNotNull(Pageable pageable);

    /**
     * 保存
     * 程序禁止出现相同statisticalDate字段的数据
     * 注意保存时必须判断是否存在statisticalDate字段的对象，如果有，则拒绝保存
     * 返回null
     *
     * @param statisticalDO 代保存的对象
     * @return 保存成功为statisticalDO对象，失败则为null
     */
    StatisticalDO saveStatisticalDO(StatisticalDO statisticalDO);

    /**
     * 更新StatisticalDO表
     * 首先将通过日期查询数据是否有改字段，在查询时还将通过<code>getLastStatisticalDO()</code>方法去查询
     * 查询是否statisticalDate字段相同，如果不同，则将直接保存statisticalDO对象
     * 如果statisticalDate字段相同则将扫描输入的statisticalDO对象，将输入对象的数据与原数据叠加
     *
     * @param statisticalDO 待更新的对象
     * @return 更新成功为statisticalDO对象，失败则为null
     */
    StatisticalDO updateStatisticalDO(StatisticalDO statisticalDO);

    /**
     * 通过对应的数据创建的时间区间找到对应的Page<StatisticalDO>
     *
     * @param gmtCreateBefore 创建时间左区间
     * @param gmtCreateAfter  创建时间右区间
     * @param pageable        分页信息
     * @return 如果找到则返回Page<StatisticalDO>，如果没找到则返回空的Page
     */
    Page<StatisticalDO> listStatisticalDOByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable);

    /**
     * 通过对应的数据修改的时间区间找到对应的Page<StatisticalDO>
     *
     * @param gmtModifiedBefore 修改时间左区间
     * @param gmtModifiedAfter  修改时间右区间
     * @param pageable          分页信息
     * @return 如果找到则返回Page<StatisticalDO>，如果没找到则返回空的Page
     */
    Page<StatisticalDO> listStatisticalDOByGmtModifiedBetween(Date gmtModifiedBefore, Date gmtModifiedAfter, Pageable pageable);

    /**
     * 更新StatisticalDO
     * 首先需要判断parseDataDTO中的数据以及请求码
     * 其次需要判断其中的信息是否等于所要求字段
     * 首先将通过日期查询数据是否有改字段
     * 如果没有将创建StatisticalDO记录
     *
     * @param parseDataDTO 待保存的信息
     * @return 如果更新成功，则返回StatisticalDO，更新失败则返回null
     */
    StatisticalDO updateStatisticalDO(ParseDataDTO parseDataDTO);
}
