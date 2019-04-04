package org.cqu.edu.msc.annihilation.campephilus.module.app.service;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.CollectorInformationDO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.CollectorInformationDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ParseDataDTO;
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
     * @return 保存结果，如果成功返回true实体失败返回false
     */
    boolean saveCollectorInformationDO(CollectorInformationDO collectorInformationDO);

    /**
     * 批量保存CollectorInformationDO实体
     *
     * @param collectorInformationDOIterable CollectorInformationDO迭代器
     * @return 保存结果，如果成功返回List<CollectorInformationDO>，失败返回空
     */
    List<CollectorInformationDO> saveCollectorInformationDOS(List<CollectorInformationDO> collectorInformationDOIterable);

    /**
     * 当数据保存成功的时候更新CollectorInformationDO对应数据
     *
     * @param parseDataDTO 解析后的对象
     * @return 保存结果，如果成功返回true实体失败返回false
     */
    boolean updateCollectorInformationDOWhenUpdateSuccess(ParseDataDTO parseDataDTO);

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
