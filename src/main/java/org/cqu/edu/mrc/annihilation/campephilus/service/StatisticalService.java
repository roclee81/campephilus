package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/8 18:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface StatisticalService {

    /**
     * 得到最后一条数据，即得到当天的数据
     *
     * @return StatisticalDO
     */
    StatisticalDO getFirstByOrderByIdDesc();

    /**
     * 找到所有的信息，通过分页信息
     *
     * @param pageable 分页信息
     * @return Page<StatisticalDO>
     */
    Page<StatisticalDO> listAllByIdNotNull(Pageable pageable);

    /**
     * 保存
     *
     * @param statisticalDO 代保存的对象
     * @return 保存成功为statisticalDO对象，失败则为null
     */
    StatisticalDO saveStatisticalDO(StatisticalDO statisticalDO);

    /**
     * 更新StatisticalDO表
     *
     * @param statisticalDO 待更新的对象
     * @return 更新成功为statisticalDO对象，失败则为null
     */
    StatisticalDO updateStatisticalDO(StatisticalDO statisticalDO);
}
