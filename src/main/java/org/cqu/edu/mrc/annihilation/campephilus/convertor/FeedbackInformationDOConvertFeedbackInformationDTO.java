package org.cqu.edu.mrc.annihilation.campephilus.convertor;

import lombok.Data;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.DeviceDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.FeedbackInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.DeviceDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.FeedbackInformationDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 14:19
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class FeedbackInformationDOConvertFeedbackInformationDTO {
    public static List<FeedbackInformationDTO> convert(Page<FeedbackInformationDO> sourcePage) {

        if (sourcePage.getTotalElements() <= 0) {
            return new ArrayList<>();
        }

        List<FeedbackInformationDTO> deviceDTOList = new ArrayList<>();
        sourcePage.stream().forEach((feedbackInformationDO) -> {
            FeedbackInformationDTO feedbackInformationDTO = new FeedbackInformationDTO();
            BeanUtils.copyProperties(feedbackInformationDO, feedbackInformationDTO);
            deviceDTOList.add(feedbackInformationDTO);
        });
        return deviceDTOList;
    }
}
