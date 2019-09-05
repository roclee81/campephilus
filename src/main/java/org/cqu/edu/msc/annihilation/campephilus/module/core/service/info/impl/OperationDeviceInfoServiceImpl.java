package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationDeviceInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationDeviceInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION_DEVICE)
@Service
public class OperationDeviceInfoServiceImpl implements OperationDeviceInfoService {

    private final OperationDeviceInfoRepository operationDeviceInfoRepository;

    @Autowired
    public OperationDeviceInfoServiceImpl(OperationDeviceInfoRepository operationDeviceInfoRepository) {
        this.operationDeviceInfoRepository = operationDeviceInfoRepository;
    }

    private Integer getId(OperationDeviceInfo operationDeviceInfo) {
        return operationDeviceInfo.getOperationNumber();
    }

    @Override
    public OperationDeviceInfo saveOperationDeviceInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationDeviceInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, OperationDeviceInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        return this.save(parseObject);
    }

    @Override
    public OperationDeviceInfo listByOperationNumber(int operationNumber) {
        return operationDeviceInfoRepository.findByOperationNumber(operationNumber);
    }


    @CacheEvict(allEntries = true)
    @Override
    public OperationDeviceInfo save(OperationDeviceInfo t) {
        // 首先查询是否存在该条数据
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(operationDeviceInfoRepository.findById(getId(t)).orElse(null));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(operationDeviceInfoRepository, t);
    }


    @CacheEvict(allEntries = true)
    @Override
    public void update(OperationDeviceInfo t) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(operationDeviceInfoRepository, getId(t), t);
    }

    @Override
    public List<OperationDeviceInfo> listById(Object id) {
        return null;
    }

    @Override
    public void delete(OperationDeviceInfo t) {
        // 判断t是否为null，同时查询t是否存在在数据库中，如果存在则删除
        if (Objects.nonNull(t) && Objects.nonNull(t = getDataBaseEntity(t))) {
            operationDeviceInfoRepository.delete(t);
            // TODO 打印需不需要提取出来
            log.info("delete:{}", t.toString());
        }
    }

    @Override
    public List<OperationDeviceInfo> listAll(int page, int size) {
        Page<OperationDeviceInfo> searchResult = operationDeviceInfoRepository.findAll(PageRequest.of(page, size));
        return ConvertUtils.convertObjectTimeStamp(searchResult.getContent());
    }


    @Override
    public long countAll() {
        return operationDeviceInfoRepository.count();
    }

    /**
     * 通过T中的数据查询数据库中完整的字段
     *
     * @param operationDeviceInfo 泛型
     * @return 数据库中完整的字段
     */
    private OperationDeviceInfo getDataBaseEntity(OperationDeviceInfo operationDeviceInfo) {
        return operationDeviceInfoRepository.findByOperationNumber(operationDeviceInfo.getOperationNumber());
    }
}
