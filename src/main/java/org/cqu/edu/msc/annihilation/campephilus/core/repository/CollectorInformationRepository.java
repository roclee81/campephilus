package org.cqu.edu.msc.annihilation.campephilus.core.repository;

import org.cqu.edu.msc.annihilation.campephilus.core.dataobject.CollectorInformationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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
    CollectorInformationDO findCollectorInformationDOByCollectorMacAddress(String collectorMacAddress);

    /**
     * 通过采集器的状态得到对应的CollectorInformationDO实体
     *
     * @param collectorState 采集器的状态
     * @param pageable       分页信息
     * @return CollectorInformationDO的分页信息
     */
    Page<CollectorInformationDO> findCollectorInformationDOSByCollectorState(Integer collectorState, Pageable pageable);

    /**
     * 通过采集器状态查询采集器信息
     * 需要查询所有信息则传入所有状态值列表
     *
     * @param collectorStateList 需要查找的采集器状态列表
     * @param pageable           分页信息
     * @return 状态为输入状态的采集器的信息
     */
    Page<CollectorInformationDO> findCollectorInformationDOSByCollectorStateIn(List<Integer> collectorStateList, Pageable pageable);

    /**
     * 通过采集器状态查询采集器数量
     * 需要查询所有个数则传入所有状态值列表
     *
     * @param collectorStateList 需要统计的采集器状态列表
     * @return 状态为输入状态的采集器的个数
     */
    Integer countCollectorInformationDOSByCollectorStateIn(List<Integer> collectorStateList);

    /**
     * 通过采集器的状态和采集器最后上传数据的时间来查询数据
     *
     * @param collectorStateList               需要查找的采集器状态列表
     * @param gmtCollectorLastUploadDataBefore 需要查询的时间，将查找采集器最后一个数据上传的时间在输入时间之前的
     * @param pageable                         分页信息
     * @return 符合的Page<CollectorInformationDO>
     */
    Page<CollectorInformationDO> findCollectorInformationDOSByCollectorStateInAndGmtCollectorLastUploadDataBefore(List<Integer> collectorStateList, Date gmtCollectorLastUploadDataBefore, Pageable pageable);
}
