package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.OperationStateEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:05
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION)
@Service
public class OperationInfoServiceImpl implements OperationInfoService {

    @Autowired
    private OperationInfoRepository repository;

    @Override
    public ResultDTO save(OperationInfo t) {
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, t);
    }

    @Override
    public ResultDTO delete(OperationInfo t) {
        return ServiceCrudCheckUtils.deleteObjectAndCheck(repository, t);
    }

    @Override
    public ResultDTO update(OperationInfo t) {
        return ServiceCrudCheckUtils.updateObjectAndCheck(repository, t);
    }

    @Override
    public ResultDTO list(int page, int size) {
        return ServiceCrudCheckUtils.listObjectAndCheck(repository, page, size);
    }

    @Override
    public ResultDTO listOperationInfoDTO(int page, int size) {
        return list(page, size);
    }

    @CacheEvict(allEntries = true)
    @Override
    public ResultDTO saveOperationInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, OperationInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        return save(parseObject);
    }

    @Override
    public Integer countOperationInfo() {
        return Math.toIntExact(repository.count());
    }

    @Override
    public int getOperationStateByOperationNumber(int operationNumber) {
        // 首先查询是否存在该条数据，根据OperationNumber查询
        OperationInfo queryResult = repository.findByOperationNumber(operationNumber);
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsNotExisted(queryResult);
        return queryResult.getOperationState();
    }

    @CacheEvict(allEntries = true)
    @Override
    public void updateOperationStartTimeFromInstrumentForm(InstrumentForm instrumentForm) {
        // 首先查询是否存在该条数据，根据OperationNumber查询
        OperationInfo queryResult = repository.findByOperationNumber(instrumentForm.getOperationNumber());
        // 判断到数据不存在则抛出错误
        CheckUtils.checkDataIsNotExisted(queryResult);
        queryResult.setOperationStartTime(LocalDateTime.now());
        queryResult.setOperationState(1);
        this.update(queryResult);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void updateOperationEndTimeFromInstrumentForm(InstrumentForm instrumentForm) {
        // 首先查询是否存在该条数据，根据OperationNumber查询
        OperationInfo queryResult = repository.findByOperationNumber(instrumentForm.getOperationNumber());
        // 判断到数据不存在则抛出错误
        CheckUtils.checkDataIsNotExisted(queryResult);
        queryResult.setOperationEndTime(LocalDateTime.now());
        queryResult.setOperationState(2);
        this.update(queryResult);
    }

    @Override
    public Map<Integer, Integer> getCurrentOperationInfo() {
        Map<Integer, Integer> result = new ConcurrentHashMap<>(16);
        // 首先查询手术还未开始，还在准备中的信息
        List<OperationInfo> operationInfoList = repository.findByOperationStateIs(OperationStateEnum.IN_PREPARATION.getCode());
        operationInfoList.forEach(operationInfo -> result.put(operationInfo.getOperationNumber(), OperationStateEnum.IN_PREPARATION.getCode()));
        // 查询手术进行中的信息
        operationInfoList = repository.findByOperationStateIs(OperationStateEnum.IN_PROGRESS.getCode());
        operationInfoList.forEach(operationInfo -> result.put(operationInfo.getOperationNumber(), OperationStateEnum.IN_PROGRESS.getCode()));
        return result;
    }
}
