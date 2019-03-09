package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.convertor.FeedbackInformationDOConvertFeedbackInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.FeedbackInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.FeedbackInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;
import org.cqu.edu.mrc.annihilation.campephilus.repository.FeedbackInformationRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.FeedbackInformationService;
import org.cqu.edu.mrc.annihilation.common.enums.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public boolean saveFeedbackInformationDO(ParseDataDTO parseDataDTO) {

        Map<String, Object> dataMap = null;

        try {
//            dataMap = parseDataDTO.getData();
        } catch (ClassCastException e) {
            throw new SaveException(ErrorEnum.SAVE_ERROR.getCode(), DataConstants.SAVE_ERROR, e.toString(), parseDataDTO.toString());
        }

        if (dataMap.size() == 0) {
            return false;
        }
        FeedbackInformationDO feedbackInformationDO = new FeedbackInformationDO();
        feedbackInformationDO.setGmtCreate(new Date());
        feedbackInformationDO.setGmtModified(new Date());
        feedbackInformationDO.setMsg(dataMap);
        return this.saveFeedbackInformationDO(feedbackInformationDO) != null;
    }

    @Override
    public List<FeedbackInformationDTO> listFeedbackInformationDTO(Pageable pageable) {
        Page<FeedbackInformationDO> feedbackInformationDOPage = feedbackInformationRepository.findAllByIdNotNull(pageable);
        return FeedbackInformationDOConvertFeedbackInformationDTO.convert(feedbackInformationDOPage);
    }

}
