package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationDeviceInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationDeviceInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION_DEVICE)
@Service
public class OperationDeviceInfoServiceImpl extends AbstractInfoService<OperationDeviceInfo, Integer> implements OperationDeviceInfoService {

    private final OperationDeviceInfoRepository operationDeviceInfoRepository;

    @Autowired
    public OperationDeviceInfoServiceImpl(OperationDeviceInfoRepository operationDeviceInfoRepository) {
        this.operationDeviceInfoRepository = operationDeviceInfoRepository;
    }

    @Override
    public JpaRepository<OperationDeviceInfo, Integer> getJpaRepository() {
        return operationDeviceInfoRepository;
    }

    @Override
    protected Integer getId(OperationDeviceInfo operationDeviceInfo) {
        return operationDeviceInfo.getOperationNumber();
    }

    @CacheEvict(allEntries = true)
    @Override
    public OperationDeviceInfo saveOperationDeviceInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationDeviceInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, OperationDeviceInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        return this.save(parseObject);
    }

    @Override
    public OperationDeviceInfo getByOperationNumber(int operationNumber) {
        return operationDeviceInfoRepository.findByOperationNumber(operationNumber);
    }

    /**
     * 通过T中的数据查询数据库中完整的字段
     *
     * @param operationDeviceInfo 泛型
     * @return 数据库中完整的字段
     */
    @Override
    public OperationDeviceInfo getDataBaseEntity(OperationDeviceInfo operationDeviceInfo) {
        return operationDeviceInfoRepository.findByOperationNumber(operationDeviceInfo.getOperationNumber());
    }
}
