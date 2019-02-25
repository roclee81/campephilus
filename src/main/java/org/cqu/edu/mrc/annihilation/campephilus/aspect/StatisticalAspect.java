package org.cqu.edu.mrc.annihilation.campephilus.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    /**
     * 每秒数据上传的请求数量
     */
    public static int minuteRequest = 0;

    /**
     * 每秒数据上传的请求有效数量
     */
    public static int minuteRequestValid = 0;

    /**
     * 每小时数据上传的请求数量
     */
    public static int hourRequest = 0;

    /**
     * 每小时数据上传的请求有效数量
     */
    public static int hourRequestValid = 0;

    @Before("execution(public * org.cqu.edu.mrc.annihilation.campephilus.controller.DataController.processUpdateData(..))")
    public void statisticalUpdateRequest() {
        minuteRequest += 1;
    }

}