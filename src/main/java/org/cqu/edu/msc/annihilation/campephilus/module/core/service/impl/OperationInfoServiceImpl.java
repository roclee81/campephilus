package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.OperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ServiceSaveUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ServiceUpdateUtils;
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
    public synchronized void saveOperationInfo(OperationInfo operationInfo) {
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(operationInfoRepository.findById(operationInfo.getOperationNumber()));
        // 判断保存是否成功，不成功将抛出异常
        ServiceSaveUtils.saveObjectAndCheckSuccess(operationInfoRepository, operationInfo);
    }

    @Override
    public List<OperationInfo> listAllOperationInfo(int page, int size) {
        Page<OperationInfo> searchResult = operationInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void updateOperationInfo(OperationInfo operationInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceUpdateUtils.updateObjectAndCheckSuccess(operationInfoRepository, operationInfo.getOperationNumber(), operationInfo);
    }

    @Override
    public void saveOperationInfoFromParseDataDTO(ParseDataDTO parseDataDTO) {
        OperationInfo parseObject = ParseJsonUtil.parseJsonString(parseDataDTO, OperationInfo.class, "operationInfo");
        parseObject.setOperationNumber(parseDataDTO.getOperationNumber());

        // TODO
//        parseObject.setOperationDevice(String.join(",", parseObject.getDeviceInfo()));
        this.saveOperationInfo(parseObject);
    }

    @Override
    public Integer countOperationInfo() {
        return Math.toIntExact(operationInfoRepository.count());
    }

    @Override
    public void save(OperationInfo operationInfo) {
        this.saveOperationInfo(operationInfo);
    }

    @Override
    public void update(OperationInfo operationInfo) {
        this.updateOperationInfo(operationInfo);
    }

    @Override
    public List<OperationInfo> listAll(int page, int size) {
        return this.listAllOperationInfo(page, size);
    }

    @Override
    public void delete(OperationInfo operationInfo) {

    }
}
