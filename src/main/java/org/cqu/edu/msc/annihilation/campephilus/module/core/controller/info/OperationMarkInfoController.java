package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.*;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:07
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/operationMark")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION_MARK)
public class OperationMarkInfoController extends BaseController<OperationMarkInfo> {

    private final OperationMarkInfoService operationMarkInfoService;

    @Autowired
    public OperationMarkInfoController(OperationMarkInfoService operationMarkInfoService) {
        this.operationMarkInfoService = operationMarkInfoService;
    }

    @Override
    protected CrudService<OperationMarkInfo> getCrudService() {
        return operationMarkInfoService;
    }

//    @DeleteMapping("/id")
//    public ResultVO delete(@RequestParam(value = "id", defaultValue = "-1") int id) {
//        return ControllerCrudUtils.delete(getCrudService(), id);
//    }

    @GetMapping("/operationNumber")
    public ResultVO list(@RequestParam(value = "operationNumber", defaultValue = "-1") int operationNumber) {
        return ControllerCrudUtils.list(operationMarkInfoService.listByOperationNumber(operationNumber));
    }

}
