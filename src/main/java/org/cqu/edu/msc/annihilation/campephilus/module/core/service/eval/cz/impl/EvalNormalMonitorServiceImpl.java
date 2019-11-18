package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.impl;


import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.EvaluationRequestCode;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalNormalMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz.EvaluationNormalMonitorRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalNormalMonitorService;
import org.cqu.edu.msc.annihilation.common.utils.ResultVOUtils;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 监护仪评价实体服务实现类
 * @author cz
 */
@Service("normalMonitorEvaluationService")
public class EvalNormalMonitorServiceImpl implements EvalNormalMonitorService {


    @Autowired
    private EvaluationNormalMonitorRepository evaluationNormalMonitorRepository;

    /**
     * 保存监护仪评价实体
     *
     * @param evalNormalMonitor 实体
     * @return 是否成功
     */
    @Override
    public ResultVO saveNormalMonitorEvaluation(EvalNormalMonitor evalNormalMonitor) {

        EvalNormalMonitor result = evaluationNormalMonitorRepository.save(evalNormalMonitor);

        if (result != null) {
            return ResultVOUtils.success("OK");
        } else {
            return ResultVOUtils.error(EvaluationRequestCode.NORMAL_MONITOR, "Error");
        }
    }
}
