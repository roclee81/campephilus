package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info.EvaluationInfoDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.EvaluationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.EvaluationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.EvaluationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
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
public class EvaluationInfoServiceImpl extends AbstractInfoService<EvaluationInfo, Integer> implements EvaluationInfoService {

    @Autowired
    private EvaluationInfoRepository evaluationInfoRepository;

    @Override
    public JpaRepository<EvaluationInfo, Integer> getJpaRepository() {
        return evaluationInfoRepository;
    }

    @Override
    protected Integer getId(EvaluationInfo evaluationInfo) {
        return evaluationInfo.getId();
    }

    @Override
    public List<EvaluationInfoDTO> listEvaluationInfoDTO(int page, int size) {
        return EvaluationInfoDTO.structureEvaluationInfoDTOs(this.listAll(page, size));
    }

    @Override
    public EvaluationInfo save(EvaluationInfo evaluationInfo) {
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(evaluationInfoRepository, evaluationInfo);
    }

    @Override
    public void saveEvaluationInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        EvaluationInfo parseObject = ParseJsonUtil.parseJsonString(instrumentForm, EvaluationInfo.class);
        if (Objects.nonNull(parseObject)) {
            parseObject.setOperationNumber(instrumentForm.getOperationNumber());
            this.save(parseObject);
        }
    }

    @Override
    public ResponseEnum saveList(InstrumentForm instrumentForm) {
        EvaluationInfo[] evaluationInfos =
                ParseJsonUtil.parseJsonString(instrumentForm, EvaluationInfo[].class);
        fillDefaultValue(instrumentForm, evaluationInfos);
        saveList(evaluationInfos);
        return ResponseEnum.SUCCESS;
    }

    private static void fillDefaultValue(InstrumentForm instrumentForm, EvaluationInfo[] evaluationInfos) {
        for (EvaluationInfo evaluationInfo : evaluationInfos) {
            evaluationInfo.setOperationNumber(instrumentForm.getOperationNumber());
        }
    }

    public ResponseEnum saveList(EvaluationInfo[] evaluationInfos) {
        evaluationInfoRepository.saveAll(Arrays.asList(evaluationInfos));
        return ResponseEnum.SUCCESS;
    }
}
