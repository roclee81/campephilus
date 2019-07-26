package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationMarkInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class OperationMarkInfoServiceImpl extends AbstractInfoService<OperationMarkInfo, Integer> implements OperationMarkInfoService {

    private final OperationMarkInfoRepository operationMarkInfoRepository;

    @Autowired
    public OperationMarkInfoServiceImpl(OperationMarkInfoRepository operationMarkInfoRepository) {
        this.operationMarkInfoRepository = operationMarkInfoRepository;
    }

    @Override
    public JpaRepository<OperationMarkInfo, Integer> getJpaRepository() {
        return operationMarkInfoRepository;
    }

    @Override
    protected Integer getId(OperationMarkInfo operationMarkInfo) {
        return operationMarkInfo.getId();
    }

    @Override
    public void saveOperationMarkInfoFromInstrumentForm(InstrumentForm instrumentForm) {
        OperationMarkInfo parseObject = ParseJsonUtil.parseJsonString(instrumentForm, OperationMarkInfo.class);
        if (null != parseObject) {
            parseObject.setOperationNumber(instrumentForm.getOperationNumber());
        }
        this.save(parseObject);
    }

    @Override
    public void save(OperationMarkInfo operationMarkInfo) {
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudUtils.saveObjectAndCheckSuccess(operationMarkInfoRepository, operationMarkInfo);
    }

    @Override
    public List<OperationMarkInfo> listAll(int page, int size) {
        return convertMarkTime(super.listAll(page, size));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OperationMarkInfo> listByOperationNumber(int operationNumber) {
        return convertMarkTime((List<OperationMarkInfo>) ConvertUtils.convertObjectTimeStamp(operationMarkInfoRepository.findByOperationNumber(operationNumber)));
    }

    private List<OperationMarkInfo> convertMarkTime(List<OperationMarkInfo> list) {
        return list
                .parallelStream()
                .peek(t -> t.setLongMarkTime(TimeStampUtils.getTimeStampOfTimeStampObject(t.getMarkTime())))
                .collect(Collectors.toList());
    }

}
