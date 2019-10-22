package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.impl;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalAnesthesiaDepthMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz.EvaluationAnesthesiaDepthMonitorRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalAnesthesiaDepthMonitorService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 麻醉深度监测仪类服务实现类
 * @author cz
 */
@Service("anesthesiaDepthMonitorEvaluationService")
public class EvalAnesthesiaDepthMonitorServiceImpl implements EvalAnesthesiaDepthMonitorService {

    @Autowired
    private EvaluationAnesthesiaDepthMonitorRepository evaluationAnesthesiaDepthMonitorRepository;


    /**
     * 保存麻醉深度监测仪评价实体表
     *
     * @param evalAnesthesiaDepthMonitor 麻醉深度监测仪评价表
     * @return 是否成功
     */
    @Override
    public ResponseEntity<String> saveAnesthesiaDepthMonitorEvaluation(EvalAnesthesiaDepthMonitor evalAnesthesiaDepthMonitor) {

        EvalAnesthesiaDepthMonitor result = evaluationAnesthesiaDepthMonitorRepository.save(evalAnesthesiaDepthMonitor);

        if (result != null) {
            return ResponseEntity.success("OK");
        } else {
            return ResponseEntity.error("NO");
        }

    }
}
