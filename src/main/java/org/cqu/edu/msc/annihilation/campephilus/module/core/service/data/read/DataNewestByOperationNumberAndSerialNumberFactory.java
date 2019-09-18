//package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read;
//
//import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataListService;
//import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataNewestByOperationNumberAndSerialNumberService;
//import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl.Norwamd9002SDataNewestByOperationNumberAndSerialNumberServiceImpl;
//import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl.Norwamd9002sDataListServiceImpl;
//import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl.PearlcareYy106DataListServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//
///**
// * @author luoxin
// * @version V1.0
// * @date 2019/9/9
// * @email vinicolor.violet.end@gmail.com
// * Description:
// */
//@Component
//public class DataNewestByOperationNumberAndSerialNumberFactory {
//
//    private HashMap<String, DataNewestByOperationNumberAndSerialNumberService> dataNewestByOperationNumberAndSerialNumberServiceMap;
//
//    private final Norwamd9002SDataNewestByOperationNumberAndSerialNumberServiceImpl norwamd9002SDataNewestByOperationNumberAndSerialNumberService;
//
//    public DataNewestByOperationNumberAndSerialNumberFactory(Norwamd9002SDataNewestByOperationNumberAndSerialNumberServiceImpl norwamd9002SDataNewestByOperationNumberAndSerialNumberService) {
//        this.norwamd9002SDataNewestByOperationNumberAndSerialNumberService = norwamd9002SDataNewestByOperationNumberAndSerialNumberService;
//        dataNewestByOperationNumberAndSerialNumberServiceMap.put("1", norwamd9002sDataListService);
//    }
//
//    @Autowired
//    public DataNewestByOperationNumberAndSerialNumberFactory(Norwamd9002sDataListServiceImpl norwamd9002sDataListService,
//                                                             PearlcareYy106DataListServiceImpl pearlcareYy106DataListService) {
//        this.norwamd9002sDataListService = norwamd9002sDataListService;
//        this.pearlcareYy106DataListService = pearlcareYy106DataListService;
//        dataNewestByOperationNumberAndSerialNumberServiceMap = new HashMap<>();
//        dataNewestByOperationNumberAndSerialNumberServiceMap.put("1", norwamd9002sDataListService);
//        dataNewestByOperationNumberAndSerialNumberServiceMap.put("2", pearlcareYy106DataListService);
//    }
//
//    public DataListService getDataNewestByOperationNumberAndSerialNumberServiceService(String deviceCode) {
//        return dataNewestByOperationNumberAndSerialNumberServiceMap.get(deviceCode);
//    }
//}