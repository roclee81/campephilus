package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.HospitalInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.HospitalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
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
public class HospitalInfoServiceImpl extends AbstractInfoService<HospitalInfo,String> implements HospitalInfoService {

    private final HospitalInfoRepository hospitalInfoRepository;

    @Autowired
    public HospitalInfoServiceImpl(HospitalInfoRepository hospitalInfoRepository) {
        this.hospitalInfoRepository = hospitalInfoRepository;
    }

    @Override
    public JpaRepository<HospitalInfo, String> getJpaRepository() {
        return hospitalInfoRepository;
    }

    @Override
    protected String getId(HospitalInfo hospitalInfo) {
        return hospitalInfo.getHospitalCode();
    }

    @Override
    public synchronized void saveHospitalInfo(HospitalInfo hospitalInfo) {
        // 首先查询是否存在该条数据，根据hospitalId查询
        // 判断到存在该仪器存在，则直接返回，抛出异常
        SaveException.checkDataIsExist(hospitalInfoRepository.findById(hospitalInfo.getHospitalCode()));
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudUtils.saveObjectAndCheckSuccess(hospitalInfoRepository, hospitalInfo);
    }

    @Override
    public void save(HospitalInfo hospitalInfo) {
        this.saveHospitalInfo(hospitalInfo);
    }
}
