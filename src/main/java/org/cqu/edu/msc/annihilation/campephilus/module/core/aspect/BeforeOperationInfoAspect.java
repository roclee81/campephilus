package org.cqu.edu.msc.annihilation.campephilus.module.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BeforeOperationInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/23 21:29
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Aspect
@Component
@Slf4j
public class BeforeOperationInfoAspect {

    private final AmqpTemplate amqpTemplate;

    private final String saveBeforeOperationInfoFromDataDTOPoint = "execution(public * org.cqu.edu.msc.annihilation.campephilus.module.core.service.BeforeOperationInfoService.saveBeforeOperationInfoFromDataDTO(..))";

    public BeforeOperationInfoAspect(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @AfterReturning(value = saveBeforeOperationInfoFromDataDTOPoint, returning = "returnResult")
    public void saveBeforeOperationInfoFromDataDTOPoint(BeforeOperationInfo returnResult) {
        amqpTemplate.convertAndSend("campephilus", returnResult.toString());
    }
}
