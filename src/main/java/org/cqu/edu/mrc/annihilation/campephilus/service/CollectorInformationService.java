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
     * @return CollectorInformationDO实体，如果没有数据，为null
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
     * 不推荐使用该方法，该方法可能会造成多条数据的collectorMacAddress相同
     *
     * @param collectorInformationDO CollectorInformationDO实体
     * @return 保存结果，如果成功返回CollectorInformationDO实体失败返回空
     */
    CollectorInformationDO saveCollectorInformationDO(CollectorInformationDO collectorInformationDO);

    /**
     * 更改CollectorInformationDO实体的属性，当数据不存在时候，将创建
     *
     * @param collectorMacAddress      采集器的MAC地址
     * @param collectorState           采集器的状态
     * @param collectorUploadDataTimes 采集器上传数据，如果该更改为上传数据，则此属性为1，如果仅更改状态，传入数据为0
     * @param collectorOperationTimes  采集器运行的手术场次，如果增加场次，该属性传入1，如果不增加场次，传入数据0
     * @return 保存更改成功，如果成功返回CollectorInformationDO实体，失败返回空
     */
    CollectorInformationDO updateCollectorInformationDO(String collectorMacAddress, Integer collectorState, Long collectorUploadDataTimes, int collectorOperationTimes);

}
