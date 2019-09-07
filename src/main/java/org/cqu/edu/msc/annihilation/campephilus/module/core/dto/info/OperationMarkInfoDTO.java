package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.common.utils.BeanUtils;

import java.io.Serializable;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OperationMarkInfoDTO extends OperationMarkInfo implements Serializable {

    private static final long serialVersionUID = -6950792304462088283L;

    private Long longMarkTime;

    private Long longModified;

    private Long longCreate;

    private OperationMarkInfoDTO() {

    }

    public static OperationMarkInfoDTO convertOperationMarkInfoDTO(OperationMarkInfo operationMarkInfo) {
        OperationMarkInfoDTO operationMarkInfoDTO = new OperationMarkInfoDTO();
        BeanUtils.copyPropertiesTargetNotNull(operationMarkInfo, operationMarkInfoDTO);
        return operationMarkInfoDTO;
    }

}
