package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read;

import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.DeviceCodeEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataGetNewestService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl.Norwamd9002SDataGetNewestServiceImpl;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl.PearlcareYy106DataGetNewestServiceImpl;
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
public class DataGetNewestFactory {

    private static final HashMap<Integer, DataGetNewestService> DATA_GET_NEWEST_SERVICE_MAP = new HashMap<>();

    @Autowired
    public DataGetNewestFactory(
            PearlcareYy106DataGetNewestServiceImpl pearlcareYy106DataGetNewestService,
            Norwamd9002SDataGetNewestServiceImpl norwamd9002SDataGetNewestService) {
        DATA_GET_NEWEST_SERVICE_MAP.put(DeviceCodeEnum.NUO_HE.getCode(), norwamd9002SDataGetNewestService);
        DATA_GET_NEWEST_SERVICE_MAP.put(DeviceCodeEnum.PU_KE.getCode(), pearlcareYy106DataGetNewestService);
    }

    public static DataGetNewestService getDataGetNewestService(int deviceCode) {
        return DATA_GET_NEWEST_SERVICE_MAP.getOrDefault(deviceCode, null);
    }
}