package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.save.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.EvalCerebralOxygenEntity;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.EvalEntityEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.EvalCerebralOxygenRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.save.handler.EvalSaveService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.save.handler.HandlerType;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/9/30
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class EvalCerebralOxygenSaveServiceImpl implements EvalSaveService, HandlerType {

    @Autowired
    private EvalCerebralOxygenRepository repository;


    @Override
    public Object save(Object object) {
        EvalCerebralOxygenEntity entity = ParseJsonUtil.getTObject(EvalCerebralOxygenEntity.class, (String) object);
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(repository, entity);
    }

    @Override
    public Integer getType() {
        return EvalEntityEnum.EVAL_CEREBRAL_OXYGEN.getCode();
    }
}
