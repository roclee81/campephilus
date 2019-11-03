package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.data;

import lombok.Data;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.PearlcareYy106;
import org.cqu.edu.msc.annihilation.common.utils.BeanUtils;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/11 17:37
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Data
public class PearlcareYy106DataDTO implements Serializable {

    private static final long serialVersionUID = 62187762511544587L;

    /**
     * 序列号
     */
    private String serialNumber;

    /**
     * 手术顺序号
     */
    private Integer operationNumber;

    /**
     * AI
     */
    private Integer AI;

    /**
     * EMG
     */
    private Integer EMG;

    /**
     * SQI
     */
    private Integer SQI;

    /**
     * BSR
     */
    private Integer BSR;

    private Long longModified;

    private Long longCreate;

    public static PearlcareYy106DataDTO structurePearlcareYy106DataDTO(PearlcareYy106 pearlcareYy106) {
        if (Objects.isNull(pearlcareYy106)) {
            return null;
        }
        PearlcareYy106DataDTO pearlcareYy106DataDTO = new PearlcareYy106DataDTO();
        BeanUtils.copyPropertiesTargetNotNull(pearlcareYy106, pearlcareYy106DataDTO);
        pearlcareYy106DataDTO.setLongCreate(TimeStampUtils.parseLocalDateTimeToTimeStamp(pearlcareYy106.getGmtCreate()));
        pearlcareYy106DataDTO.setLongModified(TimeStampUtils.parseLocalDateTimeToTimeStamp(pearlcareYy106.getGmtCreate()));
        return pearlcareYy106DataDTO;
    }

    public static List<PearlcareYy106DataDTO> structurePearlcareYy106DataDTOList(List<PearlcareYy106> pearlcareYy106Data) {
        return pearlcareYy106Data.parallelStream()
                .map(PearlcareYy106DataDTO::structurePearlcareYy106DataDTO)
                .collect(Collectors.toList());
    }
}
