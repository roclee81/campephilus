package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save;

import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.DeviceCodeEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.service.DataSaveService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.service.impl.Norwamd9002sDataSaveServiceImpl;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.service.impl.PearlcareYy106DataSaveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

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
        DATA_LIST_SAVE_MAP.put(DeviceCodeEnum.NORWAMD_9002S.getCode(), norwamd9002sDataSaveService);
        DATA_LIST_SAVE_MAP.put(DeviceCodeEnum.PEARLCARE_YY106.getCode(), pearlcareYy106DataSaveService);
    }

    public static int save(Integer deviceCode, String data) {
        DataSaveService dataSaveService = DATA_LIST_SAVE_MAP.getOrDefault(deviceCode, null);
        if (Objects.isNull(dataSaveService)) {
            return -1;
        }
        return dataSaveService.save(data);
    }

}