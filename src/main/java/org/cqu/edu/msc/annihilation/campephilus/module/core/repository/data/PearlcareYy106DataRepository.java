package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.PearlcareYy106Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 21:25
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface PearlcareYy106DataRepository extends JpaRepository<PearlcareYy106Data, Integer> {

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber
     * @param serialNumber
     * @return
     */
    PearlcareYy106Data findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(int operationNumber, String serialNumber);
}
