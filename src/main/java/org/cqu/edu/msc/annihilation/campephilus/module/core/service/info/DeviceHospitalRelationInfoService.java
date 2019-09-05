package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceHospitalRelationInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface DeviceHospitalRelationInfoService {

    /**
     * 保存
     *
     * @param deviceHospitalRelationInfo
     */
    DeviceHospitalRelationInfo save(DeviceHospitalRelationInfo deviceHospitalRelationInfo);

    /**
     * 更新
     *
     * @param deviceHospitalRelationInfo
     */
    void update(DeviceHospitalRelationInfo deviceHospitalRelationInfo);

    List<DeviceHospitalRelationInfo> listById(Object id);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<DeviceHospitalRelationInfo> listAll(int page, int size);

    /**
     * 删除
     *
     * @param deviceHospitalRelationInfo
     */
    void delete(DeviceHospitalRelationInfo deviceHospitalRelationInfo);

    long countAll();
}
