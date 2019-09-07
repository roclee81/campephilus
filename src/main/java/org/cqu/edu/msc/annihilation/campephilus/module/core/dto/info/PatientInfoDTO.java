package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.PatientInfo;
import org.cqu.edu.msc.annihilation.common.utils.BeanUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 21:47
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PatientInfoDTO extends PatientInfo implements Serializable {

    private static final long serialVersionUID = 3360687571405600534L;

    private Long longModified;

    private Long longCreate;

    private PatientInfoDTO() {

    }

    public static PatientInfoDTO structurePatientInfoDTO(PatientInfo patientInfo) {
        PatientInfoDTO patientInfoDTO = new PatientInfoDTO();
        BeanUtils.copyPropertiesTargetNotNull(patientInfo, patientInfoDTO);
        return patientInfoDTO;
    }
}
