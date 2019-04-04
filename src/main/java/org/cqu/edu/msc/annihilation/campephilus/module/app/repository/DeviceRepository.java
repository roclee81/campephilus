package org.cqu.edu.msc.annihilation.campephilus.module.app.repository;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.DeviceDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 15:16
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface DeviceRepository {

    /**
     * 向MongoDB数据库保存一条数据
     * 保存的时候将按照<code>deviceId</code>字段插入不同的表
     *
     * @param deviceDO 待保存的实体类
     * @return 保存成功返回DeviceDO，失败返回null
     */
    DeviceDO saveDeviceDO(DeviceDO deviceDO);

    /**
     * 通过唯一的手术顺序号和设备号查询数据
     *
     * @param deviceId        设备的ID
     * @param operationNumber 手术顺序号唯一
     * @param pageable        分页信息
     * @return DeviceDO实体
     */
    Page<DeviceDO> findDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable);

    /**
     * 通过唯一的手术顺序号和设备号和设备数据顺序号查询唯一数据
     *
     * @param deviceId         设备的ID
     * @param operationNumber  手术顺序号唯一
     * @param deviceDataNumber 设备数据顺序号
     * @return 如果存在返回对应DeviceDO，不存在返回null，如果查询到两个同样的数据，是数据库出现错误，也是返回null
     */
    DeviceDO findDeviceDOByDeviceIdAndOperationNumberAndDeviceDataNumber(String deviceId, Integer operationNumber, Integer deviceDataNumber);

    /**
     * 通过采集器MAC地址获取采集器所采集的所有DeviceDO信息
     *
     * @param deviceId            设备的ID
     * @param collectorMacAddress 采集器MAC地址
     * @param pageable            分页信息
     * @return DeviceDO分页信息
     */
    Page<DeviceDO> findDeviceDOSByCollectorMacAddress(String deviceId, String collectorMacAddress, Pageable pageable);

    /**
     * 通过设备ID获取该设备的所有数据
     *
     * @param deviceId 设备ID
     * @param pageable 分页信息
     * @return DeviceDO实体
     */
    Page<DeviceDO> findDeviceDOSByDeviceId(String deviceId, Pageable pageable);

    /**
     * 得到指定仪器id的数据条数
     *
     * @param deviceId 节点的唯一Id
     * @return deviceId为输入的记录有多少条
     */
    Integer countDeviceDOSByDeviceId(String deviceId);
}
