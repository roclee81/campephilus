package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.CollectorInformationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

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
     * 批量保存CollectorInformationDO实体
     *
     * @param collectorInformationDOIterable CollectorInformationDO迭代器
     * @return 保存结果，如果成功返回List<CollectorInformationDO>，失败返回空
     */
    List<CollectorInformationDO> saveCollectorInformationDOS(List<CollectorInformationDO> collectorInformationDOIterable);

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

    /**
     * 通过采集器状态查询采集器信息
     * 需要查询所有信息则传入所有状态值列表
     *
     * @param collectorStateList 需要查找的采集器状态列表
     * @param pageable           分页信息
     * @return 状态为输入状态的采集器的信息
     */
    Page<CollectorInformationDO> listCollectorInformationDOSByCollectorStateIn(List<Integer> collectorStateList, Pageable pageable);

    /**
     * 获得所有CollectorInformationDO
     *
     * @param pageable 分页信息
     * @return CollectorInformationDO的分页信息
     */
    Page<CollectorInformationDO> listCollectorInformationDOS(Pageable pageable);

    /**
     * 通过采集器状态查询采集器数量
     * 需要查询所有个数则传入所有状态值列表
     *
     * @param collectorStateList 需要统计的采集器状态列表
     * @return 状态为输入状态的采集器的个数
     */
    Integer countCollectorInformationDOSByCollectorStateIn(List<Integer> collectorStateList);

    /**
     * 获得数据库中的采集器的信息的条数，即采集器的人数
     *
     * @return 采集器的总数
     */
    Integer countCollectorInformationDOS();

    /**
     * 通过采集器的状态和采集器最后上传数据的时间来查询数据
     *
     * @param collectorStateList               需要查找的采集器状态列表
     * @param gmtCollectorLastUploadDataBefore 需要查询的时间，将查找采集器最后一个数据上传的时间在输入时间之前的
     * @param pageable                         分页信息
     * @return 符合的Page<CollectorInformationDO>
     */
    Page<CollectorInformationDO> listCollectorInformationDOSByCollectorStateInAndGmtCollectorLastUploadDataBefore(List<Integer> collectorStateList, Date gmtCollectorLastUploadDataBefore, Pageable pageable);

    /**
     * 得到CollectorInformationDTO信息
     *
     * @param pageable 分页信息
     * @return 成功为CollectorInformationDTO，失败为null
     */
    CollectorInformationDTO getCollectorInformationDTO(Pageable pageable);
}
