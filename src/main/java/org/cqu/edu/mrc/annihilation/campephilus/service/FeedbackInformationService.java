package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.FeedbackInformationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 13:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface FeedbackInformationService {

    /**
     * 保存FeedbackInformationDO
     *
     * @param feedbackInformationDO 需要保存的实体
     * @return 如果保存成功返回FeedbackInformationDO，如果没有返回null
     */
    FeedbackInformationDO saveFeedbackInformationDO(FeedbackInformationDO feedbackInformationDO);

    /**
     * 找到ID不为空的所有数据，就是查找所有的数据
     *
     * @param pageable 分页信息
     * @return Page<FeedbackInformationDO>，查询失败为空的page
     */
    Page<FeedbackInformationDO> listAllByIdNotNull(Pageable pageable);
}
