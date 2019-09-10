package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.impl.Norwamd9002sDataSaveServiceImpl;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.impl.PearlcareYy106DataSaveServiceImpl;

import java.util.HashMap;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/9
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class DataSaveFactory {

    private static HashMap<String, DataSaveService> dataSaveServiceMap = new HashMap<>();

    static {
        dataSaveServiceMap.put("1", new Norwamd9002sDataSaveServiceImpl());
        dataSaveServiceMap.put("2", new PearlcareYy106DataSaveServiceImpl());
    }

    public static DataSaveService getDataSaveService(String deviceCode) {
        return dataSaveServiceMap.get(deviceCode);
    }
}