package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.cz;


import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.cz.servicesystem.EvalServiceSystem;
import org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity.ResponseEntity;
import org.cqu.edu.msc.annihilation.common.vo.ResultVO;

/**
 * 服务体系评价服务
 * @author cz
 */
public interface EvalServiceSystemService {

    /**
     * 保存服务体系评价表格
     *
     * @param evalServiceSystem 服务体系评价表
     * @return 是否成功
     */
     ResultVO saveServiceSystemEvaluation(EvalServiceSystem evalServiceSystem);

}
