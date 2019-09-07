package org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationInfo;
import org.cqu.edu.msc.annihilation.common.utils.BeanUtils;

import java.io.Serializable;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 22:42
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OperationInfoDTO extends OperationInfo implements Serializable {

    private static final long serialVersionUID = -3133528677913293064L;

    private Long longOperationStartTime;

    private Long longOperationEndTime;

    private Long longModified;

    private Long longCreate;

    private OperationInfoDTO() {

    }

    public static OperationInfoDTO convertOperationInfoDTO(OperationInfo operationInfo) {
        OperationInfoDTO operationInfoDTO = new OperationInfoDTO();
        BeanUtils.copyPropertiesTargetNotNull(operationInfo, operationInfoDTO);
        return operationInfoDTO;
    }
}

