package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/operation")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION)
public class OperationInfoController extends BaseController<OperationInfo> {

    private final OperationInfoService operationInfoService;

    @Autowired
    public OperationInfoController(OperationInfoService operationInfoService) {
        this.operationInfoService = operationInfoService;
    }

    @Override
    protected CrudService<OperationInfo> getCrudService() {
        return operationInfoService;
    }

    @GetMapping("/state")
    @Cacheable(key = "#operationNumber")
    public ResultVO getOperationState(@RequestParam(value = "operationNumber", defaultValue = "1") int operationNumber) {
        int operationState = operationInfoService.getOperationStateByOperationNumber(operationNumber);
        return ControllerCrudUtils.list(operationState);
    }

    @GetMapping("/current")
    public ResultVO get(){
        Map<Integer, Integer> map = operationInfoService.getOperationInfoByCurrent();
        return ControllerCrudUtils.list(map);
    }
}