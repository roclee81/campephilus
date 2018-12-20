package org.cqu.edu.mrc.realdata.modules.app.repository.impl;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.DeviceDO;
import org.cqu.edu.mrc.realdata.modules.app.repository.DeviceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/20 15:22
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
public class DeviceRepositoryImpl implements DeviceRepository {

    private final
    MongoOperations mongoOperations;

    public DeviceRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public void save(DeviceDO deviceDO, String deviceId) {
        mongoOperations.save(deviceDO, deviceId);
    }

    @Override
    public Page<DeviceDO> findDeviceDOSByUOperationNumber(String deviceId, int operationNumber, Pageable pageable) {
        Query query = Query.query(Criteria.where("operationNumber").is(operationNumber));
        query.with(pageable);
        // 查询总数
        int count = (int) mongoOperations.count(query, DeviceDO.class, deviceId);
        List<DeviceDO> deviceDOList = mongoOperations.find(query, DeviceDO.class, deviceId);
        System.out.println(deviceDOList);
        return PageableExecutionUtils.getPage(deviceDOList, pageable, () -> count);
    }

    @Override
    public Integer countDeviceDOSByDeviceId(String deviceId) {
        Query query = Query.query(Criteria.where(""));
        return (int) mongoOperations.count(query, deviceId);
    }
}
