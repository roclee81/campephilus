package org.cqu.edu.msc.annihilation.campephilus.module.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.cqu.edu.msc.annihilation.campephilus.module.core.cache.CacheRemove;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/14 16:48
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Aspect
@Component
@Slf4j
public class CacheRemoveAspect {

    private final RedisTemplate<String, String> redisTemplate;

    public CacheRemoveAspect(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 截获标有@CacheRemove的方法
     */
    @Pointcut(value = "(execution(* *.*(..)) && @annotation(org.cqu.edu.msc.annihilation.campephilus.module.core.cache.CacheRemove))")
    private void pointcut() {
    }

    /**
     * 功能描述: 切面在截获方法返回值之后
     *
     * @return void
     * @throws
     * @author fuyuchao
     * @date 2018/9/14 16:55
     * @params [joinPoint]
     */
    @AfterReturning(value = "pointcut()")
    private void process(JoinPoint joinPoint) {
        //获取被代理的类
        Object target = joinPoint.getTarget();
        //获取切入方法的数据
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入方法
        Method method = signature.getMethod();
        //获得注解
        CacheRemove cacheRemove = method.getAnnotation(CacheRemove.class);

        if (cacheRemove != null) {
            //清除当前类的缓存
            cleanRedisCache("*" + target.getClass().toString() + "*");

            String value = cacheRemove.value();
            if (!"".equals(value)) {
                Object h = redisTemplate.opsForValue().get("*" + value + "*");
                //缓存的项目所有redis业务部缓存
                cleanRedisCache("*" + value + "*");
            }
            // 需要移除的正则key
            String[] keys = cacheRemove.key();
            for (String key : keys) {
                //指定清除的key的缓存
                cleanRedisCache("*" + key + "*");
            }
        }
    }

    private void cleanRedisCache(String key) {
        if (key != null) {
            Set<String> stringSet = redisTemplate.keys(key);
            // 删除缓存
            redisTemplate.delete(stringSet);
            log.info("清除 " + key + " 缓存");
        }
    }
}
