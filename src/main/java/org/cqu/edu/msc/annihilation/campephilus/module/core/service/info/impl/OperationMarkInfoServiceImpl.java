package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationMarkInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
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

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
@Service
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION_MARK)
public class OperationMarkInfoServiceImpl implements OperationMarkInfoService {

    @Autowired
    private OperationMarkInfoRepository operationMarkInfoRepository;

    @Override
    public void saveOperationMarkInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationMarkInfo parseObject = ParseJsonUtil.parseJsonString(instrumentForm, OperationMarkInfo.class);
        if (null != parseObject) {
            parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        }
        this.save(parseObject);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void save(OperationMarkInfo operationMarkInfo) {
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudCheckUtils.saveObjectAndCheckSuccess(operationMarkInfoRepository, operationMarkInfo);
    }

    @Cacheable(key = "'method:'+#root.methodName+',page:'+#p0+',size:'+#p1")
    @Override
    public List<OperationMarkInfo> listAll(int page, int size) {
        Page<OperationMarkInfo> searchResult = operationMarkInfoRepository.findAll(PageRequest.of(page, size));
        return convertMarkTime(ConvertUtils.convertObjectTimeStamp(searchResult.getContent()));
    }

    @Cacheable(key = "'method:'+#root.methodName+',operationNumber:'+#p0")
    @Override
    public List<OperationMarkInfo> listByOperationNumber(int operationNumber) {
        return convertMarkTime(ConvertUtils.convertObjectTimeStamp(operationMarkInfoRepository.findByOperationNumber(operationNumber)));
    }

    private List<OperationMarkInfo> convertMarkTime(List<OperationMarkInfo> list) {
        return list
                .parallelStream()
                .peek(t -> t.setLongMarkTime(TimeStampUtils.getTimeStampOfTimeStampObject(t.getMarkTime())))
                .collect(Collectors.toList());
    }

    @CacheEvict(allEntries = true)
    @Override
    public void update(OperationMarkInfo operationMarkInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(operationMarkInfoRepository, operationMarkInfo.getId(), operationMarkInfo);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void delete(OperationMarkInfo operationMarkInfo) {

    }

    @CacheEvict(allEntries = true)
    @Override
    public void delete(int id) {
        // 同时查询是否存在在数据库中，如果存在则删除
        OperationMarkInfo operationMarkInfo = getDataBaseEntity(id);
        if (Objects.nonNull(operationMarkInfo)) {
            operationMarkInfoRepository.delete(operationMarkInfo);
            // TODO 打印需不需要提取出来
            log.info("delete:{}", operationMarkInfo.toString());
        }
    }

    @Cacheable(key = "'method:'+#root.methodName")
    @Override
    public long countAll() {
        return operationMarkInfoRepository.count();
    }

    /**
     * 通过T中的数据查询数据库中完整的字段
     *
     * @param id id
     * @return 数据库中完整的字段
     */
    private OperationMarkInfo getDataBaseEntity(int id) {
        return operationMarkInfoRepository.findById(id).orElse(null);
    }
}
