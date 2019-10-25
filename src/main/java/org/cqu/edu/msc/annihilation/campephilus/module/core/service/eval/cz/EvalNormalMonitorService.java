package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalNormalMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;

/**
 * 普通监护仪评价服务接口
 * @author cz
 */
public interface EvalNormalMonitorService {

    /**
     * 保存监护仪评价实体
     *
     * @param evalNormalMonitor 实体
     * @return 是否成功
     */
    ResultVO saveNormalMonitorEvaluation(EvalNormalMonitor evalNormalMonitor);

}
