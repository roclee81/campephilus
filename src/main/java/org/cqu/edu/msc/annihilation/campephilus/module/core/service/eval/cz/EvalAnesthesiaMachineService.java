package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalAnesthesiaMachine;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;

/**
 * 麻醉机评价服务接口
 * @author cz
 */
public interface EvalAnesthesiaMachineService {


    /**
     * 保存麻醉机评价实体
     *
     * @param evalAnesthesiaMachine 麻醉机评价表
     * @return 是否成功
     */
    ResultVO saveAnesthesiaMachineEvaluation(EvalAnesthesiaMachine evalAnesthesiaMachine);

}
