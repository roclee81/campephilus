package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

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

    @Override
    @GetMapping("")
    @Cacheable()
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                  @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(
                getCrudService()
                        .listAll(page, size)
                        .parallelStream()
                        .peek(t -> {
                            t.setLongOperationStartTime(TimeStampUtils.getTimestampOfDateTime(t.getOperationStartTime()));
                            t.setLongOperationEndTime(TimeStampUtils.getTimestampOfDateTime(t.getOperationEndTime()));
                            t.setLongCreate(TimeStampUtils.getTimestampOfDateTime(t.getGmtCreate()));
                            t.setLongModified(TimeStampUtils.getTimestampOfDateTime(t.getGmtModified()));
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping("/state")
    @Cacheable(key = "#operationNumber")
    public ResultVO getOperationState(@RequestParam(value = "operationNumber", defaultValue = "1") int operationNumber) {
        int operationState = operationInfoService.getOperationStateByOperationNumber(operationNumber);
        return ControllerCrudUtils.list(operationState);
    }

}