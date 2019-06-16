package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.data;

import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
public class DataController {

    private final RedisTemplate<String, Object> redisTemplate;

    public DataController(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("")
    public ResultVO list(@RequestParam("operationNumber") String operationNumber,
                         @RequestParam("serialNumber") String serialNumber) {
        String key = "on:" + operationNumber + "sn:" + serialNumber;
        Object value = redisTemplate.opsForValue().get(key);
        return ResultVOUtils.checkAndReturn(value);
    }
}
