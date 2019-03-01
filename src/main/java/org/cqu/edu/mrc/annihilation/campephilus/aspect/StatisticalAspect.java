package org.cqu.edu.mrc.annihilation.campephilus.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.cqu.edu.mrc.annihilation.campephilus.service.impl.ScheduledServiceImpl;
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
public class StatisticalAspect {

    @Before("execution(public * org.cqu.edu.mrc.annihilation.campephilus.controller.InstrumentRequestController.processInstrumentData(..))")
    public void statisticalUpdateRequest() {
        ScheduledServiceImpl.secondRequest += 1;
    }

}