package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.impl;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalApplicationHemoglobinMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz.EvaluationHemoglobinMonitorRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalHemoglobinMonitorService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 血红蛋白评价表实现类
 * @author cz
 */
@Service("hemoglobinMonitorEvaluationService")
public class EvalHemoglobinMonitorServiceImpl implements EvalHemoglobinMonitorService {

    @Autowired
    private EvaluationHemoglobinMonitorRepository evaluationHemoglobinMonitorRepository;

    /**
     * 保存血红蛋白监测仪评价信息
     *
     * @param evalApplicationHemoglobinMonitor 评价信息
     * @return 是否成功
     */
    @Override
    public ResponseEntity<String> saveHemoglobinMonitorEvaluation(EvalApplicationHemoglobinMonitor evalApplicationHemoglobinMonitor) {
        EvalApplicationHemoglobinMonitor result = evaluationHemoglobinMonitorRepository.save(evalApplicationHemoglobinMonitor);
        if (result != null) {
            return ResponseEntity.success("OK");
        } else {
            return ResponseEntity.error("NO");
        }
    }
}
