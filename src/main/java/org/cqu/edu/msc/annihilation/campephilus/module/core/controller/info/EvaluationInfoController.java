package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.EvaluationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
