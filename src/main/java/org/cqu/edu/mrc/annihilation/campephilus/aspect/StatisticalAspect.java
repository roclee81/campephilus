package org.cqu.edu.mrc.annihilation.campephilus.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.cqu.edu.mrc.annihilation.campephilus.service.ScheduledService;
import org.cqu.edu.mrc.annihilation.campephilus.value.StatisticalRequestValue;
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

    private final ScheduledService scheduledService;

    @Autowired
    public StatisticalAspect(ScheduledService scheduledService) {
        this.scheduledService = scheduledService;
    }

    @Before("execution(public * org.cqu.edu.mrc.annihilation.campephilus.controller.InstrumentRequestController.processInstrumentData(..))")
    public void statisticalUpdateRequest() {
        StatisticalRequestValue.secondRequest++;
    }

}