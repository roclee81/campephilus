package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.HospitalInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.HospitalInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ServiceSaveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:55
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class HospitalInfoServiceImpl implements HospitalInfoService {

    private final HospitalInfoRepository hospitalInfoRepository;

    @Autowired
    public HospitalInfoServiceImpl(HospitalInfoRepository hospitalInfoRepository) {
        this.hospitalInfoRepository = hospitalInfoRepository;
    }

    @Override
    public synchronized void saveHospitalInfo(HospitalInfo hospitalInfo) {
        checkId(hospitalInfo);
        // 首先查询是否存在该条数据，根据hospitalId查询
        Optional searchResult = hospitalInfoRepository.findById(hospitalInfo.getHospitalCode());
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(searchResult);
        // 判断保存是否成功，不成功将抛出异常
        ServiceSaveUtils.saveObjectAndCheckSuccess(hospitalInfoRepository, hospitalInfo);
    }

    @Override
    public List<HospitalInfo> listAllOperationInfo(int page, int size) {
        Page<HospitalInfo> searchResult = hospitalInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void updateHospitalInfo(HospitalInfo hospitalInfo) {
        checkId(hospitalInfo);
        // 首先查询是否存在该条数据，根据hospitalId查询
        Optional searchResultOptional = hospitalInfoRepository.findById(hospitalInfo.getHospitalCode());
        if (searchResultOptional.isEmpty()) {
            throw new SaveException(ResponseEnum.UPDATE_ID_ERROR);
        }
        HospitalInfo result = hospitalInfoRepository.save(hospitalInfo);
        SaveException.checkSaveSuccess(result, hospitalInfo);
    }

    private void checkId(HospitalInfo hospitalInfo) {
        if (null == hospitalInfo.getHospitalCode()) {
            throw new SaveException(ResponseEnum.DATA_FORMAT_ERROR);
        }
    }

}
