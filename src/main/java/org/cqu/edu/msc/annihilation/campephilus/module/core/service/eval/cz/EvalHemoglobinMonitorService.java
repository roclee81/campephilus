package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalApplicationHemoglobinMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;

/**
 * 血红蛋白评价服务
 * @author cz
 */
public interface EvalHemoglobinMonitorService {

    /**
     * 保存血红蛋白监测仪评价信息
     *
     * @param evalApplicationHemoglobinMonitor 评价信息
     * @return 是否成功
     */
    ResponseEntity<String> saveHemoglobinMonitorEvaluation(EvalApplicationHemoglobinMonitor evalApplicationHemoglobinMonitor);

}
