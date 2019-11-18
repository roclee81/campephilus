package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationDeviceInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationDeviceInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class OperationDeviceInfoServiceImpl implements OperationDeviceInfoService {

    @Autowired
    private OperationDeviceInfoRepository repository;

    @Override
    public ResultDTO save(OperationDeviceInfo t) {
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, t);
    }

    @Override
    public ResultDTO saveOperationDeviceInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationDeviceInfo parseObject = ParseJsonUtil.parseClassName2JsonString(instrumentForm, OperationDeviceInfo.class);
        parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        return save(parseObject);
    }

    @Override
    public OperationDeviceInfo getByOperationNumber(int operationNumber) {
        return repository.findByOperationNumber(operationNumber);
    }
}
