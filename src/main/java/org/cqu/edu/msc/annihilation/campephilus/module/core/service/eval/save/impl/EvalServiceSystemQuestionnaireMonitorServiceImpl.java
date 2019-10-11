package org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.save.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.eval.EvalServiceSystemQuestionnaireMonitor;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.EvalEntityEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.eval.EvalServiceSystemQuestionnaireMonitorRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.save.handler.EvalSaveService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.eval.save.handler.HandlerType;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/10/11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class EvalServiceSystemQuestionnaireMonitorServiceImpl implements EvalSaveService, HandlerType {

    @Autowired
    private EvalServiceSystemQuestionnaireMonitorRepository repository;

    @Override
    public Object save(Object object) {
        EvalServiceSystemQuestionnaireMonitor entity = ParseJsonUtil.getTObject(EvalServiceSystemQuestionnaireMonitor.class, (String) object);
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(repository, entity);
    }

    @Override
    public Integer getType() {
        return EvalEntityEnum.EVAL_SERVICE_SYSTEM_QUESTIONNAIRE_MONITOR.getCode();
    }
}