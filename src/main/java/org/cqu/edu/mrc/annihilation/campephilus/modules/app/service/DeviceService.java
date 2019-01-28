package org.cqu.edu.mrc.annihilation.campephilus.modules.app.service;

import org.cqu.edu.mrc.annihilation.campephilus.modules.app.dataobject.DeviceDO;
import org.cqu.edu.mrc.annihilation.campephilus.modules.app.dto.DeviceDTO;
import org.cqu.edu.mrc.annihilation.campephilus.modules.app.dto.ParseDataDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 16:45
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface DeviceService {

    /**
     * 通过唯一的手术顺序号和设备号查询数据
     * 可以传入空的deviceId和operationNumber
     * 但是如果检测到两个参数都为空的话将返回null
     * 需要检测是否是空值
     * 如果仅有一个参数有效，则按照单一参数查询
     *
     * @param deviceId        设备ID
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return DeviceDO分页信息
     */
    Page<DeviceDO> listDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable);

    /**
     * 通过唯一的手术顺序号和设备号查询数据
     *
     * @param deviceId        设备ID
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return DeviceDTO列表
     */
    List<DeviceDTO> listDeviceDTOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable);

    /**
     * 通过采集器MAC地址获取采集器所采集的所有DeviceDO信息
     *
     * @param collectorMacAddress 采集器MAC地址
     * @param pageable            分页信息
     * @return DeviceDO分页信息
     */
    Page<DeviceDO> listDeviceDOByCollectorMacAddress(String collectorMacAddress, Pageable pageable);

    /**
     * 通过采集器MAC地址获取采集器所采集的所有DeviceDTO信息
     *
     * @param collectorMacAddress 采集器MAC地址
     * @param pageable            分页信息
     * @return DeviceDO列表
     */
    List<DeviceDTO> listDeviceDTOByCollectorMacAddress(String collectorMacAddress, Pageable pageable);

    /**
     * 通过设备ID获取该设备的所有数据
     *
     * @param deviceId 设备ID
     * @param pageable 分页信息
     * @return DeviceDO分页信息
     */
    Page<DeviceDO> listDeviceDOSByDeviceId(String deviceId, Pageable pageable);

    /**
     * 通过设备ID获取该设备的所有数据
     *
     * @param deviceId 设备ID
     * @param pageable 分页信息
     * @return DeviceDO列表
     */
    List<DeviceDTO> listDeviceDTOSByDeviceId(String deviceId, Pageable pageable);

    /**
     * 根据设备Id存储数据
     * 存储后表的名称为device_<code>deviceId</code>
     * 在保存中将检查对应的OperationInformationDO类中的deviceInformation属性中有没有该仪器
     * 如果没有会将该仪器添加进deviceInformation属性中
     *
     * @param deviceDO DeviceDO实体
     * @param deviceId 设备ID
     */
    void saveDeviceDO(DeviceDO deviceDO, String deviceId);

    /**
     * 存储数据
     *
     * @param parseDataDTO 初次解析的数据
     * @return 存储完成返回true，对数据解析失败返回false
     */
    boolean saveDeviceDO(ParseDataDTO parseDataDTO);
}
