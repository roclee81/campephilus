package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read;

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

    @Autowired
    private Norwamd9002sDataListServiceImpl norwamd9002sDataListService;

    @Autowired
    private PearlcareYy106DataListServiceImpl pearlcareYy106DataListService;
    
    HashMap<String, DataListService> dataListServiceMap;


    public DataListFactory(Norwamd9002sDataListServiceImpl norwamd9002sDataListService, PearlcareYy106DataListServiceImpl pearlcareYy106DataListService) {
        this.norwamd9002sDataListService = norwamd9002sDataListService;
        this.pearlcareYy106DataListService = pearlcareYy106DataListService;
    }

    private static HashMap<String, DataListService> dataListServiceMap = new HashMap<>();

    static {
        dataListServiceMap.put("1", new Norwamd9002sDataListServiceImpl());
        dataListServiceMap.put("2", new PearlcareYy106DataListServiceImpl());
    }

    public static DataListService getDataSaveService(String deviceCode) {
        return dataListServiceMap.get(deviceCode);
    }
}