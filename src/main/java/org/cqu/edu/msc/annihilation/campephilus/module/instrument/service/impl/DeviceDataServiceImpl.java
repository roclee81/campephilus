package org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data.Norwamd9002sData;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.data.PearlcareYy106Data;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.ParseException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.impl.Norwamd9002sDataServiceImpl;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.impl.PearlcareYy106DataServiceImpl;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.*;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity.DataNuoHe;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.parse.entity.DataPuKe;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.DeviceDataService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/10 11:28
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class DeviceDataServiceImpl implements DeviceDataService {

    private final Norwamd9002sDataServiceImpl norwamd9002sDataService;
    private final PearlcareYy106DataServiceImpl pearlcareYy106DataService;

    public DeviceDataServiceImpl(Norwamd9002sDataServiceImpl norwamd9002sDataService, PearlcareYy106DataServiceImpl pearlcareYy106DataService) {
        this.norwamd9002sDataService = norwamd9002sDataService;
        this.pearlcareYy106DataService = pearlcareYy106DataService;
    }

    @Override
    public void saveDeviceData(Integer operationNumber, String jsonData) {
        HashMap<String, Object> result = DeviceDataParser.parseDeviceData(jsonData);
        if (result.size() == 0) {
            ParseException.error(result);
        }
        for (String key : result.keySet()) {
            if ("30".equals(key)) {
                DataNuoHe dataNuoHe = (DataNuoHe) result.get("30");
                Norwamd9002sData norwamd9002sData = new Norwamd9002sData();
                norwamd9002sData.setSerialNumber(dataNuoHe.getSerialNumber());
                norwamd9002sData.setOperationNumber(operationNumber);
                norwamd9002sData.setBS(Integer.parseInt(dataNuoHe.getBS()));
                norwamd9002sData.setSQI(Integer.parseInt(dataNuoHe.getSQI()));
                norwamd9002sData.setEMG(Integer.parseInt(dataNuoHe.getEMG()));
                norwamd9002sData.setCSI(Integer.parseInt(dataNuoHe.getCSI()));
                norwamd9002sDataService.save(norwamd9002sData);
            } else if ("31".equals(key)) {
                DataPuKe dataPuKe = (DataPuKe) result.get("31");
                PearlcareYy106Data pearlcareYy106Data = new PearlcareYy106Data();
                pearlcareYy106Data.setSerialNumber(dataPuKe.getSerialNumber());
                pearlcareYy106Data.setOperationNumber(operationNumber);
                pearlcareYy106Data.setEMG(Integer.parseInt(dataPuKe.getEMG()));
                pearlcareYy106Data.setSQI(Integer.parseInt(dataPuKe.getSQI()));
                pearlcareYy106Data.setBSR(Integer.parseInt(dataPuKe.getBSR()));
                pearlcareYy106Data.setAI(Integer.parseInt(dataPuKe.getAi()));
                pearlcareYy106DataService.save(pearlcareYy106Data);
            }
        }
    }
}
