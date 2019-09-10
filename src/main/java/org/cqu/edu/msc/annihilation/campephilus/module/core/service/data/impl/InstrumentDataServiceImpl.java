package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.Norwamd9002sData;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.InstrumentDataService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.core.Norwamd9002sDataService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.core.PearlcareYy106DataService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.DataSaveFactory;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.DataSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/9
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */

@Service
public class InstrumentDataServiceImpl implements InstrumentDataService {

    @Autowired
    private PearlcareYy106DataService pearlcareYy106DataService;

    @Autowired
    private Norwamd9002sDataService norwamd9002sDataService;

    @Override
    public List<Object> listByOperationNumberAndSerialNumber(
            int operationNumber, String deviceCode, String serialNumber, int page, int size) {
        switch (deviceCode) {
            
        }
        return null;
    }

    private void save() {
        DataSaveService dataSaveService = DataSaveFactory.getDataSaveService("1");
        dataSaveService.save(new Norwamd9002sData());

    }
}