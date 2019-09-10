package org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.Norwamd9002sData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 21:25
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface Norwamd9002sDataRepository extends JpaRepository<Norwamd9002sData, Integer> {

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @param pageable        分页信息
     * @return List DTO对象
     */
    List<Norwamd9002sData> findByOperationNumberAndSerialNumber(
            int operationNumber, String serialNumber, Pageable pageable);

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return DTO对象
     */
    Norwamd9002sData findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(int operationNumber, String serialNumber);
}

