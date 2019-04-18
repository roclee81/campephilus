package org.cqu.edu.msc.annihilation.campephilus.module.app.service;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.FeedbackInformationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
     * @return 如果保存成功返回true，如果没有返回false
     */
    boolean saveFeedbackInformationDO(FeedbackInformationDO feedbackInformationDO);

    /**
     * 找到ID不为空的所有数据，就是查找所有的数据
     *
     * @param pageable 分页信息
     * @return Page<FeedbackInformationDO>，查询失败为空的page
     */
    Page<FeedbackInformationDO> listAllByIdNotNull(Pageable pageable);

    /**
     * 保存FeedbackInformationDO
     *
     * @param parseDataDTO 解析后的请求体
     * @return 是否保存成功
     */
    boolean saveFeedbackInformationDO(ParseDataDTO parseDataDTO);

    /**
     * 按照pageable找到所有的FeedbackInformationDTO
     *
     * @param pageable 分页信息
     * @return Page<FeedbackInformationDTO>，查询失败为空的page
     */
    List<FeedbackInformationDTO> listFeedbackInformationDTO(Pageable pageable);
}
