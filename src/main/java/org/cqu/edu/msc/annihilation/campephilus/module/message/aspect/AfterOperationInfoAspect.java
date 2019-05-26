package org.cqu.edu.msc.annihilation.campephilus.module.message.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/23 21:29
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
@Aspect
public class AfterOperationInfoAspect {

    private final AmqpTemplate amqpTemplate;

    private final String saveAfterOperationInfoFromDataDTOPoint =
            "execution(public * org.cqu.edu.msc.annihilation.campephilus.module.core.service.AfterOperationInfoService.saveAfterOperationInfoFromDataDTO(..))";

    public AfterOperationInfoAspect(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @AfterReturning(value = saveAfterOperationInfoFromDataDTOPoint, returning = "returnResult")
    public void saveAfterOperationInfoFromDataDTOPoint(AfterOperationInfo returnResult) {
        amqpTemplate.convertAndSend("campephilus", returnResult.toString());
    }
}
