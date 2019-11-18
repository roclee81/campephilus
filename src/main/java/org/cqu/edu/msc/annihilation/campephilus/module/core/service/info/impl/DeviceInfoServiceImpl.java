package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.DeviceInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/29 15:10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

    @Autowired
    private DeviceInfoRepository repository;
}
