package org.cqu.edu.msc.annihilation.campephilus.module.message.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data.BaseDataSuperclass;
import org.cqu.edu.msc.annihilation.campephilus.module.message.WebSocketServer;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/4 16:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
@Aspect
public class DataAspect<T extends BaseDataSuperclass> {

    private final RedisTemplate<String, Object> redisTemplate;

    private final String saveDataPoint = "execution(public * org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.AbstractDataService.save(..))";

    public DataAspect(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @SuppressWarnings("unchecked")
    @AfterReturning(value = saveDataPoint)
    public void saveDataPoint(JoinPoint point) {
        Object[] objects = point.getArgs();
        T t = (T) objects[0];
        t.setLongCreate(TimeStampUtils.getTimestampOfDateTime(t.getGmtCreate()));
        t.setLongModified(TimeStampUtils.getTimestampOfDateTime(t.getGmtModified()));
        String key = "on:" + t.getOperationNumber() + "sn:" + t.getSerialNumber();
        redisTemplate.opsForValue().set(key, t);
        redisTemplate.expire(key, 5, TimeUnit.MINUTES);
    }

    @SuppressWarnings("unchecked")
    @AfterReturning(value = saveDataPoint)
    public void pushMessage(JoinPoint point) {
        Object[] objects = point.getArgs();
        T t = (T) objects[0];
        t.setLongCreate(TimeStampUtils.getTimestampOfDateTime(t.getGmtCreate()));
        t.setLongModified(TimeStampUtils.getTimestampOfDateTime(t.getGmtModified()));
        WebSocketServer.sendInfo(new Gson().toJson(t));
    }
}