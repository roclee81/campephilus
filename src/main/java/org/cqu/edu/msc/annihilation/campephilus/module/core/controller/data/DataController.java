package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.data;

import org.cqu.edu.msc.annihilation.common.utils.ResultUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 23:57
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 将多个仪器的数据打包返回
 */
@RestController
@RequestMapping(value = "/data")
public class DataController {

    private final StringRedisTemplate stringRedisTemplate;

    public DataController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GetMapping("/")
    public ResponseEntity list(@RequestParam("operationNumber") String operationNumber,
                               @RequestParam("serialNumber") String serialNumber) {
        String key = "on:" + operationNumber + "sn" + serialNumber;
        String value = stringRedisTemplate.opsForValue().get(key);
        // TODO 判断是否为空
        return ResultUtils.checkAndReturn(value);
    }
}
