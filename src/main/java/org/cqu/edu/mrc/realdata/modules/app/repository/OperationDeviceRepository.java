package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationDeviceDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:44
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface OperationDeviceRepository extends MongoRepository<OperationDeviceDO, String> {

    /**
     * 通过手术顺序号得到OperationDeviceDO
     *
     * @param operationNumber 手术顺序号
     * @return OperationDeviceDO
     */
    OperationDeviceDO findOperationDeviceDOSByOperationNumber(Integer operationNumber);

    /**
     * 通过采集器的MAC地址查询OperationDeviceDO数据
     *
     * @param collectorMacAddress 采集器的MAC地址
     * @param pageable            分页信息
     * @return OperationDeviceDO的分页信息
     */
    Page<OperationDeviceDO> findOperationDeviceDOSByCollectorMacAddress(String collectorMacAddress, Pageable pageable);
}
