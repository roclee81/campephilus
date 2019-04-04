package org.cqu.edu.msc.annihilation.campephilus.module.statistical.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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

//    private final AmqpTemplate amqpTemplate;
//
//    private final String InstrumentRequestPoint = "execution(public * InstrumentRequestController.processInstrumentData(..))";
//    private final String saveOperationInformationDOFromParseDataDTOPoint = "execution(public * OperationInformationService.saveOperationInformationDOFromParseDataDTO(..))";
//
//    @Autowired
//    public StatisticalAspect(AmqpTemplate amqpTemplate) {
//        this.amqpTemplate = amqpTemplate;
//    }
//
//    @Before(value = InstrumentRequestPoint)
//    public void statisticalInstrumentRequest() {
//        amqpTemplate.convertAndSend("campephilus", "instrumentRequest", "now : " + new Date());
////        StatisticalRequestCache.secondRequest++;
//    }
//
//    /**
//     * 在第一次接收到手术信息的时候调用
//     */
//    @AfterReturning(value = saveOperationInformationDOFromParseDataDTOPoint, returning = "result")
//    public void statisticalOperationInformation(JoinPoint joinPoint, boolean result) {
//        amqpTemplate.convertAndSend("campephilus", "saveOperationInformationDO", new MessageVO(result, joinPoint));
////        if (result) {
////            // 获取目标方法的参数信息
////            Object[] obj = joinPoint.getArgs();
////            if (obj[0] instanceof ParseDataDTO) {
////                // AOP检测到仪器上传了手术开始信息，将调用StatisticalService来更新
////                statisticalService.updateStatisticalDOOperationInformationWhenUpdateSuccess((ParseDataDTO) obj[0]);
////            }
////        }
//    }
//
//    /**
//     * 在接收采集器信息并通过验证时
//     */
//    @AfterReturning(value = saveOperationInformationDOFromParseDataDTOPoint, returning = "result")
//    public void statisticalCollectorInformation(JoinPoint joinPoint, boolean result) {
//        amqpTemplate.convertAndSend("campephilus", "collectorInformation", new MessageVO(result, joinPoint));

//        if (returnResult) {
//            // 获取目标方法的参数信息
//            Object[] obj = joinPoint.getArgs();
//            if (obj[0] instanceof ParseDataDTO) {
//                collectorInformationService.updateCollectorInformationDOWhenUpdateSuccess((ParseDataDTO) obj[0]);
//            }
//        }
//    }
}