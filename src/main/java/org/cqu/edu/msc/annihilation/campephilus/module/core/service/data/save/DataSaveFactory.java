package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save;

import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.DeviceCodeEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.service.DataSaveService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.service.impl.Norwamd9002sDataSaveServiceImpl;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.service.impl.PearlcareYy106DataSaveServiceImpl;
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
public class DataSaveFactory {

    private static final HashMap<Integer, DataSaveService> DATA_LIST_SAVE_MAP = new HashMap<>();

    @Autowired
    public DataSaveFactory(Norwamd9002sDataSaveServiceImpl norwamd9002sDataSaveService, PearlcareYy106DataSaveServiceImpl pearlcareYy106DataSaveService) {
        DATA_LIST_SAVE_MAP.put(DeviceCodeEnum.NUO_HE.getCode(), norwamd9002sDataSaveService);
        DATA_LIST_SAVE_MAP.put(DeviceCodeEnum.PU_KE.getCode(), pearlcareYy106DataSaveService);
    }

    public static DataSaveService getDataSaveService(Integer deviceCode) {
        return DATA_LIST_SAVE_MAP.getOrDefault(deviceCode, null);
    }

}