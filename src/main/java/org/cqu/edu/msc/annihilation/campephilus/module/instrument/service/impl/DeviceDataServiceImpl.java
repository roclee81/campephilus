package org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.Norwamd9002sDataService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.PearlcareYy106DataService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.DeviceDataService;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/10 11:28
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class DeviceDataServiceImpl implements DeviceDataService {

    private final Norwamd9002sDataService norwamd9002sDataService;
    private final PearlcareYy106DataService pearlcareYy106DataService;

    public DeviceDataServiceImpl(Norwamd9002sDataService norwamd9002sDataService, PearlcareYy106DataService pearlcareYy106DataService) {
        this.norwamd9002sDataService = norwamd9002sDataService;
        this.pearlcareYy106DataService = pearlcareYy106DataService;
    }

    @Override
    public void saveDeviceData(Integer operationNumber, String jsonData) {

    }

    @Override
    public void saveDeviceData(String data) {

    }
}
