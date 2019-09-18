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

    private static final HashMap<Integer, DataListService> DATA_LIST_SERVICE_MAP = new HashMap<>();

    @Autowired
    public DataListFactory(Norwamd9002sDataListServiceImpl norwamd9002sDataListService, PearlcareYy106DataListServiceImpl pearlcareYy106DataListService) {
        DATA_LIST_SERVICE_MAP.put(DeviceCodeEnum.NUO_HE.getCode(), norwamd9002sDataListService);
        DATA_LIST_SERVICE_MAP.put(DeviceCodeEnum.PU_KE.getCode(), pearlcareYy106DataListService);
    }

    public static DataListService getDataListService(int deviceCode) {
        return DATA_LIST_SERVICE_MAP.getOrDefault(deviceCode, null);
    }
}