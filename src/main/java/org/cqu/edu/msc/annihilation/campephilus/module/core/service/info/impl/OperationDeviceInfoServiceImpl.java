package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationDeviceInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationDeviceInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
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

    @Override
    public void saveOperationDeviceInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationDeviceInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, OperationDeviceInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        this.save(parseObject);
    }

    @Override
    public OperationDeviceInfo listByOperationNumber(int operationNumber) {
        return operationDeviceInfoRepository.findByOperationNumber(operationNumber);
    }

}
