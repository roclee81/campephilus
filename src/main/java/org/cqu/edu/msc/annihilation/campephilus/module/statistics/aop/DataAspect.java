package org.cqu.edu.msc.annihilation.campephilus.module.statistics.aop;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data.BaseSuperclass;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/4 16:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
@Aspect
public class DataAspect<T extends BaseSuperclass> {

    private final StringRedisTemplate stringRedisTemplate;

    public DataAspect(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    private final String saveDataPoint = "execution(public * org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.AbstractDataService.save(..))";

    @AfterReturning(value = saveDataPoint)
    public void saveDataPoint(JoinPoint point) {
        Object[] objects = point.getArgs();
        T t = (T) objects[0];
        t.setGmtCreate(new Date());
        String key = "on:" + t.getOperationNumber() + "sn" + t.getSerialNumber();
        String value = new Gson().toJson(t);
        stringRedisTemplate.opsForValue().set(key, value);
    }
}
