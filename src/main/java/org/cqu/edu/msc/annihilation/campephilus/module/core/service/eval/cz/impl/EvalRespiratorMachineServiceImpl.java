package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.impl;


import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.EvaluationRequestCode;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalApplicationRespiratorMachine;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz.EvaluationRespiratorMachineRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalRespiratorMachineService;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 呼吸机评价实现类
 * @author cz
 */
@Service("respiratorMachineEvaluationService")
public class EvalRespiratorMachineServiceImpl implements EvalRespiratorMachineService {

    @Autowired
    private EvaluationRespiratorMachineRepository evaluationRespiratorMachineRepository;

    /**
     * 保存呼吸机评价记录
     *
     * @param evalApplicationRespiratorMachine 评价
     * @return 是否成功
     */
    @Override
    public ResultVO saveRespiratorMachineEvaluation(EvalApplicationRespiratorMachine evalApplicationRespiratorMachine) {

        EvalApplicationRespiratorMachine result = evaluationRespiratorMachineRepository.save(evalApplicationRespiratorMachine);
        if (result != null) {
            return ResultVOUtils.success("OK");
        } else {
            return ResultVOUtils.error(EvaluationRequestCode.RESPIRATOR_MACHINE, "Error");
        }
    }
}
