package org.cqu.edu.msc.annihilation.campephilus.module.app.repository;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.DeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/18 21:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface DeviceInfoRepository extends JpaRepository<Integer, DeviceInfo> {
}
