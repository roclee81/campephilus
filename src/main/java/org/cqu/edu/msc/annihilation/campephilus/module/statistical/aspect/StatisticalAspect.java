package org.cqu.edu.msc.annihilation.campephilus.module.statistical.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ParseDataDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/25 20:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 采用aop的方式，发送信息到rabbitmq
 * rabbitmq来进行消息处理
 */
@Aspect
@Component
@Slf4j
public class StatisticalAspect {

    private final AmqpTemplate amqpTemplate;

    private final String saveOperationInformationDOFromParseDataDTOPoint = "execution(public * org.cqu.edu.msc.annihilation.campephilus.module.app.service.OperationInformationService.saveOperationInformationDOFromParseDataDTO(..))";
    private final String InstrumentRequestPoint = "execution(public * org.cqu.edu.msc.annihilation.campephilus.module.app.controller.InstrumentRequestController.processInstrumentData(..))";

    @Autowired
    public StatisticalAspect(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Before(value = InstrumentRequestPoint)
    public void statisticalInstrumentRequest() {
        amqpTemplate.convertAndSend("campephilus", "instrumentRequest", "now : " + new Date());
    }

    /**
     * 在第一次接收到手术信息的时候调用
     */
    @AfterReturning(value = saveOperationInformationDOFromParseDataDTOPoint, returning = "result")
    public void statisticalOperationInformation(JoinPoint joinPoint, boolean result) {
        if (result) {
            // 获取目标方法的参数信息
            Object[] obj = joinPoint.getArgs();
            if (obj[0] instanceof ParseDataDTO) {
                amqpTemplate.convertAndSend("campephilus", "saveOperationInformationDO", obj[0]);
            }
        }
    }

    /**
     * 在接收采集器信息并通过验证时
     */
    @AfterReturning(value = saveOperationInformationDOFromParseDataDTOPoint, returning = "result")
    public void statisticalCollectorInformation(JoinPoint joinPoint, boolean result) {
        if (result) {
            // 获取目标方法的参数信息
            Object[] obj = joinPoint.getArgs();
            if (obj[0] instanceof ParseDataDTO) {
                amqpTemplate.convertAndSend("campephilus", "saveOperationInformationDOFromParseDataDTO", obj[0]);
            }
        }
    }
}