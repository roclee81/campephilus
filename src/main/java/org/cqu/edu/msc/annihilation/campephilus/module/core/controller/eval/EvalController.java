package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval;

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
    public ResultVO save(@RequestParam(value = "evalCode", defaultValue = "1") int evalCode,
                         @RequestParam(value = "data", defaultValue = "{}") String data) {
        evalSaveHandlerContext.evalSaveService(evalCode,data);
        return ResultVOUtils.success();
    }
}