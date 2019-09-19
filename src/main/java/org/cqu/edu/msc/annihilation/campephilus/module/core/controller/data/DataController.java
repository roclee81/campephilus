package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.data;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.DataGetNewestFactory;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.DataListFactory;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataGetNewestService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataListService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.DataSaveFactory;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.cache.annotation.CacheConfig;
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
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_DATA_DEVICE_CODE)
public class DataController {

    @GetMapping("/newest")
    public ResultVO getNewest(@RequestParam(value = "deviceCode", defaultValue = "-1") int deviceCode,
                              @RequestParam(value = "operationNumber", defaultValue = "-1") int operationNumber,
                              @RequestParam(value = "serialNumber", defaultValue = "-1") String serialNumber) {
        DataGetNewestService service = DataGetNewestFactory.getDataGetNewestService(deviceCode);
        Object result = Objects.isNull(service) ? null : service.getNewest(operationNumber, serialNumber);
        return ControllerCrudUtils.list(result);
    }

    @GetMapping("")
    public ResultVO list(@RequestParam(value = "deviceCode", defaultValue = "1") int deviceCode,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        DataListService dataListService = DataListFactory.getDataListService(deviceCode);
        Object result = Objects.isNull(dataListService) ? null : dataListService.list(page, size);
        return ControllerCrudUtils.list(result);
    }

    @PostMapping("")
    public ResultVO save(@RequestParam(value = "deviceCode", defaultValue = "1") int deviceCode,
                         @RequestParam(value = "data", defaultValue = "{}") String data) {
        int state = DataSaveFactory.save(deviceCode, data);
        return state != -1 ? ResultVOUtils.success() : ResultVOUtils.unknowError();
    }
}
