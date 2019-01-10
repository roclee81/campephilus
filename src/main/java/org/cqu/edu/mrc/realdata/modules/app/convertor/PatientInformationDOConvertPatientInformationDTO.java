package org.cqu.edu.mrc.realdata.modules.app.convertor;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PatientInformationDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.PatientInformationDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 22:26
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class PatientInformationDOConvertPatientInformationDTO {
    public static List<PatientInformationDTO> convert(Page<PatientInformationDO> sourcePage) {

        if (sourcePage.getTotalElements() <= 0) {
            return new ArrayList<>();
        }

        List<PatientInformationDTO> patientInformationDTOList = new ArrayList<>();

        sourcePage.stream().forEach((patientInformationDO) -> {
            PatientInformationDTO preoperativePatientDTO = new PatientInformationDTO();
            BeanUtils.copyProperties(patientInformationDO, preoperativePatientDTO);
            patientInformationDTOList.add(preoperativePatientDTO);
        });
        return patientInformationDTOList;
    }

    public static PatientInformationDTO convert(PatientInformationDO patientInformationDO) {
        if (null == patientInformationDO) {
            return null;
        }

        PatientInformationDTO patientInformationDTO = new PatientInformationDTO();
        BeanUtils.copyProperties(patientInformationDO, patientInformationDTO);
        return patientInformationDTO;
    }
}
