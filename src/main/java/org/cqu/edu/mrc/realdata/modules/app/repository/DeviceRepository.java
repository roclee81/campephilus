package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.DeviceDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * realdata
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
     * @param deviceId 仪器的Id
     */
    void save(DeviceDO deviceDO, String deviceId);

    /**
     * 通过唯一的手术顺序号查询数据
     *
     * @param operationNumber 手术顺序号唯一
     * @param pageable        分页信息
     * @return
     */
    Page<DeviceDO> findDeviceDOSByUOperationNumber(String deviceId, int operationNumber, Pageable pageable);

    /**
     * 得到指定仪器id的数据条数
     *
     * @param deviceId 节点的唯一Id
     * @return deviceId为输入的记录有多少条
     */
    Integer countDeviceDOSByDeviceId(String deviceId);
}
