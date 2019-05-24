package org.cqu.edu.msc.annihilation.campephilus.module.core.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/23 22:35
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
@Aspect
public class OperationInfoAspect {

    private final AmqpTemplate amqpTemplate;

    private final String saveOperationInfoFromDataDTOPoint = "execution(public * org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationInfoService.saveOperationInfoFromDataDTO(..))";

    public OperationInfoAspect(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @AfterReturning(value = saveOperationInfoFromDataDTOPoint, returning = "returnResult")
    public void saveOperationInfoFromDataDTOPoint(OperationInfo returnResult) {
        amqpTemplate.convertAndSend("campephilus", returnResult.toString());
    }
}
