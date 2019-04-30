package org.cqu.edu.msc.annihilation.campephilus.module.app.service;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.HospitalInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface HospitalInfoService {

    void saveHospitalInfo(HospitalInfo hospitalInfo);

    List<HospitalInfo> listAllOperationInfo(int page, int size);

    void updateHospitalInfo(HospitalInfo hospitalInfo);
}
