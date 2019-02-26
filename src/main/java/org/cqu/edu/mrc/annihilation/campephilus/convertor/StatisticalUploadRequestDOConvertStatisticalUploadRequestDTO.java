package org.cqu.edu.mrc.annihilation.campephilus.convertor;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.DeviceDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalUploadRequestDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.DeviceDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.StatisticalUploadRequestDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/26 10:26
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class StatisticalUploadRequestDOConvertStatisticalUploadRequestDTO {

    public static List<StatisticalUploadRequestDTO> convert(Page<StatisticalUploadRequestDO> sourcePage) {

        if (sourcePage.getTotalElements() <= 0) {
            return new ArrayList<>();
        }

        List<StatisticalUploadRequestDTO> statisticalUploadRequestDTOList = new ArrayList<>();
        sourcePage.stream().forEach((statisticalUploadRequestDO) -> {
            StatisticalUploadRequestDTO statisticalUploadRequestDTO = new StatisticalUploadRequestDTO();
            BeanUtils.copyProperties(statisticalUploadRequestDO, statisticalUploadRequestDTO);
            statisticalUploadRequestDTOList.add(statisticalUploadRequestDTO);
        });
        return statisticalUploadRequestDTOList;
    }

    public static StatisticalUploadRequestDTO convert(StatisticalUploadRequestDO statisticalUploadRequestDO) {
        if (null == statisticalUploadRequestDO) {
            return null;
        }

        StatisticalUploadRequestDTO statisticalUploadRequestDTO = new StatisticalUploadRequestDTO();
        BeanUtils.copyProperties(statisticalUploadRequestDO, statisticalUploadRequestDTO);
        return statisticalUploadRequestDTO;
    }
}
