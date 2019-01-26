package org.cqu.edu.mrc.campephilus.modules.app.convertor;

import org.cqu.edu.mrc.campephilus.modules.app.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.campephilus.modules.app.dto.OperationInformationDTO;
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

        if (sourcePage.getTotalElements() <= 0) {
            return new ArrayList<>();
        }

        List<OperationInformationDTO> operationInformationDTOList = new ArrayList<>();

        sourcePage.stream().forEach((operationInformationDO) -> {
            OperationInformationDTO operationInformationDTO = new OperationInformationDTO();
            BeanUtils.copyProperties(operationInformationDO, operationInformationDTO);
            operationInformationDTOList.add(operationInformationDTO);
        });
        return operationInformationDTOList;
    }

    public static OperationInformationDTO convert(OperationInformationDO operationInformationDO) {
        if (null == operationInformationDO) {
            return null;
        }

        OperationInformationDTO operationInformationDTO = new OperationInformationDTO();
        BeanUtils.copyProperties(operationInformationDO, operationInformationDTO);
        return operationInformationDTO;
    }

}
