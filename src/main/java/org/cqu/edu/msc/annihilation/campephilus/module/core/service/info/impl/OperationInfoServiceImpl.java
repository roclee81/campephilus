package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info.OperationInfoDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.OperationStateEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
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
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION)
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
    public List<OperationInfoDTO> listOperationInfoDTO(int page, int size) {
        return convertOperationMarkInfoDTOList(this.listAll(page, size));
    }

    @CacheEvict(allEntries = true)
    @Override
    public OperationInfo saveOperationInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, OperationInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        return this.save(parseObject);
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
        CheckUtils.checkDataIsNotExisted(queryResult);
        return queryResult.getOperationState();
    }

    @CacheEvict(allEntries = true)
    @Override
    public void updateOperationStartTimeFromInstrumentForm(InstrumentForm instrumentForm) {
        // 首先查询是否存在该条数据，根据OperationNumber查询
        OperationInfo queryResult = operationInfoRepository.findByOperationNumber(instrumentForm.getOperationNumber());
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
        OperationInfo queryResult = operationInfoRepository.findByOperationNumber(instrumentForm.getOperationNumber());
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
        List<OperationInfo> operationInfoList = operationInfoRepository.findByOperationStateIs(OperationStateEnum.IN_PREPARATION.getCode());
        operationInfoList.forEach(operationInfo -> result.put(operationInfo.getOperationNumber(), OperationStateEnum.IN_PREPARATION.getCode()));
        // 查询手术进行中的信息
        operationInfoList = operationInfoRepository.findByOperationStateIs(OperationStateEnum.IN_PROGRESS.getCode());
        operationInfoList.forEach(operationInfo -> result.put(operationInfo.getOperationNumber(), OperationStateEnum.IN_PROGRESS.getCode()));
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

    /**
     * 通过T中的数据查询数据库中完整的字段
     *
     * @param operationInfo 泛型
     * @return 数据库中完整的字段
     */
    @Override
    public OperationInfo getDataBaseEntity(OperationInfo operationInfo) {
        return operationInfoRepository.findByOperationNumber(operationInfo.getOperationNumber());
    }

    private static List<OperationInfoDTO> convertOperationMarkInfoDTOList(List<OperationInfo> operationInfo) {
        return operationInfo
                .parallelStream()
                .map(OperationInfoDTO::convertOperationInfoDTO)
                .collect(Collectors.toList());
    }
}
