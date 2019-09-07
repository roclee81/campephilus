package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.LogInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/12 16:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface LogInfoRepository extends JpaRepository<LogInfo, Integer> {

}
