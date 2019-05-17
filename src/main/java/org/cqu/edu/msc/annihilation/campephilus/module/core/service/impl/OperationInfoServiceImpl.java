package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.OperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.OperationInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ServiceSaveUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        checkId(operationInfo);
        Optional searchResult = operationInfoRepository.findById(operationInfo.getOperationNumber());
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(searchResult);
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
        checkId(operationInfo);
        Optional searchResult = operationInfoRepository.findById(operationInfo.getOperationNumber());
        if (searchResult.isEmpty()) {
            throw new SaveException(ResponseEnum.UPDATE_ID_ERROR);
        }
        OperationInfo result = operationInfoRepository.save(operationInfo);
        SaveException.checkSaveSuccess(result, operationInfo);
    }

    @Override
    public void saveOperationInfoFromParseDataDTO(ParseDataDTO parseDataDTO) {
        OperationInfo parseObject = ParseJsonUtil.parseJsonString(parseDataDTO, OperationInfo.class, "operationInfo");
        parseObject.setOperationNumber(parseDataDTO.getOperationNumber());
        parseObject.setOperationDevice(String.join(",", parseObject.getDeviceInfo()));
        this.saveOperationInfo(parseObject);
    }

    @Override
    public Integer countOperationInfo() {
        return Math.toIntExact(operationInfoRepository.count());
    }

    private void checkId(OperationInfo operationInfo) {
        if (null == operationInfo.getOperationNumber()) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR);
        }
    }

}
