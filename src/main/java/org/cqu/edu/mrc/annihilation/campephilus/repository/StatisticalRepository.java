package org.cqu.edu.mrc.annihilation.campephilus.repository;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/8 16:57
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface StatisticalRepository extends MongoRepository<StatisticalDO, String> {

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
}
