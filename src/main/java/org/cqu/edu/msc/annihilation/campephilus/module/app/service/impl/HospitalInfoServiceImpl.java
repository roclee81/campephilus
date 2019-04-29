package org.cqu.edu.msc.annihilation.campephilus.module.app.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.HospitalInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.HospitalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void saveHospitalInfo(HospitalInfo hospitalInfo) {
        // 首先查询是否存在该条数据，根据hospitalId查询
        Optional searchResultOptional = hospitalInfoRepository.findById(hospitalInfo.getHospitalId());
        if (searchResultOptional.isPresent()) {
            return;
        }
        HospitalInfo result = hospitalInfoRepository.save(hospitalInfo);
        SaveException.checkSaveSuccess(result, hospitalInfo);
    }
}
