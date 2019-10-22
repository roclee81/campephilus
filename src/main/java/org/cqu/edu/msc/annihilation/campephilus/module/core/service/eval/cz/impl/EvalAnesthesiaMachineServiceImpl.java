package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.impl;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalAnesthesiaMachine;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.cz.EvaluationAnesthesiaMachineRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz.EvalAnesthesiaMachineService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 麻醉机评价服务接口
 * @author cz
 */
@Service("anesthesiaMachineEvaluationService")
public class EvalAnesthesiaMachineServiceImpl implements EvalAnesthesiaMachineService {

    @Autowired
    private EvaluationAnesthesiaMachineRepository anesthesiaMachineEvaluationRepository;

    /**
     * 保存麻醉机评价实体
     *
     * @param evalAnesthesiaMachine 麻醉机评价表
     * @return 是否成功
     */
    @Override
    public ResponseEntity<String> saveAnesthesiaMachineEvaluation(EvalAnesthesiaMachine evalAnesthesiaMachine) {

        EvalAnesthesiaMachine result = anesthesiaMachineEvaluationRepository.save(evalAnesthesiaMachine);

        if (result != null) {
            return ResponseEntity.success("OK");
        } else {
            return ResponseEntity.error("NO");
        }

    }
}
