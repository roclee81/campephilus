package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.impl;


import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.EvaluationRequestCode;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalBrainOxygenMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz.EvaluationBrainOxygenMonitorRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalBrainOxygenMonitorService;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 脑氧饱和度临床应用服务实现类
 * @author cz
 */
@Service("brainOxygenMonitorEvaluationService")
public class EvalBrainOxygenMonitorServiceImpl implements EvalBrainOxygenMonitorService {

    /**
     * DAO层
     */
    @Autowired
    private EvaluationBrainOxygenMonitorRepository evaluationBrainOxygenMonitorRepository;

    /**
     * 插入脑氧饱和度评价实体
     *
     * @param evalBrainOxygenMonitor 脑氧深度监测仪评价实体
     * @return 是否成功
     */
    @Override
    public ResultVO saveBrainOxygenMonitorEvaluation(EvalBrainOxygenMonitor evalBrainOxygenMonitor) {

        EvalBrainOxygenMonitor result = evaluationBrainOxygenMonitorRepository.save(evalBrainOxygenMonitor);

        if (result != null) {
            return ResultVOUtils.success("OK");
        } else {
            return ResultVOUtils.error(EvaluationRequestCode.BRAIN_OXYGEN_MONITOR, "Error");
        }
    }
}
