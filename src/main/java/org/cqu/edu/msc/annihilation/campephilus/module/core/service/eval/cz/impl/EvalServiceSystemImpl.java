package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.impl;


import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.EvaluationRequestCode;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.servicesystem.EvalServiceSystem;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz.EvaluationServiceSystemRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalServiceSystemService;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务体系评价服务实现类
 * @author cz
 */
@Service("serviceSystemEvaluationService")
public class EvalServiceSystemImpl implements EvalServiceSystemService {

    @Autowired
    private EvaluationServiceSystemRepository evaluationServiceSystemRepository;


    /**
     * 保存服务体系评价表
     *
     * @param evalServiceSystem 服务体系评价表
     * @return 是否成功
     */
    @Override
    public ResultVO saveServiceSystemEvaluation(EvalServiceSystem evalServiceSystem) {

        EvalServiceSystem result = evaluationServiceSystemRepository.save(evalServiceSystem);

        if (result != null) {
            return ResultVOUtils.success("OK");
        } else {
            return ResultVOUtils.error(EvaluationRequestCode.SERVICE_SYSTEM, "Error");
        }
    }
}
