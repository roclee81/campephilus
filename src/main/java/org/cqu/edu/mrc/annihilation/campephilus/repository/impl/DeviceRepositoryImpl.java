package org.cqu.edu.mrc.annihilation.campephilus.repository.impl;

import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.DeviceDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.DeviceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 15:22
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
public class DeviceRepositoryImpl implements DeviceRepository {

    private final MongoOperations mongoOperations;

    public DeviceRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public void save(DeviceDO deviceDO, String deviceId) {
        deviceId = deviceId.toLowerCase();
        mongoOperations.save(deviceDO, "device_" + deviceId);
    }

    @Override
    public Page<DeviceDO> findDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable) {
        Query query = Query.query(Criteria.where(DataConstants.OPERATION_NUMBER).is(operationNumber));
        query.with(pageable);
        return getDeviceDOS(query, deviceId, pageable);
    }

    @Override
    public Page<DeviceDO> findDeviceDOSByCollectorMacAddress(String deviceId, String collectorMacAddress, Pageable pageable) {
        Query query = Query.query(Criteria.where(DataConstants.COLLECTOR_MAC_ADDRESS).is(collectorMacAddress));
        query.with(pageable);
        return getDeviceDOS(query, deviceId, pageable);
    }

    @Override
    public Page<DeviceDO> findDeviceDOSByDeviceId(String deviceId, Pageable pageable) {
        Query query = Query.query(Criteria.where(""));
        query.with(pageable);
        return getDeviceDOS(query, deviceId, pageable);
    }

    @Override
    public Integer countDeviceDOSByDeviceId(String deviceId) {
        Query query = Query.query(Criteria.where(""));
        return (int) mongoOperations.count(query, deviceId);
    }

    private Page<DeviceDO> getDeviceDOS(Query query, String deviceId, Pageable pageable) {
        // 查询总数
        int count = (int) mongoOperations.count(query, DeviceDO.class, "device_" + deviceId);
        List<DeviceDO> deviceDOList = mongoOperations.find(query, DeviceDO.class, "device_" + deviceId);
        return PageableExecutionUtils.getPage(deviceDOList, pageable, () -> count);
    }
}
