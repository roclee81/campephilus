package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.BaseController;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ControllerCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

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
public class OperationMarkInfoController extends BaseController<OperationMarkInfo> {

    private final OperationMarkInfoService operationMarkInfoService;

    @Autowired
    public OperationMarkInfoController(OperationMarkInfoService operationMarkInfoService) {
        this.operationMarkInfoService = operationMarkInfoService;
    }

    @Override
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "20") int size) {
        return ControllerCrudUtils.listAll(
                getCrudService()
                        .listAll(page, size)
                        .parallelStream()
                        .peek(t -> {
                            t.setLongMarkTime(TimeStampUtils.getTimeStampOfTimeStampObject(t.getMarkTime()));
                            t.setLongCreate(TimeStampUtils.getTimestampOfDateTime(t.getGmtCreate()));
                            t.setLongModified(TimeStampUtils.getTimestampOfDateTime(t.getGmtModified()));
                        })
                        .collect(Collectors.toList()));
    }

    @Override
    protected CrudService<OperationMarkInfo> getCrudService() {
        return operationMarkInfoService;
    }
}
