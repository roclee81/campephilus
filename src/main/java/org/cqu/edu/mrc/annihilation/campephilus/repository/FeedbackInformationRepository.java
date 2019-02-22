package org.cqu.edu.mrc.annihilation.campephilus.repository;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.FeedbackInformationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 12:52
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface FeedbackInformationRepository extends MongoRepository<FeedbackInformationDO, String> {

    /**
     * 找到ID不为空的所有数据，就是查找所有的数据
     *
     * @param pageable 分页信息
     * @return Page<FeedbackInformationDO>，查询失败为空的page
     */
    Page<FeedbackInformationDO> findAllByIdNotNull(Pageable pageable);

}
