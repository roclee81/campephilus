package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationMarkInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class OperationMarkInfoServiceImpl implements OperationMarkInfoService {

    private final OperationMarkInfoRepository operationMarkInfoRepository;

    @Autowired
    public OperationMarkInfoServiceImpl(OperationMarkInfoRepository operationMarkInfoRepository) {
        this.operationMarkInfoRepository = operationMarkInfoRepository;
    }

    @Override
    public void saveOperationMarkInfo(OperationMarkInfo operationMarkInfo) {
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudUtils.saveObjectAndCheckSuccess(operationMarkInfoRepository, operationMarkInfo);
    }

    @Override
    public List<OperationMarkInfo> listAllOperationMarkInfo(int page, int size) {
        Page<OperationMarkInfo> searchResult = operationMarkInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void updateOperationMarkInfo(OperationMarkInfo operationMarkInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudUtils.updateObjectAndCheckSuccess(operationMarkInfoRepository, operationMarkInfo.getId(), operationMarkInfo);
    }

    @Override
    public void saveOperationMarkInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationMarkInfo parseObject = ParseJsonUtil.parseJsonString(instrumentForm, OperationMarkInfo.class);
        if (null != parseObject) {
            parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        }
        this.saveOperationMarkInfo(parseObject);
    }

    @Override
    public void save(OperationMarkInfo operationMarkInfo) {
        this.saveOperationMarkInfo(operationMarkInfo);
    }

    @Override
    public void update(OperationMarkInfo operationMarkInfo) {
        this.updateOperationMarkInfo(operationMarkInfo);
    }

    @Override
    public List<OperationMarkInfo> listAll(int page, int size) {
        return this.listAllOperationMarkInfo(page, size);
    }

    @Override
    public void delete(OperationMarkInfo operationMarkInfo) {

    }
}
