package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.data;

import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
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

    @GetMapping("")
    public ResultVO getNewestByOperationNumberAndSerialNumber(
            @RequestParam(value = "deviceCode", defaultValue = "") String deviceCode,
            @RequestParam(value = "operationNumber", defaultValue = "-1") String operationNumber,
            @RequestParam(value = "serialNumber", defaultValue = "-1") String serialNumber) {
        return
    }

    @GetMapping("/list")
    public ResultVO listByOperationNumberAndSerialNumber(
            @RequestParam(value = "deviceCode", defaultValue = "") String deviceCode,
            @RequestParam(value = "operationNumber", defaultValue = "-1") String operationNumber,
            @RequestParam(value = "serialNumber", defaultValue = "") String serialNumber) {
        // TODO 没写
        return null;
    }
}
