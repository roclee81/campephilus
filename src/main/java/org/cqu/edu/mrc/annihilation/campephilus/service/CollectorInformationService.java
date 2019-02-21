package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/21 14:18
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface CollectorInformationService {

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
    Page<CollectorInformationDO> listCollectorInformationDOSByCollectorState(Integer collectorState, Pageable pageable);

    /**
     * 保存CollectorInformationDO实体
     *
     * @param collectorInformationDO CollectorInformationDO实体
     * @return 保存结果，如果成功返回CollectorInformationDO实体失败返回空
     */
    CollectorInformationDO saveCollectorInformationDO(CollectorInformationDO collectorInformationDO);

}
