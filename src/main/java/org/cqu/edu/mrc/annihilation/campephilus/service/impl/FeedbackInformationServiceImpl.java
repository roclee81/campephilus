package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.FeedbackInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.FeedbackInformationRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.FeedbackInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public FeedbackInformationDO saveFeedbackInformationDO(FeedbackInformationDO feedbackInformationDO) {
        return feedbackInformationRepository.save(feedbackInformationDO);
    }

    @Override
    public Page<FeedbackInformationDO> listAllByIdNotNull(Pageable pageable) {
        return feedbackInformationRepository.findAllByIdNotNull(pageable);
    }

}
