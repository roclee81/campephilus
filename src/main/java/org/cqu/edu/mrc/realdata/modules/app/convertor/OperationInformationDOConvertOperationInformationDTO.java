package org.cqu.edu.mrc.realdata.modules.app.convertor;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.OperationInformationDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/4 23:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class OperationInformationDOConvertOperationInformationDTO {
    public static List<OperationInformationDTO> convert(Page<OperationInformationDO> sourcePage) {

        List<OperationInformationDTO> operationInformationDTOList = new ArrayList<>();

        sourcePage.stream().forEach((operationInformationDO) -> {
            OperationInformationDTO operationInformationDTO = new OperationInformationDTO();
            BeanUtils.copyProperties(operationInformationDO, operationInformationDTO);
            operationInformationDTOList.add(operationInformationDTO);
        });
        return operationInformationDTOList;
    }

}
