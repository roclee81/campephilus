package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.common.exception.SaveException;
import org.cqu.edu.msc.annihilation.common.utils.ServiceCrudUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.OperationDeviceInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.OperationDeviceInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/28 13:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class OperationDeviceInfoServiceImpl implements OperationDeviceInfoService {

    private final OperationDeviceInfoRepository operationDeviceInfoRepository;

    @Autowired
    public OperationDeviceInfoServiceImpl(OperationDeviceInfoRepository operationDeviceInfoRepository) {
        this.operationDeviceInfoRepository = operationDeviceInfoRepository;
    }

    @Override
    public void save(OperationDeviceInfo operationDeviceInfo) {
        // 首先查询是否存在该条数据，根据OperationNumber查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(operationDeviceInfoRepository.findById(operationDeviceInfo.getOperationNumber()));
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudUtils.saveObjectAndCheckSuccess(operationDeviceInfoRepository, operationDeviceInfo);
    }

    @Override
    public void update(OperationDeviceInfo operationDeviceInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudUtils.updateObjectAndCheckSuccess(operationDeviceInfoRepository, operationDeviceInfo.getOperationNumber(), operationDeviceInfo);
    }

    @Override
    public List<OperationDeviceInfo> listAll(int page, int size) {
        Page<OperationDeviceInfo> searchResult = operationDeviceInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void delete(OperationDeviceInfo operationDeviceInfo) {

    }

    @Override
    public void saveOperationDeviceInfoFromParseDataDTO(ParseDataDTO parseDataDTO) {
        OperationDeviceInfo parseObject = ParseJsonUtil.parseJsonString(parseDataDTO, OperationDeviceInfo.class, "operationDeviceInfo");
        parseObject.setOperationNumber(parseDataDTO.getOperationNumber());
        this.save(parseObject);
    }

    @Override
    public OperationDeviceInfo listByOperationNumber(int operationNumber) {
        return operationDeviceInfoRepository.findByOperationNumber(operationNumber);
    }
}
