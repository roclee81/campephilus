package org.cqu.edu.msc.annihilation.campephilus.module.message.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/23 22:36
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
@Aspect
public class OperationMarkInfoAspect {

    private final String saveOperationMarkInfoFromDataDTOPoint = "execution(public * org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationMarkInfoService.saveOperationMarkInfoFromDataDTO(..))";

    @AfterReturning(value = saveOperationMarkInfoFromDataDTOPoint, returning = "returnResult")
    public void saveOperationMarkInfoFromDataDTOPoint(OperationMarkInfo returnResult) {
    }
}
