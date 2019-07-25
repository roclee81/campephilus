package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.cache.CacheRemove;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.OperationStateEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:05
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class OperationInfoServiceImpl extends AbstractInfoService<OperationInfo, Integer> implements OperationInfoService {

    private final OperationInfoRepository operationInfoRepository;

    @Autowired
    public OperationInfoServiceImpl(OperationInfoRepository operationInfoRepository) {
        this.operationInfoRepository = operationInfoRepository;
    }

    @Override
    public JpaRepository<OperationInfo, Integer> getJpaRepository() {
        return operationInfoRepository;
    }

    @Override
    protected Integer getId(OperationInfo operationInfo) {
        return operationInfo.getOperationNumber();
    }

    @Override
    public void saveOperationInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, OperationInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        this.save(parseObject);
    }

    @Override
    public Integer countOperationInfo() {
        return Math.toIntExact(operationInfoRepository.count());
    }

    @Override
    public int getOperationStateByOperationNumber(int operationNumber) {
        // 首先查询是否存在该条数据，根据OperationNumber查询
        OperationInfo queryResult = operationInfoRepository.findByOperationNumber(operationNumber);
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsNotExist(queryResult);
        return queryResult.getOperationState();
    }

    @Override
    @CacheRemove(value = CacheConstant.CACHE_NAME_INFO_OPERATION)
    public void updateOperationStartTimeFromInstrumentForm(InstrumentForm instrumentForm) {
        // 首先查询是否存在该条数据，根据OperationNumber查询
        OperationInfo queryResult = operationInfoRepository.findByOperationNumber(instrumentForm.getOperationNumber());
        // 判断到数据不存在则抛出错误
        CheckUtils.checkDataIsNotExist(queryResult);
        queryResult.setOperationStartTime(LocalDateTime.now());
        queryResult.setOperationState(1);
        this.update(queryResult);
    }

    @Override
    @CacheRemove(value = CacheConstant.CACHE_NAME_INFO_OPERATION)
    public void updateOperationEndTimeFromInstrumentForm(InstrumentForm instrumentForm) {
        // 首先查询是否存在该条数据，根据OperationNumber查询
        OperationInfo queryResult = operationInfoRepository.findByOperationNumber(instrumentForm.getOperationNumber());
        // 判断到数据不存在则抛出错误
        CheckUtils.checkDataIsNotExist(queryResult);
        queryResult.setOperationEndTime(LocalDateTime.now());
        queryResult.setOperationState(2);
        this.update(queryResult);
    }

    @Override
    public Map<Integer, Integer> getOperationInfoByCurrent() {
        Map<Integer, Integer> result = new ConcurrentHashMap<>(16);
        List<OperationInfo> operationInfoList = operationInfoRepository.findByOperationStateIs(OperationStateEnum.IN_PREPARATION.getCode());
        operationInfoList.parallelStream()
                .forEach(operationInfo -> result.put(operationInfo.getOperationNumber(), OperationStateEnum.IN_PREPARATION.getCode()));
        operationInfoList = operationInfoRepository.findByOperationStateIs(OperationStateEnum.IN_PROGRESS.getCode());
        operationInfoList.parallelStream()
                .forEach(operationInfo -> result.put(operationInfo.getOperationNumber(), OperationStateEnum.IN_PROGRESS.getCode()));
        return result;
    }

    @Override
    public List<OperationInfo> listAll(int page, int size) {
        return super.listAll(page, size)
                .parallelStream()
                .peek(t -> {
                    t.setLongOperationStartTime(TimeStampUtils.getTimestampOfDateTime(t.getOperationStartTime()));
                    t.setLongOperationEndTime(TimeStampUtils.getTimestampOfDateTime(t.getOperationEndTime()));
                })
                .collect(Collectors.toList());
    }

    @Override
    public long countAll() {
        return getJpaRepository().count();
    }
}
