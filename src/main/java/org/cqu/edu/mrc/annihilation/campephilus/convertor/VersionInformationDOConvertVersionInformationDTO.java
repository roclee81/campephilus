package org.cqu.edu.mrc.annihilation.campephilus.convertor;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.DeviceDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.VersionInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.DeviceDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.VersionInformationDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 14:25
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class VersionInformationDOConvertVersionInformationDTO {

    public static List<VersionInformationDTO> convert(Page<VersionInformationDO> sourcePage) {

        if (sourcePage.getTotalElements() <= 0) {
            return new ArrayList<>();
        }

        List<VersionInformationDTO> versionInformationDTOList = new ArrayList<>();
        sourcePage.stream().forEach((versionInformationDO) -> {
            VersionInformationDTO versionInformationDTO = new VersionInformationDTO();
            BeanUtils.copyProperties(versionInformationDO, versionInformationDTO);
            versionInformationDTOList.add(versionInformationDTO);
        });
        return versionInformationDTOList;
    }

    public static VersionInformationDTO convert(VersionInformationDO versionInformationDO) {
        if (null == versionInformationDO) {
            return null;
        }

        VersionInformationDTO versionInformationDTO = new VersionInformationDTO();
        BeanUtils.copyProperties(versionInformationDO, versionInformationDTO);
        return versionInformationDTO;
    }
}
