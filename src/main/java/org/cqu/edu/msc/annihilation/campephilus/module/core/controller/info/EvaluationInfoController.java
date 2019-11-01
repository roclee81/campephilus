package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.EvaluationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/9/17
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/info/evaluation")
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_EVALUATION)
public class EvaluationInfoController {

    @Autowired
    private EvaluationInfoService evaluationInfoService;

    @PostMapping(value = "/list")
    public ResultVO saveList(@Valid InstrumentForm instrumentForm, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);
        return new ResultVO(instrumentForm.getCode() + 1, "success");
//        return ResultVOUtils.checkAndReturn(evaluationInfoService.saveList(instrumentForm));
    }
}
