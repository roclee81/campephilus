package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.constant.CacheConstant;
import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.info.OperationMarkInfoDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationMarkInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationMarkInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationMarkInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 16:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@CacheConfig(cacheNames = CacheConstant.CACHE_NAME_INFO_OPERATION_MARK)
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
    public List<OperationMarkInfoDTO> listOperationMarkInfoDTO(int page, int size) {
        return convertOperationMarkInfoDTOList(this.listAll(page, size));
    }

    @Override
    public OperationMarkInfo save(OperationMarkInfo operationMarkInfo) {
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(operationMarkInfoRepository, operationMarkInfo);
    }

    @Override
    public List<OperationMarkInfo> listAll(int page, int size) {
        return convertMarkTime(super.listAll(page, size));
    }

    @Override
    public List<OperationMarkInfoDTO> listOperationMarkInfoDTOByOperationNumber(int operationNumber) {
        List<OperationMarkInfo> operationMarkInfoList =
                convertMarkTime(
                        ConvertUtils.convertObjectTimeStamp(
                                operationMarkInfoRepository.findByOperationNumber(operationNumber)));

        return convertOperationMarkInfoDTOList(operationMarkInfoList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseEnum saveList(InstrumentForm instrumentForm) {
        OperationMarkInfo[] operationMarkInfos =
                ParseJsonUtil.parseJsonString(instrumentForm, OperationMarkInfo[].class);
        fillDefaultValue(instrumentForm, operationMarkInfos);
        saveList(operationMarkInfos);
        return ResponseEnum.SUCCESS;
    }

    public ResponseEnum saveList(OperationMarkInfo[] operationMarkInfoList) {
        operationMarkInfoRepository.saveAll(Arrays.asList(operationMarkInfoList));
        return ResponseEnum.SUCCESS;
    }

    private static void fillDefaultValue(InstrumentForm instrumentForm, OperationMarkInfo[] operationMarkInfoList) {
        for (OperationMarkInfo operationMarkInfo : operationMarkInfoList) {
            operationMarkInfo.setOperationNumber(instrumentForm.getOperationNumber());
        }
    }

    private List<OperationMarkInfo> convertMarkTime(List<OperationMarkInfo> list) {
        return list.parallelStream()
                .peek(t -> t.setLongMarkTime(TimeStampUtils.getTimeStampOfTimeStampObject(t.getMarkTime())))
                .collect(Collectors.toList());
    }

    private static List<OperationMarkInfoDTO> convertOperationMarkInfoDTOList(List<OperationMarkInfo> operationMarkInfoList) {
        return operationMarkInfoList
                .parallelStream()
                .map(OperationMarkInfoDTO::convertOperationMarkInfoDTO)
                .collect(Collectors.toList());
    }

}
