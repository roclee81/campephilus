package org.cqu.edu.mrc.realdata.modules.app.convertor;


import org.cqu.edu.mrc.realdata.modules.app.dataobject.OperationMarkDO;
import org.cqu.edu.mrc.realdata.modules.app.dto.OperationMarkDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/8 16:35
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class OperationMarkDOConvertOperationMarkDTO {
    public static List<OperationMarkDTO> convert(Page<OperationMarkDO> sourcePage) {

        if (sourcePage.getTotalElements() <= 0) {
            return new ArrayList<>();
        }

        List<OperationMarkDTO> operationMarkDTOList = new ArrayList<>();

        sourcePage.stream().forEach((operationMarkDO) -> {
            OperationMarkDTO operationMarkDTO = new OperationMarkDTO();
            BeanUtils.copyProperties(operationMarkDO, operationMarkDTO);
            operationMarkDTOList.add(operationMarkDTO);
        });
        return operationMarkDTOList;
    }

    public static OperationMarkDTO convert(OperationMarkDO operationMarkDO) {
        if (null == operationMarkDO) {
            return null;
        }

        OperationMarkDTO operationMarkDTO = new OperationMarkDTO();
        BeanUtils.copyProperties(operationMarkDO, operationMarkDTO);
        return operationMarkDTO;
    }
}
