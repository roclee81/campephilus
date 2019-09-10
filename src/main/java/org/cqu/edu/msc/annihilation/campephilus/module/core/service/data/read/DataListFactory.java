package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataListService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl.Norwamd9002sDataListServiceImpl;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl.PearlcareYy106DataListServiceImpl;

import java.util.HashMap;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/9
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class DataListFactory {

    private static HashMap<String, DataListService> dataListServiceMap = new HashMap<>();

    static {
        dataListServiceMap.put("1", new Norwamd9002sDataListServiceImpl());
        dataListServiceMap.put("2", new PearlcareYy106DataListServiceImpl());
    }

    public static DataListService getDataSaveService(String deviceCode) {
        return dataListServiceMap.get(deviceCode);
    }
}