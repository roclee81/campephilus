package org.cqu.edu.mrc.annihilation.campephilus.repository;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.VersionInformationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 13:19
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface VersionInformationRepository extends MongoRepository<VersionInformationDO, String> {

    /**
     * 查询最后一条数据
     *
     * @return VersionInformationDO实体
     */
    VersionInformationDO findFirstByOrderByIdDesc();

    /**
     * 找到ID不为空的所有数据，就是查找所有的数据
     *
     * @param pageable 分页信息
     * @return Page<VersionInformationDO>
     */
    Page<VersionInformationDO> findAllByIdNotNull(Pageable pageable);

}
