package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.data;

import lombok.Data;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.Norwamd9002s;
import org.cqu.edu.msc.annihilation.common.utils.BeanUtils;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/11 17:26
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class Norwamd9002sDataDTO implements Serializable {

    private static final long serialVersionUID = -3298569745526121652L;

    /**
     * 序列号
     */
    private String serialNumber;

    /**
     * 手术顺序号
     */
    private Integer operationNumber;

    /**
     * BS
     */
    private Integer BS;

    /**
     * EMG
     */
    private Integer EMG;

    /**
     * SQI
     */
    private Integer SQI;

    /**
     * CSI
     */
    private Integer CSI;

    private Long longModified;

    private Long longCreate;

    private Norwamd9002sDataDTO() {

    }

    public static Norwamd9002sDataDTO structureNorwamd9002sDataDTO(Norwamd9002s NORWAMD9002S) {
        if (Objects.isNull(NORWAMD9002S)) {
            return null;
        }
        Norwamd9002sDataDTO norwamd9002sDataDTO = new Norwamd9002sDataDTO();
        BeanUtils.copyPropertiesTargetNotNull(NORWAMD9002S, norwamd9002sDataDTO);
        norwamd9002sDataDTO.setLongCreate(TimeStampUtils.getTimestampOfDateTime(NORWAMD9002S.getGmtCreate()));
        norwamd9002sDataDTO.setLongModified(TimeStampUtils.getTimestampOfDateTime(NORWAMD9002S.getGmtModified()));
        return norwamd9002sDataDTO;
    }

    public static List<Norwamd9002sDataDTO> structureNorwamd9002sDataDTOList(List<Norwamd9002s> NORWAMD9002S) {
        return NORWAMD9002S.parallelStream()
                .map(Norwamd9002sDataDTO::structureNorwamd9002sDataDTO)
                .collect(Collectors.toList());
    }
}
