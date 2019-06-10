package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationInfoService;
import org.cqu.edu.msc.annihilation.common.utils.ControllerCrudUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
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
    ResponseEntity getOperationState(@RequestParam(value = "operationNumber", defaultValue = "0") int operationNumber) {
        int operationState = operationInfoService.getOperationStateByOperationNumber(operationNumber);
        return ControllerCrudUtils.listResponseEntity(operationState);
    }

}