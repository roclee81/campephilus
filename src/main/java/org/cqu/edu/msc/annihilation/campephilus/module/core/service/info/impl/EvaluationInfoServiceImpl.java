package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.EvaluationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.EvaluationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.EvaluationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/9/17
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class EvaluationInfoServiceImpl implements EvaluationInfoService {

    @Autowired
    private EvaluationInfoRepository repository;

    @Override
    public ResultDTO save(EvaluationInfo evaluationInfo) {
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, evaluationInfo);
    }

    @Override
    public ResultDTO delete(EvaluationInfo t) {
        return ServiceCrudCheckUtils.deleteObjectAndCheck(repository, t);
    }

    @Override
    public ResultDTO update(EvaluationInfo t) {
        return ServiceCrudCheckUtils.updateObjectAndCheck(repository, t);
    }

    @Deprecated
    @Override
    public void saveEvaluationInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        EvaluationInfo parseObject = ParseJsonUtil.parseJsonString(instrumentForm, EvaluationInfo.class);
        if (Objects.nonNull(parseObject)) {
            parseObject.setOperationNumber(instrumentForm.getOperationNumber());
            this.save(parseObject);
        }
    }

    @Override
    public ResultDTO saveList(InstrumentForm instrumentForm) {
        EvaluationInfo[] evaluationInfos =
                ParseJsonUtil.parseJsonString(instrumentForm, EvaluationInfo[].class);
        fillDefaultValue(instrumentForm, evaluationInfos);
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, evaluationInfos);
    }

    private static void fillDefaultValue(InstrumentForm instrumentForm, EvaluationInfo[] evaluationInfos) {
        for (EvaluationInfo evaluationInfo : evaluationInfos) {
            evaluationInfo.setOperationNumber(instrumentForm.getOperationNumber());
        }
    }

    public ResponseEnum saveList(EvaluationInfo[] evaluationInfos) {
        repository.saveAll(Arrays.asList(evaluationInfos));
        return ResponseEnum.SUCCESS;
    }
}
