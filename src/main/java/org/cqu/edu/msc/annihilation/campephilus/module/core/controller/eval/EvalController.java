package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.DataSaveFactory;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.save.handler.EvalSaveHandlerContext;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/25
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RequestMapping(value = "/eval")
@CrossOrigin
@RestController
public class EvalController {

    @Autowired
    private EvalSaveHandlerContext evalSaveHandlerContext;

    @PostMapping("")
    public ResultVO save(@RequestParam(value = "deviceCode", defaultValue = "1") int deviceCode,
                         @RequestParam(value = "data", defaultValue = "{}") String data) {
        evalSaveHandlerContext.getSaveInstance(deviceCode).save(data);
        int state = DataSaveFactory.save(deviceCode, data);
        return state != -1 ? ResultVOUtils.success() : ResultVOUtils.unknowError();
    }
}