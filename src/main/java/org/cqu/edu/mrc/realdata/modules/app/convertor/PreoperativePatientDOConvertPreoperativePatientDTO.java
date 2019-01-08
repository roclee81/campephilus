package org.cqu.edu.mrc.realdata.modules.app.convertor;

import lombok.Data;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationMarkDO;
import org.cqu.edu.mrc.realdata.modules.app.dataobject.PreoperativePatientDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.OperationMarkDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.PreoperativePatientDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 17:02
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class PreoperativePatientDOConvertPreoperativePatientDTO {
    public static List<PreoperativePatientDTO> convert(Page<PreoperativePatientDO> sourcePage) {

        List<PreoperativePatientDTO> preoperativePatientDTOList = new ArrayList<>();

        sourcePage.stream().forEach((preoperativePatientDO) -> {
            PreoperativePatientDTO preoperativePatientDTO = new PreoperativePatientDTO();
            BeanUtils.copyProperties(preoperativePatientDO, preoperativePatientDTO);
            preoperativePatientDTOList.add(preoperativePatientDTO);
        });
        return preoperativePatientDTOList;
    }
}
