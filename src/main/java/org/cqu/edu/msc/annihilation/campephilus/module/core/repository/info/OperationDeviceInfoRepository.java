package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationDeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:04
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface OperationDeviceInfoRepository extends JpaRepository<OperationDeviceInfo, Integer> {

    OperationDeviceInfo findByOperationNumber(int operationNumber);
}
