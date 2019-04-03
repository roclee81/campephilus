package org.cqu.edu.mrc.annihilation.campephilus.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.service.CollectorInformationService;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalService;
import org.cqu.edu.mrc.annihilation.campephilus.cache.StatisticalRequestCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/25 20:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Aspect
@Component
@Slf4j
public class StatisticalAspect {

    private final StatisticalService statisticalService;
    private final CollectorInformationService collectorInformationService;

    private final String InstrumentRequestPoint = "execution(public * org.cqu.edu.mrc.annihilation.campephilus.controller.InstrumentRequestController.processInstrumentData(..))";
    private final String saveOperationInformationDOFromParseDataDTOPoint = "execution(public * org.cqu.edu.mrc.annihilation.campephilus.service.OperationInformationService.saveOperationInformationDOFromParseDataDTO(..))";

    @Autowired
    public StatisticalAspect(StatisticalService statisticalService, CollectorInformationService collectorInformationService) {
        this.statisticalService = statisticalService;
        this.collectorInformationService = collectorInformationService;
    }

    @Before(value = InstrumentRequestPoint)
    public void statisticalUpdateRequest() {
        StatisticalRequestCache.secondRequest++;
    }

    /**
     * 在第一次接收到手术信息的时候调用
     */
    @AfterReturning(value = saveOperationInformationDOFromParseDataDTOPoint, returning = "returnResult")
    public void statisticalOperationInformation(JoinPoint joinPoint, boolean returnResult) {
        if (returnResult) {
            // 获取目标方法的参数信息
            Object[] obj = joinPoint.getArgs();
            if (obj[0] instanceof ParseDataDTO) {
                // AOP检测到仪器上传了手术开始信息，将调用StatisticalService来更新
                statisticalService.updateStatisticalDOOperationInformationWhenUpdateSuccess((ParseDataDTO) obj[0]);
            }
        }
    }

    /**
     * 在接收采集器信息并通过验证时
     */
    @AfterReturning(value = saveOperationInformationDOFromParseDataDTOPoint, returning = "returnResult")
    public void statisticalCollectorInformation(JoinPoint joinPoint, boolean returnResult) {
        if (returnResult) {
            // 获取目标方法的参数信息
            Object[] obj = joinPoint.getArgs();
            if (obj[0] instanceof ParseDataDTO) {
                collectorInformationService.updateCollectorInformationDOWhenUpdateSuccess((ParseDataDTO) obj[0]);
            }
        }
    }
}