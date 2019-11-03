package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationMarkInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION_MARK)
@Service
public class OperationMarkInfoServiceImpl implements OperationMarkInfoService {

    @Autowired
    private OperationMarkInfoRepository repository;

    @Override
    public ResultDTO save(OperationMarkInfo t) {
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, t);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void saveOperationMarkInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationMarkInfo parseObject = ParseJsonUtil.parseJsonString(instrumentForm, OperationMarkInfo.class);
        if (null != parseObject) {
            parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        }
        this.save(parseObject);
    }

    @Override
    public ResultDTO list(int page, int size) {
        return ServiceCrudCheckUtils.listObjectAndCheck(repository, page, size);
    }

    @Override
    public List<OperationMarkInfo> listOperationMarkInfoDTOByOperationNumber(int operationNumber) {
        return repository.findByOperationNumber(operationNumber);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultDTO saveList(InstrumentForm instrumentForm) {
        OperationMarkInfo[] operationMarkInfos =
                ParseJsonUtil.parseJsonString(instrumentForm, OperationMarkInfo[].class);
        fillDefaultValue(instrumentForm, operationMarkInfos);
        return ServiceCrudCheckUtils.saveObjectAndCheck(
                repository, operationMarkInfos);
    }

    private static void fillDefaultValue(InstrumentForm instrumentForm, OperationMarkInfo[] operationMarkInfoList) {
        for (OperationMarkInfo operationMarkInfo : operationMarkInfoList) {
            operationMarkInfo.setOperationNumber(instrumentForm.getOperationNumber());
        }
    }

}
