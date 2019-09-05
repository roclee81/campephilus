package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.DeviceInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:09
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface DeviceInfoService {

    /**
     * 保存
     *
     * @param deviceInfo
     */
    DeviceInfo save(DeviceInfo deviceInfo);

    /**
     * 更新
     *
     * @param deviceInfo
     */
    void update(DeviceInfo deviceInfo);

    List<DeviceInfo> listById(Object id);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<DeviceInfo> listAll(int page, int size);

    /**
     * 删除
     *
     * @param deviceInfo
     */
    void delete(DeviceInfo deviceInfo);

    long countAll();
}
