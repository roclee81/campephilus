package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationDeviceInfoService;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:21
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/operationDevice")
public class OperationDeviceInfoController extends BaseController<OperationDeviceInfo> {

    private final OperationDeviceInfoService operationDeviceInfoService;

    @Autowired
    public OperationDeviceInfoController(OperationDeviceInfoService operationDeviceInfoService) {
        this.operationDeviceInfoService = operationDeviceInfoService;
    }

    @Override
    protected CrudService<OperationDeviceInfo> getCrudService() {
        return operationDeviceInfoService;
    }

    @GetMapping("/")
    public ResultVO listByOperationNumber(@RequestParam(name = "operationNumber") int operationNumber) {
        return ResultVO.checkAndReturn(operationDeviceInfoService.listByOperationNumber(operationNumber));
    }
}
