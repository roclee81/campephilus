package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalBrainOxygenMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;

/**
 * 脑氧饱和度监测仪评价接口
 * @author cz
 */
public interface EvalBrainOxygenMonitorService {


    /**
     * 插入临床应用评价表-脑氧深度监测仪
     *
     * @param evalBrainOxygenMonitor 脑氧深度监测仪评价实体
     * @return 是否成功
     */
    ResultVO saveBrainOxygenMonitorEvaluation(EvalBrainOxygenMonitor evalBrainOxygenMonitor);

}
