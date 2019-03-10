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
    public DeviceDO saveDeviceDO(DeviceDO deviceDO) {
        return null != deviceDO.getDeviceId() ? mongoOperations.save(deviceDO, "device_" + deviceDO.getDeviceId().toLowerCase()) : null;
    }

    @Override
    public Page<DeviceDO> findDeviceDOSByDeviceIdAndOperationNumber(String deviceId, Integer operationNumber, Pageable pageable) {
        Query query = Query.query(Criteria.where(DataConstants.OPERATION_NUMBER).is(operationNumber));
        query.with(pageable);
        return getDeviceDOS(query, deviceId, pageable);
    }

    @Override
    public DeviceDO findDeviceDOByDeviceIdAndOperationNumberAndDeviceDataNumber(String deviceId, Integer operationNumber, Integer deviceDataNumber) {
        Query query = Query.query(Criteria.where(DataConstants.OPERATION_NUMBER).is(operationNumber)
                .and(DataConstants.DEVICE_DATA_NUMBER).is(deviceDataNumber));
        return getDeviceDO(query, deviceId);
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

    private DeviceDO getDeviceDO(Query query, String deviceId) {
        List<DeviceDO> deviceDOList = mongoOperations.find(query, DeviceDO.class, "device_" + deviceId);
        return deviceDOList.size() > 0 && deviceDOList.size() < 2 ? deviceDOList.get(0) : null;
    }
}
