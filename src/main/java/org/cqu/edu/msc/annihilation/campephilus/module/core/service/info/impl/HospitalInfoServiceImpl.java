package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.common.exception.SaveException;
import org.cqu.edu.msc.annihilation.common.utils.ServiceCrudUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.HospitalInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.HospitalInfoService;
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
        ServiceCrudUtils.saveObjectAndCheckSuccess(hospitalInfoRepository, hospitalInfo);
    }

    @Override
    public List<HospitalInfo> listAllOperationInfo(int page, int size) {
        Page<HospitalInfo> searchResult = hospitalInfoRepository.findAll(PageRequest.of(page, size));
        return searchResult.getContent();
    }

    @Override
    public void updateHospitalInfo(HospitalInfo hospitalInfo) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudUtils.updateObjectAndCheckSuccess(hospitalInfoRepository, hospitalInfo.getHospitalCode(), hospitalInfo);
    }

    @Override
    public void save(HospitalInfo hospitalInfo) {
        this.saveHospitalInfo(hospitalInfo);
    }

    @Override
    public void update(HospitalInfo hospitalInfo) {
        this.updateHospitalInfo(hospitalInfo);
    }

    @Override
    public List<HospitalInfo> listAll(int page, int size) {
        return this.listAllOperationInfo(page, size);
    }

    @Override
    public void delete(HospitalInfo hospitalInfo) {

    }
}