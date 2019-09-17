package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read;

import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.DeviceCodeEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataListService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl.Norwamd9002sDataListServiceImpl;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl.PearlcareYy106DataListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/9
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Component
public class DataListFactory {

    private final Norwamd9002sDataListServiceImpl norwamd9002sDataListService;
    private final PearlcareYy106DataListServiceImpl pearlcareYy106DataListService;

    private static final HashMap<Integer, DataListService> dataListServiceMap = new HashMap<>();

    @Autowired
    public DataListFactory(Norwamd9002sDataListServiceImpl norwamd9002sDataListService, PearlcareYy106DataListServiceImpl pearlcareYy106DataListService) {
        this.norwamd9002sDataListService = norwamd9002sDataListService;
        this.pearlcareYy106DataListService = pearlcareYy106DataListService;
        dataListServiceMap.put(DeviceCodeEnum.NUO_HE.getCode(), this.norwamd9002sDataListService);
        dataListServiceMap.put(DeviceCodeEnum.PU_KE.getCode(), this.pearlcareYy106DataListService);
    }

    public static DataListService getDataSaveService(int deviceCode) {
        return dataListServiceMap.getOrDefault(deviceCode, null);
    }
}