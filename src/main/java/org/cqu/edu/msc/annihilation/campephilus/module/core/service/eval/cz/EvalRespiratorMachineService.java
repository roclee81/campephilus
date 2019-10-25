package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.application.EvalApplicationRespiratorMachine;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;

/**
 * 呼吸机评价服务
 * @author cz
 */
public interface EvalRespiratorMachineService {

    /**
     * 保存呼吸机评价记录
     *
     * @param evalApplicationRespiratorMachine 评价
     * @return 是否成功
     */
    ResultVO saveRespiratorMachineEvaluation(EvalApplicationRespiratorMachine evalApplicationRespiratorMachine);

}
