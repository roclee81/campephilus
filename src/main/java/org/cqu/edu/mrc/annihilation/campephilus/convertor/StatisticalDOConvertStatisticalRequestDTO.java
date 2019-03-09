package org.cqu.edu.mrc.annihilation.campephilus.convertor;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.StatisticalRequestDTO;
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
public class StatisticalDOConvertStatisticalRequestDTO {

    public static List<StatisticalRequestDTO> convert(Page<StatisticalDO> sourcePage) {

        if (sourcePage.getTotalElements() <= 0) {
            return new ArrayList<>();
        }

        List<StatisticalRequestDTO> statisticalRequestDTOList = new ArrayList<>();
        sourcePage.stream().forEach((statisticalUploadRequestDO) -> {
            StatisticalRequestDTO statisticalRequestDTO = new StatisticalRequestDTO();
            BeanUtils.copyProperties(statisticalUploadRequestDO, statisticalRequestDTO);
            statisticalRequestDTOList.add(statisticalRequestDTO);
        });
        return statisticalRequestDTOList;
    }

    public static StatisticalRequestDTO convert(StatisticalDO statisticalDO) {
        if (null == statisticalDO) {
            return null;
        }

        StatisticalRequestDTO statisticalRequestDTO = new StatisticalRequestDTO();
        BeanUtils.copyProperties(statisticalDO, statisticalRequestDTO);
        return statisticalRequestDTO;
    }
}
