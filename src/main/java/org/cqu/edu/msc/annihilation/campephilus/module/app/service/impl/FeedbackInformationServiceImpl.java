package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.FeedbackInformationRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.FeedbackInformationDO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.FeedbackInformationDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.FeedbackInformationService;
import org.cqu.edu.msc.annihilation.common.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 13:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class FeedbackInformationServiceImpl implements FeedbackInformationService {

    private final FeedbackInformationRepository feedbackInformationRepository;

    @Autowired
    public FeedbackInformationServiceImpl(FeedbackInformationRepository feedbackInformationRepository) {
        this.feedbackInformationRepository = feedbackInformationRepository;
    }

    @Override
    public boolean saveFeedbackInformationDO(FeedbackInformationDO feedbackInformationDO) {
        FeedbackInformationDO result = feedbackInformationRepository.save(feedbackInformationDO);
        SaveException.checkSaveSuccess(result, feedbackInformationDO);
        return true;
    }

    @Override
    public Page<FeedbackInformationDO> listAllByIdNotNull(Pageable pageable) {
        return feedbackInformationRepository.findAllByIdNotNull(pageable);
    }

    @Override
    public boolean saveFeedbackInformationDO(ParseDataDTO parseDataDTO) {
        FeedbackInformationDO parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, FeedbackInformationDO.class);
        if (null == parseResult) {
            return false;
        }
        if (parseResult.getMessage() == null) {
            return false;
        }

        return this.saveFeedbackInformationDO(parseResult);
    }

    @Override
    public List<FeedbackInformationDTO> listFeedbackInformationDTO(Pageable pageable) {
        Page<FeedbackInformationDO> feedbackInformationDOPage = feedbackInformationRepository.findAllByIdNotNull(pageable);
        return ConvertUtil.convert(feedbackInformationDOPage, FeedbackInformationDTO.class);
    }

}
