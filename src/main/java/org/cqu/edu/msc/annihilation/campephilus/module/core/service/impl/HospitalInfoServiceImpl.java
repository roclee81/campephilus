package org.cqu.edu.msc.annihilation.campephilus.module.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.HospitalInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.HospitalInfoService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ServiceSaveUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.utils.ServiceUpdateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
        // 首先查询是否存在该条数据，根据hospitalId查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(hospitalInfoRepository.findById(hospitalInfo.getHospitalCode()));
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
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceUpdateUtils.updateObjectAndCheckSuccess(hospitalInfoRepository, hospitalInfo.getHospitalCode(), hospitalInfo);
    }

}
