package org.cqu.edu.mrc.realdata.modules.app.service;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.DeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * @param deviceId
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<DeviceDO> getDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable);

    /**
     * @param deviceId
     * @param pageable
     * @return
     */
    Page<DeviceDO> getDeviceDOSByDeviceId(String deviceId, Pageable pageable);

    /**
     * @param operationNumber
     * @param pageable
     * @return
     */
    Page<DeviceDO> getDeviceDOSByOperationNumber(Integer operationNumber, Pageable pageable);

    /**
     * 根据设备Id存储数据
     *
     * @param deviceDO
     * @param deviceId
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
