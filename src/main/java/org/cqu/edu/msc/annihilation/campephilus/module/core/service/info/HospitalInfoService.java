package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.HospitalInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface HospitalInfoService {

    /**
     * 保存
     *
     * @param hospitalInfo
     */
    HospitalInfo save(HospitalInfo hospitalInfo);

    /**
     * 更新
     *
     * @param hospitalInfo
     */
    void update(HospitalInfo hospitalInfo);

    List<HospitalInfo> listById(Object id);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<HospitalInfo> listAll(int page, int size);

    /**
     * 删除
     *
     * @param hospitalInfo
     */
    void delete(HospitalInfo hospitalInfo);

    long countAll();
}
