package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/18 21:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface OperationInfoRepository extends JpaRepository<OperationInfo, Integer> {

    List<OperationInfo> findByOperationStateIs(int state);

    OperationInfo findByOperationNumber(int operationNumber);
}
