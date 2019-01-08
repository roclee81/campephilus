package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.DeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.DeviceDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.OperationInformationDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * realdata
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
     *
     * @param deviceId        设备ID
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return DeviceDO分页信息
     */
    Page<DeviceDO> getDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable);

    /**
     * 通过唯一的手术顺序号和设备号查询数据
     *
     * @param deviceId        设备ID
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return DeviceDTO列表
     */
    List<DeviceDTO> getDeviceDTOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable);

    /**
     * 通过采集器MAC地址获取采集器所采集的所有DeviceDO信息
     *
     * @param collectorMacAddress 采集器MAC地址
     * @param pageable            分页信息
     * @return DeviceDO分页信息
     */
    Page<DeviceDO> getDeviceDOByCollectorMacAddress(String collectorMacAddress, Pageable pageable);

    /**
     * 通过采集器MAC地址获取采集器所采集的所有DeviceDTO信息
     *
     * @param collectorMacAddress 采集器MAC地址
     * @param pageable            分页信息
     * @return DeviceDO列表
     */
    List<DeviceDTO> getDeviceDTOByCollectorMacAddress(String collectorMacAddress, Pageable pageable);

    /**
     * 通过设备ID获取该设备的所有数据
     *
     * @param deviceId 设备ID
     * @param pageable 分页信息
     * @return DeviceDO分页信息
     */
    Page<DeviceDO> getDeviceDOSByDeviceId(String deviceId, Pageable pageable);

    /**
     * 通过设备ID获取该设备的所有数据
     *
     * @param deviceId 设备ID
     * @param pageable 分页信息
     * @return DeviceDO列表
     */
    List<DeviceDTO> getDeviceDTOSByDeviceId(String deviceId, Pageable pageable);

    /**
     * 通过手术号查询该手术所有的仪器数据
     * 由于OperationInformationDO中有设备信息
     *
     * @param operationNumber 手术顺序号
     * @param pageable        分页信息
     * @return DeviceDO的分页信息
     */
    Map<String, Object> getDeviceDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * 根据设备Id存储数据
     * 存储后表的名称为device_<code>deviceId</code>
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
