package org.cqu.edu.mrc.annihilation.campephilus.repository;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/21 14:16
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface CollectorInformationRepository extends MongoRepository<CollectorInformationDO, String> {

    /**
     * 通过collectorMacAddress获得CollectorInformationDO实体
     *
     * @param collectorMacAddress 采集器的MAC地址
     * @return CollectorInformationDO实体
     */
    CollectorInformationDO getCollectorInformationDOByCollectorMacAddress(String collectorMacAddress);

    /**
     * 通过采集器的状态得到对应的CollectorInformationDO实体
     *
     * @param collectorState 采集器的状态
     * @param pageable       分页信息
     * @return CollectorInformationDO的分页信息
     */
    Page<CollectorInformationDO> getCollectorInformationDOSByCollectorState(Integer collectorState, Pageable pageable);
}
