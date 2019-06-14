package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.cache.CacheRemove;
import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:05
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class OperationInfoServiceImpl implements OperationInfoService {

    private final OperationInfoRepository operationInfoRepository;

    @Autowired
    public OperationInfoServiceImpl(OperationInfoRepository operationInfoRepository) {
        this.operationInfoRepository = operationInfoRepository;
    }

    @Override
    public void saveOperationInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationInfo parseObject = ParseJsonUtil.parseJsonString(instrumentForm, OperationInfo.class, "operationInfo");
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
        SaveException.checkDataIsNotExist(queryResult);
        return queryResult.getOperationState();
    }

    @Override
    @CacheRemove(value = CacheConstant.CACHE_NAME_INFO_OPERATION)
    public void updateOperationStartTimeFromInstrumentForm(InstrumentForm instrumentForm) {
        // 首先查询是否存在该条数据，根据OperationNumber查询
        OperationInfo queryResult = operationInfoRepository.findByOperationNumber(instrumentForm.getOperationNumber());
        // 判断到数据不存在则抛出错误
        SaveException.checkDataIsNotExist(queryResult);
        queryResult.setOperationStartTime(LocalDateTime.now());
        queryResult.setOperationState(1);
        this.update(queryResult);
    }

    @Override
//    @CacheRemove(value = CacheConstant.CACHE_NAME_INFO_OPERATION)
    public void updateOperationEndTimeFromInstrumentForm(InstrumentForm instrumentForm) {
        // 首先查询是否存在该条数据，根据OperationNumber查询
        OperationInfo queryResult = operationInfoRepository.findByOperationNumber(instrumentForm.getOperationNumber());
        // 判断到数据不存在则抛出错误
        SaveException.checkDataIsNotExist(queryResult);
        queryResult.setOperationEndTime(LocalDateTime.now());
        queryResult.setOperationState(2);
        this.update(queryResult);
    }

    @Override
    public synchronized void save(OperationInfo operationInfo) {
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(operationInfoRepository.findById(operationInfo.getOperationNumber()));
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudUtils.saveObjectAndCheckSuccess(operationInfoRepository, operationInfo);
    }

    @Override
    public void update(OperationInfo operationInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudUtils.updateObjectAndCheckSuccess(operationInfoRepository, operationInfo.getOperationNumber(), operationInfo);
    }

    @Override
    public List<OperationInfo> listAll(int page, int size) {
        Page<OperationInfo> searchResult = operationInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void delete(OperationInfo operationInfo) {

    }
}
