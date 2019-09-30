package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.save.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.EvalCerebralOximetryEntity;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.EvalEntityEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.EvalCerebralOximetryRepository;
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
public class EvalCerebralOximetryServiceImpl implements EvalSaveService, HandlerType {

    @Autowired
    private EvalCerebralOximetryRepository repository;

    @Override
    public Object save(Object object) {
        EvalCerebralOximetryEntity entity = ParseJsonUtil.getTObject(EvalCerebralOximetryEntity.class, (String) object);
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(repository, entity);
    }

    @Override
    public Integer getType() {
        return EvalEntityEnum.EVAL_CEREBRAL_OXIMETRY.getCode();
    }
}
