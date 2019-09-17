package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.data;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.DataListFactory;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataListService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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

    @GetMapping("/newest")
    public ResultVO getNewestByOperationNumberAndSerialNumber(
            @RequestParam(value = "deviceCode", defaultValue = "") int deviceCode,
            @RequestParam(value = "operationNumber", defaultValue = "-1") int operationNumber,
            @RequestParam(value = "serialNumber", defaultValue = "-1") String serialNumber) {
        return null;
    }

    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "deviceCode", defaultValue = "1") int deviceCode,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        DataListService dataListService = DataListFactory.getDataSaveService(deviceCode);
        Object result = Objects.isNull(dataListService) ? null : dataListService.list(page, size);
        return ControllerCrudUtils.list(result);
    }

//    @GetMapping("/list")
//    public ResultVO listByOperationNumberAndSerialNumber(
//            @RequestParam(value = "deviceCode", defaultValue = "") String deviceCode,
//            @RequestParam(value = "operationNumber", defaultValue = "-1") String operationNumber,
//            @RequestParam(value = "serialNumber", defaultValue = "") String serialNumber) {
//        // TODO 没写
//        return null;
//    }
}
