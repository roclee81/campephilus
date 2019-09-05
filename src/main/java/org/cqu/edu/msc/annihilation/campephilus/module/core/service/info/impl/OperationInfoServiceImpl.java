package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.OperationStateEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:05
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
@Service
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION)
public class OperationInfoServiceImpl implements OperationInfoService {

    private final OperationInfoRepository operationInfoRepository;

    @Autowired
    public OperationInfoServiceImpl(OperationInfoRepository operationInfoRepository) {
        this.operationInfoRepository = operationInfoRepository;
    }

    private Integer getId(OperationInfo operationInfo) {
        return operationInfo.getOperationNumber();
    }

    @CacheEvict(allEntries = true)
    @Override
    public OperationInfo saveOperationInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, OperationInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        return this.save(parseObject);
    }

    @Override
    public int countOperationInfo() {
        return Math.toIntExact(operationInfoRepository.count());
    }

    @Cacheable(key = "'method:'+#root.methodName")
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
        List<OperationInfo> operationInfoList = operationInfoRepository.findByOperationStateIs(OperationStateEnum.IN_PREPARATION.getCode());
        operationInfoList.parallelStream()
                .forEach(operationInfo -> result.put(operationInfo.getOperationNumber(), OperationStateEnum.IN_PREPARATION.getCode()));
        operationInfoList = operationInfoRepository.findByOperationStateIs(OperationStateEnum.IN_PROGRESS.getCode());
        operationInfoList.parallelStream()
                .forEach(operationInfo -> result.put(operationInfo.getOperationNumber(), OperationStateEnum.IN_PROGRESS.getCode()));
        return result;
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @Override
    public List<OperationInfo> listAll(int page, int size) {
        Page<OperationInfo> searchResult = operationInfoRepository.findAll(PageRequest.of(page, size));
        List<OperationInfo> operationInfoList = ConvertUtils.convertObjectTimeStamp(searchResult.getContent());
        return operationInfoList
                .parallelStream()
                .peek(operationInfo -> {
                    operationInfo.setLongOperationStartTime(TimeStampUtils.getTimestampOfDateTime(operationInfo.getOperationStartTime()));
                    operationInfo.setLongOperationEndTime(TimeStampUtils.getTimestampOfDateTime(operationInfo.getOperationEndTime()));
                })
                .collect(Collectors.toList());
    }

    /**
     * 通过T中的数据查询数据库中完整的字段
     *
     * @param operationInfo 泛型
     * @return 数据库中完整的字段
     */
    private OperationInfo getDataBaseEntity(OperationInfo operationInfo) {
        return operationInfoRepository.findByOperationNumber(operationInfo.getOperationNumber());
    }

    @Override
    public OperationInfo save(OperationInfo operationInfo) {
        // 首先查询是否存在该条数据
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(operationInfoRepository.findById(getId(operationInfo)).orElse(null));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(operationInfoRepository, operationInfo);
    }

    @Override
    public OperationInfo update(OperationInfo operationInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        return ServiceCrudCheckUtils.updateObjectAndCheckSuccess(operationInfoRepository, getId(operationInfo), operationInfo);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void delete(OperationInfo operationInfo) {
        // 判断t是否为null，同时查询t是否存在在数据库中，如果存在则删除
        if (Objects.nonNull(operationInfo) && Objects.nonNull(operationInfo = getDataBaseEntity(operationInfo))) {
            operationInfoRepository.delete(operationInfo);
            // TODO 打印需不需要提取出来
            log.info("delete:{}", operationInfo.toString());
        }
    }

    @Override
    public List<OperationInfo> listById(Object id) {
        return null;
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @Override
    public long countAll() {
        return operationInfoRepository.count();
    }

}
