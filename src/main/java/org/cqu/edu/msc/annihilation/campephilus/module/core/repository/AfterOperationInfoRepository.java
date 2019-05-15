package org.cqu.edu.msc.annihilation.campephilus.module.core.repository;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 15:44
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface AfterOperationInfoRepository extends JpaRepository<AfterOperationInfo, Integer> {
}
