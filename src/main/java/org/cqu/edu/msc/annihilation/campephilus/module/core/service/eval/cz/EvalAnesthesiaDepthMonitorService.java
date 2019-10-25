package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalAnesthesiaDepthMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;

/**
 * 麻醉深度评价表服务接口
 * @author cz
 */
public interface EvalAnesthesiaDepthMonitorService {

    /**
     * 保存麻醉深度监测仪评价实体表
     *
     * @param evalAnesthesiaDepthMonitor 麻醉深度监测仪评价表
     * @return 是否成功
     */
    ResultVO saveAnesthesiaDepthMonitorEvaluation(EvalAnesthesiaDepthMonitor evalAnesthesiaDepthMonitor);


}
